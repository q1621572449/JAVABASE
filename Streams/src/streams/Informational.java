package streams;

import java.util.stream.*;
import java.util.function.*;

public class Informational {
    public static void
    main(String[] args) throws Exception {
        System.out.println(
                FileToWords.stream("Streams/src/streams/Cheese.dat").count());
        System.out.println(
                FileToWords.stream("Streams/src/streams/Cheese.dat")
                        .min(String.CASE_INSENSITIVE_ORDER)
                        .orElse("NONE"));
        System.out.println(
                FileToWords.stream("Streams/src/streams/Cheese.dat")
                        .max(String.CASE_INSENSITIVE_ORDER)
                        .orElse("NONE"));//orElse用来解包。
    }
}