package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Snow {}
class Powder extends Snow {}
class Light extends Powder {}
class Heavy extends Powder {}
class Crusty extends Snow {}
class Slush extends Snow {}

public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(//arrays就是数组吧。。。连list都不是
                new Crusty(), new Slush(), new Powder());
        //- snow1.add(new Heavy()); // Exception
        //- snow1.remove(0);        // Exception

        List<Snow> snow2 = Arrays.asList(
                new Light(), new Heavy());
        //- snow2.add(new Slush()); // Exception
        //- snow2.remove(0);        // Exception

        List<Snow> snow3 = new ArrayList<>();
        Collections.addAll(snow3,
                new Light(), new Heavy(), new Powder());
        snow3.add(new Crusty());
        snow3.remove(0);

        // Hint with explicit type argument specification:
        List<Snow> snow4 = Arrays.<Snow>asList(
                new Light(), new Heavy(), new Slush());
        //- snow4.add(new Powder()); // Exception
        //- snow4.remove(0);         // Exception
    }
}
