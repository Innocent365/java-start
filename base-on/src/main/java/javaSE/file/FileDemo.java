package javaSE.file;



import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * java.io.File
 * 用来表示硬盘上的一个文件或目录
 * 使用File可以:
 * 		查看文件或目录的属性信息
 * 		可以操作文件或目录(创建，删除等)
 * 	若表示的是目录，可以查看该目录下的所有子项
 *		但是不可以: 访问文件内容.
 *  
 *
 */
public class FileDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 描述路径时，尽量使用相对路径。使用
		 * 绝对路径会导致路径格式与具体系统耦合
		 * 不利于跨平台。
		 * ".":当前目录。在eclipse中，表示当前
		 *     程序所在项目的根目录
		 */
		File file = new File("."+File.separator+
					   "test.txt");
		
		/*
		 * String getName()
		 * 获取文件或目录的名字
		 */
		String name = file.getName();
		System.out.println("name:"+name);
		/*
		 * 判断当前File表示文件或目录是否
		 * 在硬盘上存在
		 */
		boolean exists = file.exists();
		System.out.println("是否存在:"+exists);

		//若在硬盘上不存在
		if(!file.exists()){

			File dir = file.getParentFile();
			if(!dir.exists()){
				dir.mkdirs();	// 创建当前目录的同时将所有不存在的父目录一同创建出来
				//dir.mkdir();
			}


			file.createNewFile();
			System.out.println("创建成功!");
		}

		/*
		 * 查看当前文件所占用的字节量
		 */
		long length = file.length();
		System.out.println("长度:"+length+"字节");
		
		/*
		 * 查看文件权限
		 * 可读，可写，可运行
		 * 返回的都是boolean值。
		 */
		file.canRead();
		file.canWrite();
		file.canExecute();
		/*
		 * 文件是否隐藏
		 */
		file.isHidden();
		/*
		 * 最后修改时间
		 * 返回的时间以long值的形式。
		 */
		long lastM = file.lastModified();
		
		/*
		 * boolean isFile();
		 * 判断当前File对象表示的是否为一个文件
		 */
		boolean isFile = file.isFile();
		System.out.println("是否为文件:"+isFile);
		
		/*
		 * boolean isDirectory()
		 * 判断当前File对象表示的是否为一个目录
		 */
		boolean isDir = file.isDirectory();
		System.out.println("是否为目录:"+isDir);
		


	}

	@Test
	public void testDirectory() {
		/*
		 * 查看当前目录下都有哪些子项（子项无非还是文件或目录）
		 */
		File dir = new File(".");
		/*
		 * File[] listFiles()
		 * 返回当前目录下的所有子项。
		 * 返回的数组中的每一个元素就表示当前目录
		 * 下的一个子项(无论是文件还是目录)
		 */
		File[] subs = dir.listFiles();
		for(File sub : subs){
			if(sub.isFile()){
				System.out.print("文件:");
			}else if(sub.isDirectory()){
				System.out.print("目录:");
			}
			System.out.println(sub.getName());
		}



		/* 删除目录
		 * 删除目录的前提是，该目录是一个空目录
		 * 不含有任何子项才可以成功删除。
		 */
		//dir.delete();
	}
}






