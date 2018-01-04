package com.wnn.xml;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Dom4jTest {
	
	@Test
	public void dom4j() throws Exception{
		//获取解析器
		SAXReader saxReader = new SAXReader();
		File file = new File("student.xml");
		//通过解析器获取文档对象
		Document document = saxReader.read(file);
		
		//dom4j是从根元素开始的
		//通过文档对象获取根元素
		Element element = document.getRootElement();
		
		/* 
		 * Iterator elementIterator(); #获取元素的所有子元素
		 * String attributeValue(String name); #获取元素指定属性的值
		 * Element element(String name); #获取指定元素
		 * String elementText(String name); #获取指定元素的文本值
		 * */
		Iterator iterator = element.elementIterator("student");
		
		while(iterator.hasNext()){
			Element ele = (Element) iterator.next();
//			String name = ele.getName();
			//获取指定属性值
			String id = ele.attributeValue("id");
			//System.out.println(id);
			
//			获取name元素的值
			String name = ele.elementText("name");
			String age = ele.elementText("age");
			String gender = ele.elementText("gender");
			String desc = ele.elementText("desc").trim();
			
			System.out.println(id+"--"+name+"--"+age+"--"+gender+"--"+desc);
		}
		//System.out.println(element.getName());
		
		
	}
}
