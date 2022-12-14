import java.util.function.*;

interface FuncSS extends Function<String, String> {}   // [1]

public class ProduceFunction {
    static FuncSS produce() {
        return s -> s.toLowerCase();             // [2]返回一个方法赋给FuncSS
    }
    public static void main(String[] args) {
        FuncSS f = produce();
        System.out.println(f.apply("YELLING"));
    }
}