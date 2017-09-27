package java_demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 读取xml文件转换为map
 * @author zhangxiao
 *
 */
public class XML_Reader {
	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		Map<String,String> map = new HashMap<String,String>();
		SAXReader reader = new SAXReader();
		Document root = reader.read(new FileInputStream("book.xml"));
		
		//获取根节点
		Element rootEle =  root.getRootElement();
		
		//获取子节点
		Iterator<?> it = rootEle.elementIterator();
		while(it.hasNext()){
			Element ele = (Element)it.next();
			//获取属性
			List<Attribute> li = ele.attributes();
			
			for (Attribute attribute : li) {
				map.put(attribute.getName(), attribute.getValue());
			}
			
			//获取文本
			
			//获取子节点的子节点
//			Iterator<?> iter = ele.elementIterator();
//			while(iter.hasNext()){
//				Element ele1 = (Element)iter.next();
//				System.out.println(ele1.getName()+","+ele1.getStringValue());
//			}
			
		}
		for (Map.Entry<String, String>  m : map.entrySet()) {
			System.out.println(m.getKey()+"="+m.getValue());
		}
		
		
	}
}
