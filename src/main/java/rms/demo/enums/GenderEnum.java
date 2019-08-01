package rms.demo.enums;
public enum GenderEnum {

    UNKNOWN(0), 男(1), 女(2);
    private final int value;

    GenderEnum (int value) {
        this.value = value;
    }

    public static String genderOf (int aGenderValue) {
        for (GenderEnum gender : GenderEnum.values()) {
            if (gender.value == aGenderValue) {
                return gender.toString();
            }
        }
        return GenderEnum.UNKNOWN.toString();
    }


    public int getValue () {
        return value;
    }
}
