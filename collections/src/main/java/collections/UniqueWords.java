package collections;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UniqueWords {
    public static void
    main(String[] args) throws Exception {
        List<String> lines = Files.readAllLines(
                Paths.get("collections\\src\\main\\java\\collections\\SetOperations.java"));
        Set<String> words = new TreeSet<>();
        for(String line : lines)
            for(String word : line.split("\\W+"))
                if(word.trim().length() > 0)
                    words.add(word);
        System.out.println(words);
    }
}
/* Output:
[A, B, C, Collections, D, E, F, G, H, HashSet, I, J, K,
L, M, N, Output, Set, SetOperations, String, System, X,
Y, Z, add, addAll, added, args, class, collections,
contains, containsAll, false, from, import, in, java,
main, new, out, println, public, remove, removeAll,
removed, set1, set2, split, static, to, true, util,
void]
*/
