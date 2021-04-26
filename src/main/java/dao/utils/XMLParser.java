package dao.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XMLParser {
    private static Logger logger = Logger.getLogger(XMLParser.class);
    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/kalber/workspace/HospitalModelWithMvn/src/main/resources/log4j2.properties");


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("src/main/resources/Parser/DBSchema.xml");
            NodeList patientList = doc.getElementsByTagName("Patient");
            for (int i = 0 ; i < patientList.getLength(); i++){
                Node p = patientList.item(i);
                if(p.getNodeType() == Node.ELEMENT_NODE){
                    Element patient = (Element) p;
                    String id = patient.getAttribute("id");
                    NodeList nameList = patient.getChildNodes();
                    for(int k = 0; k < nameList.getLength(); k++){
                        Node n = nameList.item(k);
                        if(n.getNodeType() == Node.ELEMENT_NODE){
                            Element name = (Element) n;
                            logger.info("Patient " + id + ": " + name.getTagName() + " - " + name.getTextContent());
                        }
                    }
                }
            }
        } catch (ParserConfigurationException ParserError) {
            logger.error(ParserError.getMessage());
        } catch (IOException IOError) {
            logger.error(IOError.getMessage());
        } catch (SAXException SAXError) {
            logger.error(SAXError.getMessage());
        }
    }
}
