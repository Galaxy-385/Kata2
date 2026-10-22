package software.ulpgc;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface EmployeeLoader {
    List<Employee> load(InputStream input) throws IOException;
}