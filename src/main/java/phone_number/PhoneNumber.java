package phone_number;

import java.util.Objects;

public class PhoneNumber {
    private final String regionCode;
    private final String localNumber;

    // Конструктор класса PhoneNumber
    public PhoneNumber(String regionCode, String localNumber) {
        // условие, для проверки строки - код и номер должны состоять только из цифр
        if (!regionCode.matches("\\d+") || !localNumber.matches("\\d+")) {
            throw new IllegalArgumentException("regionCode and localNumber must contain only digits");
        }
        this.regionCode = regionCode;
        this.localNumber = localNumber;
    }

    @Override
    public String toString() {
        String formattedLocalNumber; // переменная, которая хранит отформатированный localNumber
        // проверка на четное/нечетное кол-во символов в строке localNumber для верной расстановки "-"
        if (localNumber.length() % 2 == 1) {
            // если длина строки нечетная, то получем по индексу первые 3 симвода, добавляем дефис, далее с 4-го элемента делим символы на пары и добаляем между ними дефис
            formattedLocalNumber = localNumber.substring(0, 3) + "-" + localNumber.substring(3).replaceAll("(.{2})", "$1-");
        } else {
            //если кол-во символов в строке - четное, делим символы на пары и добаляем между ними дефис
            formattedLocalNumber = localNumber.replaceAll("(.{2})", "$1-");
        }
        // добавляем скобки для кода региона и убераем лидний дефис в конце строки
        return "(" + regionCode + ")" + formattedLocalNumber.replaceFirst("-$", "");
    }

    // Метод, генерирующий хэш-код для телефонного номера
    @Override
    public int hashCode() {
        return Objects.hash(regionCode, localNumber);
    }

    // Метод, сравнивающий экземпляры PhoneNumber на равенство
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PhoneNumber other = (PhoneNumber) obj;
        return regionCode.equals(other.regionCode) && localNumber.equals(other.localNumber);
    }
}
