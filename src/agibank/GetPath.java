package agibank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetPath {

    public static List<Path> findByFileExtension(Path path, String fileExtension) throws IOException {
        if(!Files.isDirectory(path)) {
            throw new IllegalArgumentException("O caminho deve ser um diretório.");
        }
        List<Path> files;
        try(Stream<Path> walk = Files.walk(path)) {
            files = walk
                    .filter(Files::isRegularFile)
                    .filter(p -> p.getFileName().toString().endsWith(fileExtension))
                    .collect(Collectors.toList());
        }
        return files;
    }
}
