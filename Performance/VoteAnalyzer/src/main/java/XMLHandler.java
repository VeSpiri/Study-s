import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class XMLHandler extends DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        try {
            if (qName.equals("voter")) {
                DBConnection.countVoter(attributes.getValue("name"), attributes.getValue("birthDay"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
