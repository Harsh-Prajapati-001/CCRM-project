// com.ccrm.io.FileHandler.java
package com.ccrm.io;

import com.ccrm.model.Student;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHandler {

    public void exportStudentsToCsv(List<Student> students, String filePath) throws IOException {
        Path path = Paths.get(filePath);
        List<String> lines = students.stream()
                .map(s -> String.format("%s,%s,%s", s.getStudentId(), s.getName(), s.getEmail()))
                .collect(Collectors.toList());
        Files.write(path, lines);
    }

    public List<Student> importStudentsFromCsv(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        try (Stream<String> lines = Files.lines(path)) {
            return lines.map(line -> {
                String[] parts = line.split(",");
                return new Student(parts[0], parts[1], parts[2]);
            }).collect(Collectors.toList());
        }
    }
}
