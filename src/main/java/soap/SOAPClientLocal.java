package soap;

import java.io.IOException;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import to.ItemSoapTO;

public class SOAPClientLocal {
	public static final String myNamespace = "ExameServiceImpl";
	public static final String pref_prefix = "soapenv";

	public static SOAPMessage callWebService(Long id) throws Exception {
		SOAPMessage soapResponse = null;
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory.createConnection();

		String endpoint = "http://localhost:8090/Exames_WebService/services/ExameServiceImpl?wsdl";
		soapResponse = soapConnection.call(createSOAPRequest(id), endpoint);
		SOAPBody body = soapResponse.getSOAPBody();
		soapConnection.close();
		return soapResponse;
	}

	
	private static SOAPMessage createSOAPRequest(Long id) throws SOAPException, IOException {
		MessageFactory factory = MessageFactory.newInstance();
		SOAPMessage soapMessage = factory.createMessage();

		createSoapEnvelope(id, soapMessage);
		soapMessage.writeTo(System.out);
		soapMessage.saveChanges();

		return soapMessage;
	}

	
	private static void createSoapEnvelope(Long id, SOAPMessage message) throws SOAPException {
		
		SOAPPart sp = message.getSOAPPart();

		// SOAP Envelope
		SOAPEnvelope env = sp.getEnvelope();
		
		MimeHeaders headers = message.getMimeHeaders();
		headers.addHeader("SOAPAction", myNamespace  + "search");
		
		// remove o namespace default
		env.removeNamespaceDeclaration(env.getPrefix());
		env.addNamespaceDeclaration(myNamespace, "ExameServiceImpl");
		env.addNamespaceDeclaration(pref_prefix, "http://schemas.xmlsoap.org/soap/envelope/");
		env.setPrefix(pref_prefix);
		
		// SOAP Body
		SOAPBody body = env.getBody();
		body.setPrefix(pref_prefix);
		SOAPElement soapBodyReq = body.addChildElement("getExame");
		
		SOAPElement soapBodyElem1 = soapBodyReq.addChildElement("id");
		soapBodyElem1.addTextNode(id.toString());
		
	}
	
//	public String someMethod() throws MalformedURLException, IOException {
//
//		//Code to make a webservice HTTP request
//		String responseString = "";
//		String outputString = "";
//		String wsURL = "<Endpoint of the webservice to be consumed>";
//		URL url = new URL(wsURL);
//		URLConnection connection = url.openConnection();
//		HttpURLConnection httpConn = (HttpURLConnection)connection;
//		ByteArrayOutputStream bout = new ByteArrayOutputStream();
//		String xmlInput = "entire SOAP Request";
//
//		byte[] buffer = new byte[xmlInput.length()];
//		buffer = xmlInput.getBytes();
//		bout.write(buffer);
//		byte[] b = bout.toByteArray();
//		String SOAPAction = "<SOAP action of the webservice to be consumed>";
//		// Set the appropriate HTTP parameters.
//		httpConn.setRequestProperty("Content-Length",
//		String.valueOf(b.length));
//		httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
//		httpConn.setRequestProperty("SOAPAction", SOAPAction);
//		httpConn.setRequestMethod("POST");
//		httpConn.setDoOutput(true);
//		httpConn.setDoInput(true);
//		OutputStream out = httpConn.getOutputStream();
//		//Write the content of the request to the outputstream of the HTTP Connection.
//		out.write(b);
//		out.close();
//		//Ready with sending the request.
//
//		//Read the response.
//		InputStreamReader isr = null;
//		if (httpConn.getResponseCode() == 200) {
//		  isr = new InputStreamReader(httpConn.getInputStream());
//		} else {
//		  isr = new InputStreamReader(httpConn.getErrorStream());
//		}
//
//		BufferedReader in = new BufferedReader(isr);
//
//		//Write the SOAP message response to a String.
//		while ((responseString = in.readLine()) != null) {
//		outputString = outputString + responseString;
//		}
//		//Parse the String output to a org.w3c.dom.Document and be able to reach every node with the org.w3c.dom API.
//		Document document = parseXmlFile(outputString); // Write a separate method to parse the xml input.
//		NodeList nodeLst = document.getElementsByTagName("<TagName of the element to be retrieved>");
//		String elementValue = nodeLst.item(0).getTextContent();
//		System.out.println(elementValue);
//
//		//Write the SOAP message formatted to the console.
//		String formattedSOAPResponse = formatXML(outputString); // Write a separate method to format the XML input.
//		System.out.println(formattedSOAPResponse);
//		return elementValue;
//		}
}
