def main():
    BIT_MAPPING = ['r1', 'r2', 'i1', 'r3', 'i2', 'i3', 'i4']
    CHECK_POSITIONS = [
        [3, 4, 5, 6],  # Для S1
        [1, 2, 5, 6],  # Для S2
        [0, 2, 4, 6]  # Для S3
    ]

    DATA_BITS = [2, 4, 5, 6]  # Позиции информационных битов
    input_data = get_valid_input()

    syndrome = calculate_syndrome(input_data, CHECK_POSITIONS)
    error_pos = decode_error_position(syndrome)

    if error_pos >= 0:
        input_data = flip_bit(input_data, error_pos)

    display_results(input_data, error_pos, BIT_MAPPING, DATA_BITS)


def get_valid_input():
    while True:
        user_input = input('Введите 7 бит двоичных данных: ').strip()
        if len(user_input) == 7 and all(b in '01' for b in user_input):
            return [int(bit) for bit in user_input]

        print("Ошибка! Введите ровно 7 символов (0 или 1)")


def calculate_syndrome(data, check_groups):
    syndrome = ''
    for group in check_groups:
        parity = sum(data[i] for i in group) % 2
        syndrome += str(parity)
    return syndrome


def decode_error_position(syndrome):
    return int(syndrome, 2) - 1 if syndrome != '000' else -1


def flip_bit(data, position):
    data[position] ^= 1
    return data


def display_results(data, error_pos, bit_names, data_bits):
    if error_pos == -1:
        print("Данные не содержат ошибок")

    else:
        print(f"Обнаружена ошибка в позиции {error_pos + 1}")
        print(f"Тип бита: {bit_names[error_pos]}")

    corrected_data = ''.join(str(data[i]) for i in data_bits)
    print(f"Исправленное сообщение: {corrected_data}")


if __name__ == '__main__':
    main()
