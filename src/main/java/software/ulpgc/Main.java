
package software.ulpgc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Main {

    private static final String URL_DATA =
            "https://raw.githubusercontent.com/sachin365123/CSV-files-for-Data-Science-and-Machine-Learning/refs/heads/main/Employee%20Dataset%20-%20TSV.txt";

    public static void main(String[] args) {
        String source = args.length > 0 ? args[0] : URL_DATA;
        String destination = args.length > 1 ? args[1] : "-";

        try {
            EmployeeLoader loader = new EmployeeLoader();
            EmployeeSummaryWriter writer = new EmployeeSummaryWriter();

            try (InputStream input = openInput(source)) {
                var employees = loader.load(input);

                if (destination.equals("-")) {
                    writer.write(employees, System.out);
                } else {
                    try (OutputStream output =
                                 new FileOutputStream(destination)) {
                        writer.write(employees, output);
                    }
                }
            }

        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static InputStream openInput(String source)
            throws IOException {

        if (source.startsWith("http://")
                || source.startsWith("https://")) {
            return new URL(source).openStream();
        }

        return new FileInputStream(source);
    }
}
