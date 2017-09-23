package xml_demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.swing.text.Element;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import day12.Emp;

/**
 * 解析前需要修改pom.xml文档，加载dom4j的jar包。
 * 将emp.xml文件中的员工信息解析出来并以Emp实例保存到一个集合中然后
 * 按照工资从高到低的顺序输出每个员工信息
 *
 */
public class XmlCreate {
	public static void main(String[] args) {
		/**
		 * 1,创建saxreader对象
		 * 2,使用saxreader读取xml并创建document
		 */
		SAXReader sr = new SAXReader();
		Document doc = sr.getClass(XmlCreate.class.getClassLoader().getResourceAsStream("JavaEE_Demo/emp.xml"));
		
		/**
		 * 1,解析跟元素
		 * 2,存放到集合
		 */
		Element element = doc.getRootElement();
		List<Element> list = element.elements();
		
		List<Emp> emp = new ArrayList<Emp>();
		
		for (Element ele : list) {
			int id = Integer.parseInt(e.attributeValue("id"));
			//获取名字
			String name = e.element("name").getText();
			//获取年龄
			int age = Integer.parseInt(e.element("age").getText());
			String gender = e.elementText("gender");
			int salary = Integer.parseInt(e.elementText("salary"));
			Date hiredate = sdf.parse(e.elementText("hiredate"));
//			String date = sdf.format(hiredate);
			Emp emp1 = new Emp(id, name, age, gender, salary, hiredate);
			empList.add(emp1);
			
		}
		
		System.out.println(empList);
		Collections.sort(empList,new Comparator<Emp>(){
			public int compare(Emp o1, Emp o2) {
				return o2.getSalary()-o1.getSalary();
			}
		});
		
		
		
	}
}
