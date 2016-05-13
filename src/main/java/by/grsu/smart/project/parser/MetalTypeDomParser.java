package by.grsu.smart.project.parser;

import by.grsu.smart.project.entity.MetalType;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MetalTypeDomParser {
    private final static Logger logger = Logger.getLogger(MetalTypeDomParser.class);

    public List<MetalType> parse(String url) {
        logger.info("Start parsing url - " + url);

        List<MetalType> metalTypes = new ArrayList<>();

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(url);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("Metal");

            for (int i = 0; i < nodeList.getLength(); ++i) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    metalTypes.add(parseElement((Element) node));
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            logger.error("Couldn't parse url - " + url);
        }

        return metalTypes;
    }

    private MetalType parseElement(Element element) {
        logger.info("Start parsing element");

        Long id = Long.parseLong(element.getAttribute("Id"));
        String name = element.getElementsByTagName("Name").item(0).getTextContent();
        String nameEng = element.getElementsByTagName("NameEng").item(0).getTextContent();
        String nameBel = element.getElementsByTagName("NameBel").item(0).getTextContent();

        return new MetalType(id, name, nameEng, nameBel);
    }
}
