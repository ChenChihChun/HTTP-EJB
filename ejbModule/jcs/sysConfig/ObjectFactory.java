package jcs.sysConfig;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jcs.doms.tool.SysConfig package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Root_QNAME = new QName("http://www.JCS.org/SysConfig", "Root");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jcs.doms.tool.SysConfig
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NodeContent }
     * 
     */
    public NodeContent createNodeContent() {
        return new NodeContent();
    }

    /**
     * Create an instance of {@link SysConfigContent }
     * 
     */
    public SysConfigContent createSysConfigContent() {
        return new SysConfigContent();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SysConfigContent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.JCS.org/SysConfig", name = "Root")
    public JAXBElement<SysConfigContent> createRoot(SysConfigContent value) {
        return new JAXBElement<SysConfigContent>(_Root_QNAME, SysConfigContent.class, null, value);
    }

}
