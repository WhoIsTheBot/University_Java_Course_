package labs.lab3;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;

public class YamlSerializer<T> implements Serializer<T> {
    private final YAMLMapper yamlMapper = new YAMLMapper();
    private final Class<T> clazz;

    public YamlSerializer(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public String serialize(T entity) throws IOException {
        return yamlMapper.writeValueAsString(entity);
    }

    @Override
    public T deserialize(String data) throws IOException {
        return yamlMapper.readValue(data, clazz);
    }

    @Override
    public void writeToFile(T entity, File file) throws IOException {
        yamlMapper.writeValue(file, entity);
    }

    @Override
    public T readFromFile(File file) throws IOException {
        return yamlMapper.readValue(file, clazz);
    }
}
