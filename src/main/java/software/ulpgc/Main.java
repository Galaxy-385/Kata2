package software.ulpgc;

import java.io.*;
import java.net.URL;
import java.util.List;


public class Main {
    static void main() throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/sachin365123/CSV-files-for-Data-Science-and-Machine-Learning/refs/heads/main/Employee%20Dataset%20-%20TSV.txt");
        try (Reader reader = new InputStreamReader(url.openStream())) {
            List<Employee> employees = loadEmployeesFrom(reader);
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    private static List<Employee> loadEmployeesFrom(Reader reader) throws IOException {
        return loadEmployeesFrom(reader.readAllLines());
    }

    private static List<Employee> loadEmployeesFrom(List<String> strings) {
        return strings.stream().skip(1).map(Main::loadEmployeeFrom).toList();
    }

    private static Employee loadEmployeeFrom(String s) {
        return loadEmployeesFrom(s.split("\t"));
    }

    private static Employee loadEmployeesFrom(String[] split) {
        return new Employee(split[0], Gender.from(split[5]));
    }
}