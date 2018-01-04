package com.wnn.xml;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class XpathTest {

	@Test
	public void test() throws Exception {
		SAXReader reader = new SAXReader();
		File file = new File("student.xml");
		Document document = reader.read(file);
		
		/*
		 List list = document.selectNodes( "//foo/bar" );
         Node node = document.selectSingleNode( "//foo/bar/author" );
                           使用xpath进行dom解析需要加入两个jar包：
                     dom4j-1.6.1.jar
                     jaxen-1.1-beta-6.jar     
		 */
		
		 List list = document.selectNodes( "//name" );
		// System.out.println(list.size());
		
		 Element stu = (Element) document.selectSingleNode( "//student" );
		 System.out.println(stu.getName());
		 System.out.println(stu.attributeValue("id"));
	}

}
