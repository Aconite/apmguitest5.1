package com.aconite.apm.gui.automation.utilities;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

public class XmlUtils
{
    public static NodeList splitFileIntoRecords(String filePath)
    {
        Document document = parse(filePath);
        return document.getDocumentElement().getElementsByTagNameNS("*", "record");
    }

    public static String getTagValue(String tag, Element element)
    {
        String value;

        NodeList nodeList = element.getElementsByTagNameNS("*", tag);
        if (nodeList.getLength() > 0)
        {
            value = nodeList.item(0).getTextContent();
        }
        else
        {
//            System.out.println("No element found with tagname: " + tag + ". Returning an empty string as the node value .. ");
            value = "";
        }

        return value;
    }

    public static String getSerializedChildElements(String tag, Element element) throws TransformerException
    {
        String value;
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        NodeList nodeList = element.getElementsByTagNameNS("*", tag);

        if (nodeList.getLength() > 0)
        {
            StringWriter sw = new StringWriter();
            transformer.transform(new DOMSource(nodeList.item(nodeList.getLength() - 1)), new StreamResult(sw));
            value = sw.toString();
        }
        else
        {
            value = "";
        }
        return value;
    }


    public static String getAttributeValue(String attributeName, String parentTagName, Element element) throws Exception
    {
        Element parentElement = (Element) element.getElementsByTagNameNS("*", parentTagName).item(0);
        String value = null;

        if (parentElement.hasAttributes())
        {
            value =  parentElement.getAttribute(attributeName);
        }

        return value;
    }

    public static Element getElement(String tag, Element element)
    {
        return (Element) element.getElementsByTagNameNS("*", tag).item(0);
    }

    private static Document parse(String filePath)
    {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setNamespaceAware(true);
        DocumentBuilder dBuilder;
        Document doc = null;

        try
        {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
        }
        catch (SAXException | ParserConfigurationException | IOException e1)
        {
            e1.printStackTrace();
        }

        return doc;
    }

}
