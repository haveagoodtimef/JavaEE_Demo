package day12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import javax.sql.rowset.spi.XmlWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * 要求用户控制台输入想输入的员工人数（至少5个），然后依序输入员工信息，每行为
 * 一条员工信息，格式如:1,张三,25,男,5000,2006-3-18
 * 每当输入一个员工后，要检查新输入的员工的id是否已经存在，即：不能在本次输入的
 * 这些员工信息中出现相同id的员工。
 * 然后按照emp.xml的格式，将这些员工写入到myemp.xml文档中。
 * @author Xiloer
 *
 */
public class Test02 {
	public static void main(String[] args) {
		try {
			Collection<Emp> emp = getEmp(2);
			WriteXml(emp, "empp.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 该方法用来获取用户输入的若干员工信息，并存入到一个集合后返回
	 * @param num 要输入的员工数量
	 * @return
	 * @throws ParseException 
	 */
	public static Collection<Emp> getEmp(int num) throws ParseException{
		Map<Integer,Emp> map = new LinkedHashMap<Integer,Emp>();
		if(num < 1) {
			System.out.println("至少为1人");
			return null;
		}
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd");
		int i = 1;
		while(true) {
			System.out.println("请输入第"+i+"个员工");
			String data = sc.nextLine();
			String[] emp = data.split(",");
			if(emp.length != 6){
				System.out.println("信息有错!");
				continue;
			}
			
			int id = Integer.parseInt(emp[0]);
			if(map.containsKey(id)) {
				System.out.println("id重复!");
				continue;
			}
			String name = emp[1];
			int age = Integer.parseInt(emp[2]);
			String gender = emp[3];
			int salary = Integer.parseInt(emp[4]);
			Date hiredate = adf.parse(emp[5]);
			
			Emp e = new Emp(id, name, age, gender, salary, hiredate);
			map.put(id, e);
			if(++i > num) {
				break;
			}
		}
		return map.values();
	}
	
	/**
	 * 写入xml文件
	 * @throws IOException 
	 */
	public static void WriteXml(Collection<Emp> emps, String filename) throws IOException {
		XMLWriter writer = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Document doc = DocumentHelper.createDocument();
			Element root = doc.addElement("list");
			for(Emp emp : emps) {
				Element ele = root.addElement("emp");
				ele.addAttribute("id", String.valueOf(emp.getId()));
				ele.addElement("name").addText(emp.getName());
				ele.addElement("gender").addText(emp.getGender());
				ele.addElement("salary", String.valueOf(emp.getSalary()));
				ele.addElement("hiredate",sdf.format(emp.getHirdate()));
			}
			writer = new XMLWriter(new FileOutputStream(filename),OutputFormat.createPrettyPrint());
			writer.write(doc);
			System.out.println("写出完毕!");
		} finally {
			if(writer != null) {
				writer.close();
			}
		}
	}
}
