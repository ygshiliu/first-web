package com.wnn.xml;

import static org.junit.Assert.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomTest {

	@Test
	public void test() throws Exception {
		//获取解析器工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//通过解析器工厂获取解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		//解析文档获得对象
		Document document = builder.parse("student.xml");
		
		//getElementById(String) 在xml中由于是自定义标签，所以这里的id=1属性没有实际的意义，所以这个方法不能使用
//		Element element = document.getElementById("1");
		
		//getElementsByTagName(String)
		NodeList nodeList = document.getElementsByTagName("student");
		for(int i=0;i<nodeList.getLength();i++){
			Element element = (Element) nodeList.item(i);
			//获取id
			String id = element.getAttribute("id");
			//获取name
			Element nameEle= (Element) element.getElementsByTagName("name").item(0);
			String name = nameEle.getTextContent();
			//获取age
			String age = element.getElementsByTagName("age").item(0).getTextContent();
			//获取gender
			String gender = element.getElementsByTagName("gender").item(0).getTextContent();
			//获取描述信息
			String desc = element.getElementsByTagName("desc").item(0).getTextContent();
			desc = desc.trim();
			
			Student stu = new Student(Integer.parseInt(id), name, Integer.parseInt(age), gender, desc);
			
			//System.out.println(id+"--"+name+"--"+age+"--"+gender+"--"+desc);
			System.out.println(stu);
			
		}
		
	}

}
