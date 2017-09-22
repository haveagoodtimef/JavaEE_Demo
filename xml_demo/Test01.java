package xml_demo;

import java.io.File;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * 将emp.dat文件中所有员工解析出来，并创建为若干Emp实例存入一个
 * 集合，id从1开始，自动为每个员工分配。之后按照emp.xml的格式将
 * 这些员工写入到emplist.xml文档中
 * 该文件800字节，每80个字节为一个员工的信息。
 * 其中:
 * 	 name为字符串，长度为32个字节，编码为:UTF-8
 *   age为int,长度为4个字节
 * 	 gender为字符串，长度为10个字节，编码为:UTF-8
 * 	 salary为int,长度为4个字节
 * 	 hiredate为字符串，长度为30个字节，编码为:UTF-8  内容格式:yyyy-MM-dd(由于长度30，后面可能会存在空白，注意去除)
 * 格式可参考当前包中emp.jpg图
 *
 */
public class Test01 {
	public static void main(String[] args) {
		List<Emp> list = getEmp();
		
	}
	/**
	 * 解析员工信息
	 */
	
	public static List<Emp> getEmp(){
		List<Emp> list = new ArrayList<E>();
		RandomAccessFile raf = null;
		File file = new File(Test01.class.getClassLoader().getResource("xml_demo/emp.dat").toURI());
		raf = new RandomAccessFile(file, "r");
		SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd");
		
		//解析
		for (int i = 1; i <= 10; i++) {
			//读取名字
			String name = readString(raf,32).trim();
			int age = raf.readInt();
			String gender = readString(raf, 10).trim();
			int salary = raf.readInt();
			String hiredate = readString(raf, 30).trim();
			Emp e = new Emp(name,age,gender,salary,adf.format(hiredate));
			list.add(e);
		}
	}
	
	/**
	 * 从当前RandomAccessFile当前位置读取指定的字节长度并用utf-8 编码
	 * 转换为字符串返回
	 */
	
	public static String readString(RandomAccessFile file , int len) {
		byte[] data = new Byte[len];
		file.read(data);
		return new String(data,"UTF-8");
		
	}
	
	
}
