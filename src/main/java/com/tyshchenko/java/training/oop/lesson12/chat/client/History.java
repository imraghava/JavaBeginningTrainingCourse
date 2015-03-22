package com.tyshchenko.java.training.oop.lesson12.chat.client;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.tyshchenko.java.training.oop.lesson12.chat.common.Message;
import org.w3c.dom.*;

import javax.swing.table.DefaultTableModel;

/**
 * @author Alexander Tyshchenko.
 */
public class History {

    private String filePath;

    public History(String filePath) {
        this.filePath = filePath;
    }

    public void addMessage(Message msg, String msgTime) {

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filePath);

            Node data = doc.getFirstChild();

            Element message = doc.createElement("message");
            Element sender = doc.createElement("sender");
            sender.setTextContent(msg.sender);
            Element content = doc.createElement("content");
            content.setTextContent(msg.content);
            Element recipient = doc.createElement("recipient");
            recipient.setTextContent(msg.recipient);
            Element time = doc.createElement("time");
            time.setTextContent(msgTime);

            message.appendChild(sender);
            message.appendChild(content);
            message.appendChild(recipient);
            message.appendChild(time);
            data.appendChild(message);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

        } catch (Exception ex) {
            System.out.println("Exception in modifying xml");
        }
    }

    public void fillTable(HistoryForm frame) {

        DefaultTableModel model = (DefaultTableModel) frame.getHistoryTable().getModel();

        try {
            File fXmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("message");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    model.addRow(new Object[]{
                            getTagValue("sender", eElement),
                            getTagValue("content", eElement),
                            getTagValue("recipient", eElement),
                            getTagValue("time", eElement)});
                }
            }
        } catch (Exception ex) {
            System.out.println("Filling Exception");
        }
    }

    public static String getTagValue(String sTag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        return nValue.getNodeValue();
    }

}
