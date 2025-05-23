import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
from datetime import datetime


def load_and_prepare_data(file_path):
    try:
        df = pd.read_csv(file_path, header=None, names=[
            'TICKER', 'PER', 'DATE', 'TIME', 'OPEN', 'HIGH', 'LOW', 'CLOSE', 'VOL'
        ])

        df = df.apply(lambda x: x.str.strip() if x.dtype == "object" else x)

        date_formats = [
            '%d/%m/%y %H:%M',  # DD/MM/YY HH:MM
            '%m/%d/%y %H:%M',  # MM/DD/YY HH:MM
            '%y/%m/%d %H:%M',  # YY/MM/DD HH:MM
            '%d-%m-%y %H:%M',  # DD-MM-YY HH:MM
        ]

        for fmt in date_formats:
            try:
                df['DATETIME'] = pd.to_datetime(df['DATE'] + ' ' + df['TIME'], format=fmt)
                break

            except ValueError:
                continue

        else:
            df['DATETIME'] = pd.to_datetime(df['DATE'] + ' ' + df['TIME'], dayfirst=True, errors='coerce')

            if df['DATETIME'].isnull().any():
                print("Предупреждение: Некоторые даты не распознаны и будут удалены")
                df = df.dropna(subset=['DATETIME'])

        df['DATE_ONLY'] = df['DATETIME'].dt.date

        return df

    except Exception as e:
        print(f"Ошибка при загрузке данных: {str(e)}")
        return None


def select_specific_dates(df):
    target_dates = [
        datetime(2018, 9, 9).date(),
        datetime(2018, 10, 9).date(),
        datetime(2018, 11, 9).date(),
        datetime(2018, 12, 9).date()
    ]

    filtered_df = df[df['DATE_ONLY'].isin(target_dates)].copy()

    for date in target_dates:
        if date not in df['DATE_ONLY'].values:
            next_day = date + pd.Timedelta(days=1)

            while next_day not in df['DATE_ONLY'].values:
                next_day += pd.Timedelta(days=1)

            additional_data = df[df['DATE_ONLY'] == next_day]
            filtered_df = pd.concat([filtered_df, additional_data])
            print(f"Для {date.strftime('%d/%m/%Y')} использованы данные за {next_day.strftime('%d/%m/%Y')}")

    return filtered_df


def create_boxplot_diagram(df):
    if df is None or len(df) == 0:
        print("Нет данных для построения графиков")
        return

    plt.figure(figsize=(18, 12))
    plt.suptitle('Анализ биржевых данных за 9-е число каждого месяца (2018)', fontsize=14)
    metrics = ['OPEN', 'HIGH', 'LOW', 'CLOSE']

    for i, metric in enumerate(metrics, 1):
        plt.subplot(2, 2, i)
        sns.boxplot(data=df, x='DATE_ONLY', y=metric, width=0.6, palette="vlag", fliersize=3)
        plt.title(f'Распределение цен ({metric})', fontsize=12)
        plt.xlabel('Дата', fontsize=10)
        plt.ylabel('Цена', fontsize=10)
        plt.xticks(rotation=45, fontsize=8)
        plt.yticks(fontsize=8)

    plt.tight_layout()
    plt.show()


def main():
    file_path = 'SPFB.RTS-12.18_180901_181231.csv'
    df = load_and_prepare_data(file_path)

    if df is not None:
        df_filtered = select_specific_dates(df)
        print("\nОтобранные данные:")
        print(f"Всего строк: {len(df_filtered)}")
        print("\nУникальные даты в данных:")
        print(df_filtered['DATE_ONLY'].unique())
        print("\nКоличество записей по дням:")
        print(df_filtered['DATE_ONLY'].value_counts().sort_index())
        create_boxplot_diagram(df_filtered)


if __name__ == '__main__':
    main()
