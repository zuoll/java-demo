package com.zll.demo;

import cn.hutool.core.map.MapBuilder;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.XmlUtil;
import org.junit.Test;
import org.w3c.dom.Document;

import javax.xml.xpath.XPathConstants;
import java.util.LinkedHashMap;
import java.util.Map;

public class XmlUtilTest {

    @Test
    public void test001() {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>"//
                + "<returnsms>"//
                + "<returnstatus>Success</returnstatus>"//
                + "<message>ok</message>"//
                + "<remainpoint>1490</remainpoint>"//
                + "<taskID>885</taskID>"//
                + "<successCounts>1</successCounts>"//
                + "</returnsms>";

        Document document = XmlUtil.parseXml(xml);

        String returnstatus = XmlUtil.elementText(document.getDocumentElement(), "returnstatus");
        System.out.println(returnstatus);

        String root = XmlUtil.elementText(document.getDocumentElement(), "root");
        System.out.println(root);
    }


    /**
     * 写文件
     */
    @Test
    public void test002() {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>"//
                + "<returnsms>"//
                + "<returnstatus>Success</returnstatus>"//
                + "<message>ok</message>"//
                + "<remainpoint>1490</remainpoint>"//
                + "<taskID>885</taskID>"//
                + "<successCounts>1</successCounts>"//
                + "</returnsms>";

        Document document = XmlUtil.parseXml(xml);

        XmlUtil.toFile(document, "d:/hello.xml");
    }


    /**
     * xpath
     */
    @Test
    public void test003() {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>"//
                + "<returnsms>"//
                + "<returnstatus>Success</returnstatus>"//
                + "<message>ok</message>"//
                + "<remainpoint>1490</remainpoint>"//
                + "<taskID>885</taskID>"//
                + "<successCounts>1</successCounts>"//
                + "</returnsms>";
        Document document = XmlUtil.parseXml(xml);

        String msg = (String) XmlUtil.getByXPath("//returnsms/message", document, XPathConstants.STRING);
        System.out.println(msg);
    }


    /**
     * xml to map
     */
    @Test
    public void test004() {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>"//
                + "<returnsms>"//
                + "<returnstatus>Success</returnstatus>"//
                + "<message>ok</message>"//
                + "<remainpoint>1490</remainpoint>"//
                + "<taskID>885</taskID>"//
                + "<successCounts>1</successCounts>"//
                + "</returnsms>";

        Map<String, Object> map = XmlUtil.xmlToMap(xml);
        map.entrySet().stream().forEach(m -> {
            System.out.println(m.getKey() + "," + m.getValue());
        });
    }


    /**
     * 同名称的在map 会覆盖
     */
    @Test
    public void test005() {
        String xml = "<root><name>张三</name><name>李四</name></root>";

        Map<String, Object> map = XmlUtil.xmlToMap(xml);
        int size = map.size();
        System.out.println(size);

        map.entrySet().forEach(m -> System.out.println(m.getKey() + "," + m.getValue()));
    }


    /**
     * map to xml
     */
    @Test
    public void test006() {

        Map<String, Object> map = MapBuilder.create(new LinkedHashMap<String, Object>())
                .put("name", "zs")
                .put("age", 22)
                .put("game", MapUtil.builder(new LinkedHashMap<String, Object>())
                        .put("nickname", "lol")
                        .put("level", 30).build()).build();


        Document userDocument = XmlUtil.mapToXml(map, "user");

        String s = XmlUtil.toStr(userDocument, true);

        System.out.println(s);

        String name = XmlUtil.elementText(userDocument.getDocumentElement(), "name");
        System.out.println(name);

    }

    @Test
    public void test007() {
        Document doc = XmlUtil.readXML("d:/hello.xml");
        System.out.println(XmlUtil.toStr(doc, true));
    }


    /**
     * 剔除xml 的声明
     */
    @Test
    public void test008() {
        Map<String, Object> map = MapBuilder.create(new LinkedHashMap<String, Object>())
                .put("name", "zs").build();
        String user = XmlUtil.mapToXmlStr(map, true);
        System.out.println(user);

    }

}
