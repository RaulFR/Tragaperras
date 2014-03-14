package jackpot;

import com.sun.org.apache.xml.internal.serializer.OutputPropertiesFactory;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Raul
 */
public class Historial {

    private static Document documento;
    ArrayList<Jugada> jugadasList = new ArrayList();

    public ArrayList<Jugada> getPersonsList() {
        return jugadasList;
    }

    public void generarXML(ArrayList<Jugada> jugadasList, String xmlfile) {

        try {
            DocumentBuilderFactory fábricaCreadorDocumento = DocumentBuilderFactory.newInstance();
            DocumentBuilder creadorDocumento = fábricaCreadorDocumento.newDocumentBuilder();
            documento = creadorDocumento.newDocument();

            Element raiz = documento.createElement("tragaperras");
            documento.appendChild(raiz);

            for (int i = 0; i < jugadasList.size(); i++) {

                Element elementJugada = documento.createElement("jugada");
                raiz.appendChild(elementJugada);

                Jugada jugada = jugadasList.get(i);

                addJugadaData(elementJugada, "fechahora", String.valueOf(jugada.getFechaHora()));
                
                addJugadaData(elementJugada, "saldojugador", String.valueOf(jugada.getSaldoJugador()));

                addJugadaData(elementJugada, "saldomaquina", String.valueOf(jugada.getSaldoMaquina()));

                addJugadaData(elementJugada, "premio", String.valueOf(jugada.getPremio()));
            }

            TransformerFactory fábricaTransformador = TransformerFactory.newInstance();
            Transformer transformador = fábricaTransformador.newTransformer();
            transformador.setOutputProperty(OutputKeys.INDENT, "yes");
            transformador.setOutputProperty(OutputPropertiesFactory.S_KEY_INDENT_AMOUNT, "3");
            Source origen = new DOMSource(documento);
            Result destino = new StreamResult("historial.xml");
            transformador.transform(origen, destino);

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Historial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Historial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Historial.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void addJugadaData(Element parent, String tag, String value) {
        Element element = documento.createElement(tag);
        parent.appendChild(element);
        element.appendChild(documento.createTextNode(value));
    }

    public void mostrarHistorial() {
        for (Jugada jugada : jugadasList) {
            System.out.println(jugada.toString());
        }
    }
}
