
package software.ulpgc;

import java.io.*;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/sachin365123/CSV-files-for-Data-Science-and-Machine-Learning/refs/heads/main/Employee%20Dataset%20-%20TSV.txt");

        try (InputStream input = url.openStream();
             Reader reader = new InputStreamReader(input)) {
            List<Employee> employees = loadEmployeesFrom(reader);

            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    private static List<Employee> loadEmployeesFrom(Reader reader) throws IOException {
        return loadEmployeesFrom(new BufferedReader(reader).lines().toList());
    }

    private static List<Employee> loadEmployeesFrom(List<String> strings) {
        return strings.stream()
                .skip(1)
                .map(Main::loadEmployeeFrom)
                .toList();
    }

    private static Employee loadEmployeeFrom(String s) {
        return loadEmployeeFrom(s.split("\t", -1));
    }

    private static Employee loadEmployeeFrom(String[] split) {
        if (split.length < 6 || split[0].isBlank() || split[5].isBlank()) {
            throw new IllegalArgumentException("Fila inválida: faltan datos.");
        }

        return new Employee(split[0], Gender.from(split[5]));
    }
}
