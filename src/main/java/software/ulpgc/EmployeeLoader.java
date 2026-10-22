
package software.ulpgc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class EmployeeLoader {

    public List<Employee> load(InputStream input) throws IOException {
        List<Employee> employees = new ArrayList<>();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(input, StandardCharsets.UTF_8));

        String line;
        int lineNumber = 0;

        while ((line = reader.readLine()) != null) {
            lineNumber++;

            if (lineNumber == 1 || line.isBlank()) {
                continue;
            }

            String[] columns = line.split("\t", -1);

            try {
                if (columns.length < 6 || columns[0].isBlank()) {
                    throw new IllegalArgumentException(
                            "Faltan columnas o el nombre está vacío.");
                }

                Employee employee = new Employee(
                        columns[0].trim(),
                        Gender.from(columns[5])
                );

                employees.add(employee);

            } catch (IllegalArgumentException e) {
                throw new IOException(
                        "Fila inválida en la línea " + lineNumber
                                + ": " + e.getMessage(), e);
            }
        }

        return employees;
    }
}
