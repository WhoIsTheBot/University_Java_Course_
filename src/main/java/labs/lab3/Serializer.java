package labs.lab3;

import java.io.File;
import java.io.IOException;

public interface Serializer<T> {
    String serialize(T entity) throws IOException;
    T deserialize(String data) throws IOException;
    void writeToFile(T entity, File file) throws IOException;
    T readFromFile(File file) throws IOException;
}
