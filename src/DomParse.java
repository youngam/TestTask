
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Alex on 10.10.2014.
 */
public class DomParse {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter the name of the artist");
        Scanner in = new Scanner(System.in, "UTF-8");
        String artist = in.nextLine();
        System.out.println("Enter the country");
        Scanner temp = new Scanner(System.in);
        String country = temp.nextLine();
        getInformation(artist, country );

    }
    // Method for getting information about Event
    public static void getInformation(String group, String country ){
        // Get the information from server
        URI uri = null;
        try {
            uri = new URI(
                    "http",
                    "api.bandsintown.com",
                    "/artists/" +group+ "/events.xml",
                    null);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            URL url = uri.toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        // Use DOM parse
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = builder.parse(uri.toASCIIString());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();
        // Get the information about event
        NodeList nList = doc.getElementsByTagName("event");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == node.ELEMENT_NODE) {
                Element element = (Element) node;
                // Output the information about event
                if(element.getElementsByTagName("country").item(0).getTextContent().equals(country) ) {
                    System.out.println("Information about event: ");
                    System.out.println("Artist name: " + element.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("datetime: " + element.getElementsByTagName("datetime").item(0).getTextContent());
                    System.out.println("city: " + element.getElementsByTagName("city").item(0).getTextContent());
                    System.out.println("region: " + element.getElementsByTagName("region").item(0).getTextContent());
                    System.out.println("country: " + element.getElementsByTagName("country").item(0).getTextContent());
                    System.out.println("ticket_status: " + element.getElementsByTagName("ticket_status").item(0).getTextContent());
                    System.out.println("on_sale_datetime: " + element.getElementsByTagName("on_sale_datetime").item(0).getTextContent());
                    System.out.println("-----------------------------");
                }

            }

        }


    }













}
