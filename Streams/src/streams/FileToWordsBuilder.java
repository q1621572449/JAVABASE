package streams;

import java.nio.file.*;
import java.util.stream.*;

public class FileToWordsBuilder {
    Stream.Builder<String> builder = Stream.builder();
    public FileToWordsBuilder(String filePath)
            throws Exception {
        Files.lines(Paths.get(filePath))
                .skip(1) // Skip the comment line at the beginning
                .forEach(line -> {
                    for(String w : line.split("[ .?,]+"))
                        builder.add(w);
                });
    }
    Stream<String> stream() { return builder.build(); }
    public static void
    main(String[] args) throws Exception {
        new FileToWordsBuilder("E:\\Javastudy\\GitHub\\JAVABASE\\Streams\\src\\Cheese.dat").stream()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}