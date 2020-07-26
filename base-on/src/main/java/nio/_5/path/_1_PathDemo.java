package nio._5.path;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * path接口是作为Java NIO 2的一部分, 是Java6,7中NIO的升级增加部分
 * 一个Path实例代表一个文件系统内的路径。
 * path可以指向文件也可以指向目录。可以使相对路径也可以是绝对路径。
 *
 * 注意：不要把文件系统中路径和环境变量的路径混淆：
 *  java.nio.file.Path和环境变量没有任何关系
 *
 */
public class _1_PathDemo {
    public static void main(String[] args) {
        Path path1 = Paths.get("c:\\data\\myfile.txt");//windows

        Path path2 = Paths.get("/home/jakobjenkov/myfile.txt");//unix

        //创建相对路径(Creating a Relative Path)
        Path file = Paths.get("d:\\data", "projects\\a-project\\myfile.txt");

        Path currentDir = Paths.get(".");//.表示的是当前目录
        Path parentDir = Paths.get("..");//父目录或者说是上一级目录：

        //Path的normalize()方法可以把路径规范化(也就是把.和..都等价去除：)
        String originalPath = "d:\\data\\projects\\a-project\\..\\another-project";

        Path pathx = Paths.get(originalPath);
        System.out.println("pathx = " + pathx);

        Path pathy = pathx.normalize();
        System.out.println("pathy = " + pathy);

    }

}
