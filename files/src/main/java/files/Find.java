package files;

import java.nio.file.*;

public class Find {
    public static void
    main(String[] args) throws Exception {
        Path test = Paths.get("test");
        Directories.refreshTestDir();
        Directories.populateTestDir();
        // Creating a *directory*, not a file:
        Files.createDirectory(test.resolve("dir.tmp"));//resolve，在后面加，创建目录

        PathMatcher matcher = FileSystems.getDefault()
                .getPathMatcher("glob:**/*.{tmp,txt}");
        Files.walk(test)
                .filter(matcher::matches)
                .forEach(System.out::println);
        System.out.println("***************");

        PathMatcher matcher2 = FileSystems.getDefault()
                .getPathMatcher("glob:*.tmp");
        Files.walk(test)
                .map(Path::getFileName)
                .filter(matcher2::matches)
                .forEach(System.out::println);
        System.out.println("***************");

        Files.walk(test) // Only look for files
                .filter(Files::isRegularFile)//再次筛选，是常规文件。
                .map(Path::getFileName)
                .filter(matcher2::matches)
                .forEach(System.out::println);
    }
}
/* Output:
test\bag\foo\bar\baz\5208762845883213974.tmp
test\bag\foo\bar\baz\File.txt
test\bar\baz\bag\foo\7918367201207778677.tmp
test\bar\baz\bag\foo\File.txt
test\baz\bag\foo\bar\8016595521026696632.tmp
test\baz\bag\foo\bar\File.txt
test\dir.tmp
test\foo\bar\baz\bag\5832319279813617280.tmp
test\foo\bar\baz\bag\File.txt
***************
5208762845883213974.tmp
7918367201207778677.tmp
8016595521026696632.tmp
dir.tmp
5832319279813617280.tmp
***************
5208762845883213974.tmp
7918367201207778677.tmp
8016595521026696632.tmp
5832319279813617280.tmp
*/
