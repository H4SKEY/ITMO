import pandas as pd
from datetime import datetime


def filter_and_overwrite(input_file):
    df = pd.read_csv(input_file, header=None, skiprows=1, names=[
        'TICKER', 'PER', 'DATE', 'TIME', 'OPEN', 'HIGH', 'LOW', 'CLOSE', 'VOL'
    ])

    df['DATE_DT'] = pd.to_datetime(df['DATE'], format='%d/%m/%y')

    selected_dates = [
        datetime(2018, 9, 9),
        datetime(2018, 10, 9),
        datetime(2018, 11, 9),
        datetime(2018, 12, 9)
    ]

    result_df = df[df['DATE_DT'].isin(selected_dates)].copy()

    for date in selected_dates:
        if date not in df['DATE_DT'].values:
            next_day = date + pd.Timedelta(days=1)
            result_df = pd.concat([result_df, df[df['DATE_DT'] == next_day]])

    output_data = result_df[['TICKER', 'PER', 'DATE', 'TIME', 'OPEN', 'HIGH', 'LOW', 'CLOSE', 'VOL']]

    with open(input_file, 'w', newline='') as f:
        f.write("<TICKER>,<PER>,<DATE>,<TIME>,<OPEN>,<HIGH>,<LOW>,<CLOSE>,<VOL>\n")
        output_data.to_csv(f, index=False, header=False)

    print(f"Файл {input_file} успешно перезаписан.")
    print(f"Оставлено строк: {len(result_df)}")
    print("Уникальные даты в файле:", result_df['DATE_DT'].dt.date.unique())

input_file = 'SPFB.RTS-12.18_180901_181231.csv'  # Укажите ваш файл
filter_and_overwrite(input_file)
