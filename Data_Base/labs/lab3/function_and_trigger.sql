-- Функция для проверки допустимого значения температуры у панели

-- Проверка допустимого значения температуры у панели
CREATE OR REPLACE FUNCTION check_panel_temperature()
RETURNS TRIGGER AS $$
BEGIN
    -- Запрет на температуру выше 100 или ниже -20
    IF NEW.TEMPERATURE > 100 THEN
        RAISE EXCEPTION 'Ошибка: Температура панели %.1f°C превышает 100°C', NEW.TEMPERATURE;
    ELSIF NEW.TEMPERATURE < -20 THEN
        RAISE EXCEPTION 'Ошибка: Температура панели %.1f°C ниже -20°C', NEW.TEMPERATURE;
    END IF;

    -- Предупреждение для непрозрачных панелей (OPACITY = 1) с температурой меньше 10
    IF NEW.OPACITY = 1 AND NEW.TEMPERATURE < 10 THEN
        RAISE WARNING 'Внимание: Непрозрачная панель (ID=%) имеет низкую температуру %.1f°C', 
                      NEW.PANEL_ID, NEW.TEMPERATURE;
    END IF;

    RETURN NEW; 
END;
$$ LANGUAGE plpgsql;

--Триггер на автоматическую проверку при изменении данных
CREATE TRIGGER panel_temperature_control
BEFORE INSERT OR UPDATE ON PANEL
FOR EACH ROW
EXECUTE FUNCTION check_panel_temperature();

--Тесты

-- Попытка вставить панель с температурой 150°C (должна вызвать ошибку)
INSERT INTO PANEL (TYPE, OPACITY, TEMPERATURE, BUILDING_ID)
VALUES ('test', 0.5, 150, 1);

-- Попытка вставить панель с температурой -25°C (должна вызвать ошибку)
INSERT INTO PANEL (TYPE, OPACITY, TEMPERATURE, BUILDING_ID)
VALUES ('test', 0.5, -25, 1);

-- Корректная панель (должна добавиться)
INSERT INTO PANEL (TYPE, OPACITY, TEMPERATURE, BUILDING_ID)
VALUES ('valid', 0.5, 25, 1);

-- Непрозрачная панель с низкой температурой (должна вызвать предупреждение)
INSERT INTO PANEL (TYPE, OPACITY, TEMPERATURE, BUILDING_ID)
VALUES ('opaque', 1, 5, 1);


