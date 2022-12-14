package files;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

public class PathWatcher {
    static Path test = Paths.get("test");
    static void delTxtFiles() {
        try {
            Files.walk(test)//遍历文件，筛选.txt结尾的文件，并且删除
                    .filter(f ->
                            f.toString().endsWith(".txt"))
                    .forEach(f -> {
                        try {
                            System.out.println("deleting " + f);
                            Files.delete(f);
                        } catch(IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void
    main(String[] args) throws Exception {
        Directories.refreshTestDir();
        Directories.populateTestDir();
        Files.createFile(test.resolve("Hello.txt"));//resolve() 将文件名添加到 test Path 的末尾。
        WatchService watcher =
                FileSystems.getDefault().newWatchService();
        test.register(watcher, ENTRY_DELETE);//绑定监视器和事件
        Executors.newSingleThreadScheduledExecutor()
                .schedule(
                        PathWatcher::delTxtFiles,//函数式编程
                        250, TimeUnit.MILLISECONDS);
        WatchKey key = watcher.take();
        for(WatchEvent evt : key.pollEvents()) {
            System.out.println(
                    "evt.context(): " + evt.context() +
                            "\nevt.count(): " + evt.count() +
                            "\nevt.kind(): " + evt.kind());
            System.exit(0);
        }
    }
}
/* Output:
deleting test\bag\foo\bar\baz\File.txt
deleting test\bar\baz\bag\foo\File.txt
deleting test\baz\bag\foo\bar\File.txt
deleting test\foo\bar\baz\bag\File.txt
deleting test\Hello.txt
evt.context(): Hello.txt
evt.count(): 1
evt.kind(): ENTRY_DELETE
*/
