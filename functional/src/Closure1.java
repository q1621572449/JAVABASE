import java.util.function.*;

public class Closure1 {
    int i;//ćšć±ćé
    IntSupplier makeFun(int x) {
        return () -> x + i++;
    }
}
