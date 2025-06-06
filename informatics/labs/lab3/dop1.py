import re

def extract_surnames(text):
    pattern = r'\b([A-ZА-ЯЁ][a-zа-яё-]+(?:-[A-ZА-ЯЁ][a-zа-яё-]+)?)(?:\s[A-ZА-ЯЁ]\.){1,2}\b'
    matches = re.findall(pattern, text)
    surnames = set(matches)
    sorted_surnames = sorted(surnames)

    return sorted_surnames

# Тесты
tests = [
    "Студент Вася вспомнил, что на своей лекции Балакшин П.В. упоминал про старшекурсников, которые будут ему помогать: Анищенко А.А., Машина Е.А. и Голованова-Иванова Д.В.",
    "На встрече присутствовали Иванов И.И., Петров П.П. и Сидоров С.С.",
    "В этом году на олимпиаде победили Смирнов А.А. и Кузнецов Б.Б.",
    "В классе учатся: Ковалев А.А., Сидорова М.М., и Петрова Н.Н.",
    "На конференции выступали: Лебедев А.А., Лебедев-Лебедева В.В. и Лебедева Б.Б" 
]

# Ожидаемые результаты
expected_results = [
    ['Анищенко', 'Балакшин', 'Голованова-Иванова', 'Машина'],
    ['Иванов', 'Петров', 'Сидоров'],
    ['Кузнецов', 'Смирнов'],
    ['Ковалев', 'Петрова', 'Сидорова'],
    ['Лебедев', 'Лебедев-Лебедева', 'Лебедева']
]

# Проверка тестов
for i, test in enumerate(tests):
    result = extract_surnames(test)
    print(f"Тест {i + 1}:")
    print(f"Входные данные: {test}")
    print(f"Результат: {result}")
    print(f"Ожидаемый результат: {expected_results[i]}")
    print(f"Тест {'пройден' if result == expected_results[i] else 'не пройден'}\n")
