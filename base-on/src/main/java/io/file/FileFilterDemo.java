package io.file;

import java.io.File;
import java.io.FileFilter;

/**
 * 使用文件过滤器来定义过滤规则，从而获取一个目录中满足过滤器要求的部分子项。
 * 文件过滤器是一个接口。
 * @author Administrator
 *
 */
public class FileFilterDemo {
	public static void main(String[] args) {
		/*
		 * 使用匿名内部类的形式创建文件过滤器
		 * java.io.FileFilter
		 */
		FileFilter filter = new FileFilter(){
				 //accept方法用来定义过滤规则，满足过滤要求的就返回true。
				public boolean accept(File file) {
					System.out.println("正在过滤:"+file.getName());
					
					//文件或目录的名字要以"."开头
					return file.getName().startsWith(".");
				}	
		};
		//当前目录
		File dir = new File(".");
		/*
		 * 重载的listFiles()
		 * 参数要求传入一个FileFilter。那么该方
		 * 法会将当前目录中的所有子项逐一交给过滤
		 * 器的accept方法，只有返回为true的子项
		 * 参会在该方法中被返回.
		 */
		File[] subs = dir.listFiles(filter);
		for(File sub : subs){
			System.out.println(sub.getName());
		}
		
	}
}	







