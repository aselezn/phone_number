package phone_number;

import java.util.Objects;

public class PhoneNumber {
    private final String regionCode;
    private final String localNumber;

    // Конструктор класса PhoneNumber
    public PhoneNumber(String regionCode, String localNumber) {
        this.regionCode = regionCode;
        this.localNumber = localNumber;
    }

    @Override
    public String toString() {
        String formattedLocalNumber;

        if (localNumber.length() == 7) {
            formattedLocalNumber = localNumber.substring(0, 3) + "-" + localNumber.substring(3).replaceAll("(.{2})", "$1-");
        } else {
            formattedLocalNumber = localNumber.replaceAll("(.{2})", "$1-");
        }

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
