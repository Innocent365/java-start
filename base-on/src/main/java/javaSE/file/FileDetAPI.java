package javaSE.file;

import java.io.File;

/**
 * Created by ss on 2017/6/27.
 */
public class FileDetAPI {
    public static void main(String[] args) {
        String path = "C:\\Users\\cc531\\Downloads\\会声会影X5 Ultimate 简体中文旗舰版整合版";
        File dir = new File(path);

        deleteFile(dir);
        System.out.println("删除完毕!");

    }

    /**
     * 将给定的File对象表示的文件或目录删除。
     * @param file
     */
    public static void deleteFile(File file){
        //若file是一个目录
        if(file.isDirectory()){
            //先获取它的所有子项，并逐一删除。
            File[] subs = file.listFiles();
            for(File sub : subs){
                deleteFile(sub);
            }
        }
        file.delete();

    }
}
