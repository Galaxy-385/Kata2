
package software.ulpgc;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class EmployeeSummaryWriter {

    public void write(List<Employee> employees, OutputStream output)
            throws IOException {

        Map<Gender, Integer> summary = new EnumMap<>(Gender.class);

        for (Gender gender : Gender.values()) {
            summary.put(gender, 0);
        }

        for (Employee employee : employees) {
            summary.put(
                    employee.gender(),
                    summary.get(employee.gender()) + 1
            );
        }

        OutputStreamWriter writer = new OutputStreamWriter(
                output, StandardCharsets.UTF_8);

        for (Gender gender : Gender.values()) {
            writer.write(gender + ": " + summary.get(gender));
            writer.write(System.lineSeparator());
        }

        writer.flush();
    }
}
