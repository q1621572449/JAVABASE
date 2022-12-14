package exceptions;

import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class InputFile2 {
    private String fname;
    public InputFile2(String fname) {
        this.fname = fname;
    }
    public
    Stream<String> getLines() throws IOException {
        return Files.lines(Paths.get(fname));
    }
    public static void
    main(String[] args) throws IOException {
        new InputFile2("Exceptions/src/exceptions/InputFile2.java").getLines()
                .skip(16)
                .limit(1)
                .forEach(System.out::println);
    }
}