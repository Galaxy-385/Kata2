
package software.ulpgc;

public enum Gender {
    Male, Female;

    public static Gender from(String s) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("El género está vacío.");
        }

        try {
            return Gender.valueOf(s.trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "Género inválido: " + s
            );
        }
    }
}