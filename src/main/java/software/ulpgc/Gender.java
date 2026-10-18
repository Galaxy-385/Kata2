package software.ulpgc;

public enum Gender {
    Male, Female;

    public static Gender from(String s) {
        if (s.isEmpty()) return null;
        return Gender.valueOf(s);
    }
}