package utils;


import exceptions.CompanyNotFoundException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMXmlParser implements DataSrcUtils {

    public String m_fileToParse = "";

    public DOMXmlParser(String fileToParse) {
        m_fileToParse = fileToParse;
    }

    public void getAirplanes() {
        System.out.println("\nStart parsing xml file with airplanes");
        try {
            Document doc = parseXML();

            System.out.println("\nParsing planes in company :" + doc.getDocumentElement().getAttribute("name"));

            NodeList nList = doc.getElementsByTagName("plane"); // get plane with all characteristics in aviacompany

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("Airplane id:          " + eElement.getAttribute("id"));
                    System.out.println("Airplane name:        " + eElement.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Airplane capacity:    " + eElement.getElementsByTagName("capacity").item(0).getTextContent());
                    System.out.println("Airplane range:       " + eElement.getElementsByTagName("range").item(0).getTextContent());
                    System.out.println("Airplane volume:      " + eElement.getElementsByTagName("volume").item(0).getTextContent());
                    System.out.println("Airplane speed:       " + eElement.getElementsByTagName("speed").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            System.err.println("Failed to parse the filefile" + e.getMessage());
        }

    }

    public String getAviacompany(String companyName) {
        System.out.println("\nLooking for a company " + companyName + " in xml file");
        String company = null;
        try {
            Document doc = parseXML();

            company = doc.getDocumentElement().getAttribute("name");
            if (!company.equalsIgnoreCase(companyName))
                throw new CompanyNotFoundException("Requested company was not found");
            System.out.println("Company " + company + " was found");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return company;
    }

    protected Document parseXML() {
        File xmlFile = new File(m_fileToParse);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        Document doc = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

}
