package framework.data_processors;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

import static framework.data_processors.RegexUtils.getCountFindElements;
import static framework.data_processors.RegexUtils.getMatcherForString;

public class XmlUtils{

    public static NodeList getElementsByTagName(String xml,String tagName){
        try{
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(xml)));
            doc.getDocumentElement().normalize();
            return doc.getElementsByTagName(tagName);
        } catch (SAXException | IOException | ParserConfigurationException ignored) {}
        return null;
    }

    public static Node getNode(NodeList nodeList,int index){ return nodeList.item(index); }

    public static String getTextContentInNode(Node node,String tagName,int index){
        try{
            if (Node.ELEMENT_NODE == node.getNodeType()) {
                return ((Element) node) .getElementsByTagName(tagName).item(index) .getTextContent();
            }
        }catch (Exception ignored){}
        return "";
    }


    public static Boolean checkXmlByParsing(String xml){
        /**
         * Проверяет, что переданную xml возможно парсить
         */
        try{
            DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(xml)));
            return true;
        } catch (ParserConfigurationException | IOException | SAXException ignored) {
            return false;
        }
    }

    public static String checkAndUpdateXml(String xml){
        /**
         * Проверяет, что  переданная переменнай соответствует формату Xml и ее возможно парсить.
         * Оборачиваем переменную тегами <head></head>, если перед нами массив Xml следующего формата:
         *      <tag1>value</tag1>
         *      <tag2>value</tag2>
         *             ...
         *      <tagN>value</tagN>
         *      */

        checkFormatXml(xml);
        if (checkXmlByParsing(xml)){
            return xml;
        }else {
            String temp_xml=String.format("<head>%s</head>",xml);
            if (!checkXmlByParsing(temp_xml)){
                throw new IllegalArgumentException(String.format("Can't parsing xml. Invalid node\n%s", xml));
            }
            return temp_xml;
        }
    }

    public static void checkFormatXml(String xml){
        /**
         * Проверяет, что переданная переменная соответствует формату Xml по следующим параметрам:
         *      - Количество начальных тегов соответствует количеству завершающих тегов
         *      - Количество начальных или завершающих тегов не равно 0
         */
        String regexStartTag="(([<])[\\w]*?([>]))";
        String regexEndTag="(([<])[\\w]*?([>]))";

        int countStartTag=getCountFindElements(getMatcherForString(regexStartTag,xml));
        int countEndTag=getCountFindElements(getMatcherForString(regexEndTag,xml));

        if (countEndTag==0 || countStartTag==0 || countEndTag!=countStartTag){
            throw new IllegalArgumentException(String.format("Invalid data format.Need next valid format: Xml\n%s", xml));
        }
    }


}
