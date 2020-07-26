package nio._5.path;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 静态工具类 java.nio.file.Files
 * 提供了多种操作文件系统中文件的方法,
 *  以下常用的创建、删除、访问，还比如创建符号链接，确定文件大小以及设置文件权限等
 * @author hw
 * @version on 2020/4/25
 */
public class _2_FilesDemo {
    public static void main(String[] args) {
        Path path = Paths.get("data/logging.properties");

        /**
         * exits()方法用来检查给定的Path在文件系统中是否存在，
         *  第二个参数是LinkOption类型的变长参数
         */
        boolean pathExists = Files.exists(path,
                new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
        //LinkOptions.NOFOLLOW_LINKS，表示检测时不包含符号链接文件。

        /**
         * createDirectory()
         */
        path = Paths.get("data/subdir");

        try {//如果创建成功，那么返回值就是新创建的路径。
            Path newDir = Files.createDirectory(path);
        } catch(FileAlreadyExistsException e){
            // the directory already exists.
        } catch (IOException e) {
            //something else went wrong， eg. parent directory does not exist
            e.printStackTrace();
        }


        /**
         * copy()方法可以吧一个文件从一个地址复制到另一个位置
         */
        Path sourcePath      = Paths.get("data/logging.properties");
        Path destinationPath = Paths.get("data/logging-copy.properties");

        try {
            Files.copy(sourcePath, destinationPath,
                    //可选参数 CopyOption， 替换...
                    StandardCopyOption.REPLACE_EXISTING);
        } catch(FileAlreadyExistsException e) {
            //destination file already exists
        } catch (IOException e) {
            //something else went wrong
            e.printStackTrace();
        }

        /**
         * move()、renameTo()、
         */
        sourcePath      = Paths.get("data/logging-copy.properties");
        destinationPath = Paths.get("data/subdir/logging-moved.properties");

        try {
            Files.move(sourcePath, destinationPath,
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            //moving file failed.
            e.printStackTrace();
        }

        /**
         * delete() 可以删除一个文件或目录
         */
        path = Paths.get("data/subdir/logging-moved.properties");

        try {
            Files.delete(path);
        } catch (IOException e) {
            //deleting file failed
            e.printStackTrace();
        }
    }

    public void testFileVisitor() throws IOException {
        /**
         * walkFileTree 具有递归遍历目录的功能
         * 接受一个Path和FileVisitor作为参数:
         *      Path对象是需要遍历的目录，
         *      FileVistor则会在每次遍历中被调用。
         */
        FileVisitor visitor = new FileVisitor() {
            @Override            //preVisitDirectory()在访问目录前被调用
            public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
                return null;
            }

            @Override
            public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
                return null;
            }

            @Override//visitFileFailed()调用则是在文件访问失败的时候。例如，当缺少合适的权限或者其他错误。
            public FileVisitResult visitFileFailed(Object file, IOException exc) throws IOException {
                return null;
            }

            @Override            //postVisitDirectory()在访问后调用
            public FileVisitResult postVisitDirectory(Object dir, IOException exc) throws IOException {
                return null;
            }
        };
        Path path = Paths.get("data/subdir");

        Path rootPath = Paths.get("data");
        String fileToFind = File.separator + "README.txt";
        Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String fileString = file.toAbsolutePath().toString();
                //System.out.println("pathString = " + fileString);

                if(fileString.endsWith(fileToFind)){
                    System.out.println("file found at path: " + file.toAbsolutePath());
                    return FileVisitResult.TERMINATE;
                }
                return FileVisitResult.CONTINUE;
            }
        });


        rootPath = Paths.get("data");
        String fileToFind2 = File.separator + "README.txt";
        try {
            Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String fileString = file.toAbsolutePath().toString();
                    //System.out.println("pathString = " + fileString);

                    if(fileString.endsWith(fileToFind2)){
                        System.out.println("file found at path: " + file.toAbsolutePath());
                        return FileVisitResult.TERMINATE;
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch(IOException e){
            e.printStackTrace();
        }


        rootPath = Paths.get("data/to-delete");
        try {
            Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("delete file: " + file.toString());
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    System.out.println("delete dir: " + dir.toString());
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
