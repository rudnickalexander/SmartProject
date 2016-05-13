package by.grsu.smart.project.parser;

import by.grsu.smart.project.entity.Currency;
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
public class CurrencyDomParser {
    private static final Logger logger = Logger.getLogger(CurrencyDomParser.class);

    public List<Currency> parse(String url) {
        logger.info("Start parsing url - " + url);

        List<Currency> currencies = new ArrayList<>();

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(url);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("Currency");

            for (int i = 0; i < nodeList.getLength(); ++i) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    currencies.add(parseElement((Element) node));
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
            logger.error("Couldn't parse document on url - " + url, e);
        }

        return currencies;
    }

    private Currency parseElement(Element element) {
        logger.info("Start parsing element");

        Long id = Long.parseLong(element.getAttribute("Id"));
        String numCode = element.getElementsByTagName("NumCode").item(0).getTextContent();
        String charCode = element.getElementsByTagName("CharCode").item(0).getTextContent();
        Integer scale = Integer.parseInt(element.getElementsByTagName("Scale").item(0).getTextContent());
        String name = element.getElementsByTagName("Name").item(0).getTextContent();
        Double rate = Double.parseDouble(element.getElementsByTagName("Rate").item(0).getTextContent());

        return new Currency(id, numCode, charCode, scale, name, rate);
    }
}
