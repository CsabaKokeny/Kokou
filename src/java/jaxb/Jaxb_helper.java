
package jaxb;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class Jaxb_helper {
    
    public static Marshaller createMarshaller(Object obj, Class<?>... classes) throws Exception {
        JAXBContext jaxbcontext;
        Marshaller marshaller;
        List<Class> classList = new ArrayList();
        if (classes.length >0) {
            classList.addAll(Arrays.asList(classes));  
        }
        classList.add(obj.getClass());
       /*
        classList.add(kokou.report.element.Displayable.class);
        classList.add(kokou.report.element.StaticText.class);
        classList.add(kokou.report.element.TextField.class);
        classList.add(kokou.report.element.Line.class);
        classList.add(kokou.report.element.Image.class);
        */
        jaxbcontext = JAXBContext.newInstance(
            classList.toArray(new Class[0])
        );
        marshaller = jaxbcontext.createMarshaller();
        return marshaller;
    }
    
    public static Unmarshaller createUnmarshaller(Class<?>... classes) throws Exception {
        JAXBContext jaxbcontext;
        Unmarshaller unmarshaller;
        List<Class> classList = new ArrayList();
        if (classes.length>0) {
            classList.addAll(Arrays.asList(classes));
        }
        /*
        classList.add(kokou.report.element.Displayable.class);
        classList.add(kokou.report.element.StaticText.class);
        classList.add(kokou.report.element.TextField.class);
        classList.add(kokou.report.element.Line.class);
        classList.add(kokou.report.element.Image.class);
        */
        jaxbcontext = JAXBContext.newInstance(
            classList.toArray(new Class[0])
        );
        unmarshaller = jaxbcontext.createUnmarshaller();
        return unmarshaller;
    }
    
    public static void marshal (Object obj, OutputStream os,  Class<?>...classes) {
        try {
            Marshaller marshaller = createMarshaller(obj, classes);
            marshaller.marshal(obj, os);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public static Object unmarshal(InputStream is, Class<?>...classes ) throws Exception {
        Unmarshaller unmarshaller = createUnmarshaller(classes);
        return unmarshaller.unmarshal(is);
    }
        
    static public void marshal (boolean bCData, Object obj, OutputStream os, Class<?> ... classes) {
        if (!bCData) {
           marshal(obj, os, classes); 
           return;
        }
        try {
            Marshaller marshaller = createMarshaller(obj, classes);
            marshaller.marshal(obj, new CDataContentHandler(os));
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    
    static public class CDataContentHandler implements ContentHandler {
        
        XMLStreamWriter writer;
        
        static public class _Attribute {
            String uri, localName, qName, value;
        }
        
        public void writeStartElement(String uri, String localName, String qName, Attributes atts) {
            this.writeStartElement(uri, localName, qName, atts, false);
        }
        
        public void writeStartElement(String uri, String localName, String qName, List<_Attribute> atts) {
            this.writeStartElement(uri, localName, qName, atts, false);
        }
        
        public void writeEmptyElement(String uri, String localName, String qName, Attributes atts) {
            this.writeStartElement(uri, localName, qName, atts, true);
        }
        
        public void writeEmptyElement(String uri, String localName, String qName, List<_Attribute> atts) {
            this.writeStartElement(uri, localName, qName, atts, true);
        }
        
        public void writeEndElement(String uri, String localName, String qName) {
            try {
                writer.writeEndElement();
            } catch (XMLStreamException ex) {
                System.err.println(ex);
            }
        }
        
        public void writeCData(String data) {
            try {
                writer.writeCData(data);
            } catch (XMLStreamException ex) {
                System.err.println(ex);
            }
        }
        
        public void writeCData(char[] ch, int start, int length) {
            this.writeCData(new String(ch, start, length));
        }
        
        public void flush() {
            try {
                writer.flush();
            } catch (XMLStreamException ex) {
                System.err.println(ex);
            }
        }
        
        public void writeStartElement(String uri, String localName, String qName, Attributes atts, boolean bEmptyElement) {
            try {
                int length = atts!=null?atts.getLength():0;
                if (bEmptyElement) {
                    if (length > 0) {
                        writer.writeEmptyElement(localName);
                    }
                } else {
                    writer.writeStartElement(localName);
                }
                if (atts != null) {
                    for (int i=0;i<length;i++) {
                        String __localName = atts.getLocalName(i);
                        String __qName = atts.getQName(i);
                        String __uri = atts.getURI(i);
                        String __value = atts.getValue(i);
                        if (__value != null) {
                            writer.writeAttribute(__localName, __value);
                        }
                    }
                }
                
            } catch (XMLStreamException ex) {
                System.err.println(ex);
            }
        }
        
        public void writeStartElement(String uri, String localName, String qName, List<_Attribute> attrs, boolean bEmptyElement) {
            try {
                int length = attrs!=null?attrs.size():0;
                if (bEmptyElement) {
                    if (length > 0) {
                        writer.writeEmptyElement(localName);
                    }
                } else {
                    writer.writeStartElement(localName);
                }
                for (_Attribute item : attrs) {
                    writer.writeAttribute(item.localName, item.value);
                }
            } catch (XMLStreamException ex) {
                System.err.println(ex);
            }
        }
        
        public void storeAttributes(Attributes atts) {
            _attrs.clear();
            if (atts != null && atts.getLength()>0) {
                int length = atts.getLength();
                for (int i=0;i<length;i++) {
                    _Attribute item = new _Attribute();
                    item.localName = atts.getLocalName(i);
                    item.qName = atts.getQName(i);
                    item.uri = atts.getURI(i);
                    item.value = atts.getValue(i);
                    if (item.value != null) {
                        this._attrs.add(item);
                    }
                }
            }
        }
        
        public CDataContentHandler() {
            try {
                writer = XMLOutputFactory.newInstance().createXMLStreamWriter(System.out, "UTF-8");
            } catch (XMLStreamException ex) {
                System.err.println(ex);
            }
        }
        
        public CDataContentHandler(OutputStream out) {
            try {
                writer = XMLOutputFactory.newInstance().createXMLStreamWriter(out, "UTF-8");
            } catch (XMLStreamException ex) {
                System.err.println(ex);
            }
        }
        
        @Override
        public void setDocumentLocator(Locator locator) {
        }

        @Override
        public void startDocument() throws SAXException {
            try {
                writer.writeStartDocument("utf-8", "1.0");
            } catch (XMLStreamException ex) {
                System.err.println(ex);
            }
        }

        @Override
        public void endDocument() throws SAXException {
            try {
                writer.writeEndDocument();
                writer.flush();
            } catch (XMLStreamException ex) {
                System.err.println(ex);
            }
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void endPrefixMapping(String prefix) throws SAXException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        String _uri, _localName, _qName;
        List<_Attribute> _attrs = new ArrayList();
        boolean hasElement = false;
        @Override
        public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
            
            if (hasElement) {
                this.writeStartElement(_uri, _localName, _qName, _attrs);
            } else {
                hasElement = true;
            }
            this._uri = uri;
            this._localName = localName;
            this._qName = qName;
            this.storeAttributes(atts);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (hasElement) {
                this.writeEmptyElement(_uri, _localName, _qName, _attrs);
                hasElement = false;
            } else {
                this.writeEndElement(uri, localName, qName);
            }
            this.flush();
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (hasElement) {
                if (ch!=null) {
                    writeStartElement(_uri, _localName, _qName, _attrs);
                    writeCData(ch, start, length);
                    hasElement = false;
                }
            } else {
                writeCData(ch, start, length);
            }
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void processingInstruction(String target, String data) throws SAXException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void skippedEntity(String name) throws SAXException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}