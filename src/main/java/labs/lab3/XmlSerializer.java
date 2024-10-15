package labs.lab3;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XmlSerializer<T> implements Serializer<T> {
    private final XmlMapper xmlMapper = new XmlMapper();
    private final Class<T> clazz;

    public XmlSerializer(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public String serialize(T entity) throws IOException {
        return xmlMapper.writeValueAsString(entity);
    }

    @Override
    public T deserialize(String data) throws IOException {
        return xmlMapper.readValue(data, clazz);
    }

    @Override
    public void writeToFile(T entity, File file) throws IOException {
        xmlMapper.writeValue(file, entity);
    }

    @Override
    public T readFromFile(File file) throws IOException {
        return xmlMapper.readValue(file, clazz);
    }
}
