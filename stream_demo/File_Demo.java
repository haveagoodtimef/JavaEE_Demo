package stream_demo;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * 通过File输出当前项目目录下的文件"pom.xml"的名字，大小，最后修改时间。
 * 最后修改时间格式如:2016-03-23 14:22:16
 */
public class File_Demo {
	public static void main(String[] args) {
		File file = new File("pom.xml");
		String name = file.getName();
		System.out.println(name);
		
		long len = file.length();
		System.out.println(len);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long time = file.lastModified();
		System.out.println(sdf.format(new Date(time)));
		
	}
}
