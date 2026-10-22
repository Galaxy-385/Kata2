
package software.ulpgc;

public enum Gender {
    Male, Female;

    public static Gender from(String s) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("The Gender argument cannot be null or blank.");
        }

        try {
            return Gender.valueOf(s.trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "invalid Gender: " + s
            );
        }
    }
}
