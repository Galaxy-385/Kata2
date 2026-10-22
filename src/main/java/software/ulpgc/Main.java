package software.ulpgc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {

    private static final String URL_DATA =
            "https://raw.githubusercontent.com/sachin365123/CSV-files-for-Data-Science-and-Machine-Learning/refs/heads/main/Employee%20Dataset%20-%20TSV.txt";

    public static void main(String[] args) {
        String sourceArgument = args.length > 0 ? args[0] : URL_DATA;
        String destination = args.length > 1 ? args[1] : "-";

        try {
            EmployeeSource source = createSource(sourceArgument);
            EmployeeLoader loader = new TsvEmployeeLoader();
            EmployeeSummaryWriter writer = new EmployeeSummaryWriter();

            try (InputStream input = source.open()) {
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

    private static EmployeeSource createSource(String source) {
        if (source.startsWith("http://")
                || source.startsWith("https://")) {
            return new UrlEmployeeSource(source);
        }

        return new FileEmployeeSource(source);
    }

}