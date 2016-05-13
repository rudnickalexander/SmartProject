package by.grsu.smart.project.parser;

import by.grsu.smart.project.entity.Metal;
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
public class MetalDomParser {
    private final static Logger logger = Logger.getLogger(MetalDomParser.class);

    public List<Metal> parse(String url) {
        logger.info("Start parsing url - " + url);

        List<Metal> metals = new ArrayList<>();

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(url);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("IngotsPrices");

            for (int i = 0; i < nodeList.getLength(); ++i) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    metals.add(parseElement((Element) node));
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            logger.error("Couldn't parse url - " + url);
        }

        return metals;
    }

    private Metal parseElement(Element element) {
        logger.info("Start parsing element");

        Long id = Long.parseLong(element.getAttribute("MetalId"));
        Long nominal = Long.parseLong(element.getAttribute("Nominal"));

        Integer noCertificateRubles = getIntValueFromDouble(element, "NoCertificateRubles");
        Integer certificateRubles = getIntValueFromDouble(element, "CertificateRubles");
        Integer banksDollars = getIntValueFromDouble(element, "BanksDollars");
        Integer banksRubles  = getIntValueFromDouble(element, "BanksRubles");
        Integer entitiesDollars = getIntValueFromDouble(element, "EntitiesDollars");
        Integer entitiesRubles = getIntValueFromDouble(element, "EntitiesRubles");

        return new Metal(id, nominal, noCertificateRubles, certificateRubles,
                banksDollars, banksRubles, entitiesDollars, entitiesRubles);
    }

    private Integer getIntValueFromDouble(Element element, String elementName) {
        logger.info("Start casting from Double to Integer");

        Double value = Double.parseDouble(element.getElementsByTagName(elementName).item(0).getTextContent());

        return value.intValue();
    }
}
