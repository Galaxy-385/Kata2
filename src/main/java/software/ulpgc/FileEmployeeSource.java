package software.ulpgc;

import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;

public class FileEmployeeSource implements EmployeeSource {

    private final String path;

    public FileEmployeeSource(String path) {
        this.path = path;
    }

    @Override
    public InputStream open() throws IOException {
        return new FileInputStream(path);
    }
}