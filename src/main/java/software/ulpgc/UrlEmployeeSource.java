package software.ulpgc;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class UrlEmployeeSource implements EmployeeSource {

    private final String url;

    public UrlEmployeeSource(String url) {
        this.url = url;
    }

    @Override
    public InputStream open() throws IOException {
        return new URL(url).openStream();
    }
}