import re

def extract_bitcoin_price(html_content):
    pattern = r'Цена Bitcoin в реальном времени сегодня составляет ₽([\d,]+\.\d{2}) RUB'
    match = re.search(pattern, html_content)
    
    if match:
        return match.group(1)
    
    else:
        return None

def run_tests():
    test_cases = [
        {
            "ввод": '''<meta name="daily_volume" content="В суточным объемом торгов ₽2,835,029,974,960.63 RUB."/> 
                        <meta name="daily_price" content="Мы обновляем нашу цену BTC к RUB в режиме реального времени."/> 
                        <meta name="daily_price" content=" Цена Bitcoin в реальном времени сегодня составляет ₽5,797,806.88 RUB."/>
                        <meta name="daily_price" content="Ethereum стоит на данный момент ₽229,590,78 RUB."/>''',
            "вывод": "5,797,806.88"
        },
        {
            "ввод": '''<meta name="daily_price" content="Цена Bitcoin в реальном времени сегодня составляет ₽1,234,567.89 RUB."/>''',
            "вывод": "1,234,567.89"
        },
        {
            "ввод": '''<meta name="daily_price" content="Цена Bitcoin в реальном времени сегодня составляет ₽0.01 RUB."/>''',
            "вывод": "0.01"
        },
        {
            "ввод": '''<meta name="daily_price" content="Цена Bitcoin в реальном времени сегодня составляет ₽10,000,000.00 RUB."/>''',
            "вывод": "10,000,000.00"
        },
        {
            "ввод": '''<meta name="daily_price" content="Ethereum стоит на данный момент ₽229,590,78 RUB."/>''',
            "вывод": None  # Нет информации о Bitcoin
        }
    ]

    for i, test_case in enumerate(test_cases):
        result = extract_bitcoin_price(test_case["ввод"])
        assert result == test_case["вывод"], f"Тест {i+1} не пройден: вывод {test_case['вывод']}, ответ {result}"

        print(f"Тест {i + 1} пройден.")

run_tests()
