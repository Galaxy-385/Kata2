package software.ulpgc;

import java.io.IOException;
import java.io.InputStream;

public interface EmployeeSource {
    InputStream open() throws IOException;
}