package java_demo;

import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * 创建xml文件
 * @author feng
 *
 */
public class Xml {
	public static void main(String[] args) {

		Document doc = DocumentHelper.createDocument(); //创建文档
		Element root = doc.addElement("xml"); //设置跟节点
		
		//跟节点的属性
		//root.addAttribute("name", "one");
		
		//子节点
		Element ele = root.addElement("return_code");
		ele.addAttribute("name", "xiaoli");
		ele.addAttribute("age", "23");
		ele.addText("what");
		
		Element ele1 = root.addElement("two_son");
		ele1.addText("<![CDATA[SUCCESS]]>");
		
		try {
			OutputFormat format = new OutputFormat();
			
			FileOutputStream fos = new FileOutputStream("book.xml");
			
			XMLWriter writer = new XMLWriter(fos,format);
			writer.setEscapeText(true);
			writer.write(doc);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(11);
		
	}
}
