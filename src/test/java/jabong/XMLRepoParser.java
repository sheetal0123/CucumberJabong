package jabong;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.openqa.selenium.By;

public class XMLRepoParser {

	public By getByElementFromRepo(String pageName, String loc) {
		String locatorType = null;
		String locatorValue = null;

		try {
			File repoXmlFile = new File("C:\\Users\\sheetalsingh\\workspace\\CucumberJabong\\JabongRepo.xml");

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(repoXmlFile);
			document.getDocumentElement().normalize();

			NodeList nodeList = document.getElementsByTagName("PageNode");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node pageNode = nodeList.item(i);
				if ((pageNode.getAttributes().getNamedItem("name").getTextContent().toString()
						.equalsIgnoreCase(pageName))) {

					for (int j = 0; j < pageNode.getChildNodes().getLength(); j++) {
						if (!pageNode.getChildNodes().item(j).getNodeName().toString().startsWith("#")) {
							if (pageNode.getChildNodes().item(j).getAttributes().getNamedItem("name").getTextContent()
									.toString().equalsIgnoreCase(loc)) {
								locatorType = pageNode.getChildNodes().item(j).getAttributes()
										.getNamedItem("locator_type").getTextContent().toString();
								locatorValue = pageNode.getChildNodes().item(j).getAttributes().getNamedItem("locator")
										.getTextContent().toString();
							}

						}

					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		By locator = null;

		switch (locatorType) {
		case "Id":
			locator = By.id(locatorValue);
			break;
		case "Name":
			locator = By.name(locatorValue);
			break;
		case "CssSelector":
			locator = By.cssSelector(locatorValue);
			break;
		case "LinkText":
			locator = By.linkText(locatorValue);
			break;
		case "PartialLinkText":
			locator = By.partialLinkText(locatorValue);
			break;
		case "TagName":
			locator = By.tagName(locatorValue);
			break;
		case "Xpath":
			locator = By.xpath(locatorValue);
			break;
		case "ClassName":
			locator = By.className(locatorValue);
			break;
		}
		return locator;

	}

}