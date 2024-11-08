package labs.lab3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.testng.Assert;
import org.testng.annotations.Test;

import labs.lab1.Student;
import labs.lab4.builders.StudentBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializerTest {

    private final ObjectMapper jsonMapper = new ObjectMapper();
    private final XmlMapper xmlMapper = new XmlMapper();
    private final YAMLMapper yamlMapper = new YAMLMapper();

    @Test
    public void testSerializeDeserializeJson() throws IOException {
        Student student = createStudent();

        String json = jsonMapper.writeValueAsString(student);
        System.out.println("Serialized JSON: " + json);

        String jsonFilePath = "data/student.json";
        writeToFile(json, jsonFilePath);

        Student deserializedStudent = jsonMapper.readValue(json, Student.class);
        Assert.assertEquals(student, deserializedStudent);
    }

    @Test
    public void testSerializeDeserializeXml() throws IOException {
        Student student = createStudent();

        String xml = xmlMapper.writeValueAsString(student);
        System.out.println("Serialized XML: " + xml);

        String xmlFilePath = "data/student.xml";
        writeToFile(xml, xmlFilePath);

        Student deserializedStudent = xmlMapper.readValue(xml, Student.class);
        Assert.assertEquals(student, deserializedStudent);
    }

    @Test
    public void testSerializeDeserializeYaml() throws IOException {
        Student student = createStudent();

        String yaml = yamlMapper.writeValueAsString(student);
        System.out.println("Serialized YAML: " + yaml);

        String yamlFilePath = "data/student.yaml";
        writeToFile(yaml, yamlFilePath);

        Student deserializedStudent = yamlMapper.readValue(yaml, Student.class);
        Assert.assertEquals(student, deserializedStudent);
    }

    private Student createStudent() {
        return new StudentBuilder()
                .setFirstName("Ivan")
                .setLastName("Boida")
                .setBirthDate("2000-01-01")
                .setRecordBookNumber("RB1234")
                .build();
    }

    private void writeToFile(String content, String filePath) {
        Path path = Paths.get(filePath);
        try {
            Files.createDirectories(path.getParent());
            Files.write(path, content.getBytes());
            System.out.println("Файл успішно створено: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
