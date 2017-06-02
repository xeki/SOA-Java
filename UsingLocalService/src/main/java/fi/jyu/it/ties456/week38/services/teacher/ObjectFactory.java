
package fi.jyu.it.ties456.week38.services.teacher;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fi.jyu.it.ties456.week38.services.teacher package. 
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

    private final static QName _SearchForPersonResponse_QNAME = new QName("http://week38.ties456.jyu.fi/", "searchForPersonResponse");
    private final static QName _SearchForPerson_QNAME = new QName("http://week38.ties456.jyu.fi/", "searchForPerson");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fi.jyu.it.ties456.week38.services.teacher
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SearchForPerson }
     * 
     */
    public SearchForPerson createSearchForPerson() {
        return new SearchForPerson();
    }

    /**
     * Create an instance of {@link SearchForPersonResponse }
     * 
     */
    public SearchForPersonResponse createSearchForPersonResponse() {
        return new SearchForPersonResponse();
    }

    /**
     * Create an instance of {@link TeacherType }
     * 
     */
    public TeacherType createTeacherType() {
        return new TeacherType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchForPersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://week38.ties456.jyu.fi/", name = "searchForPersonResponse")
    public JAXBElement<SearchForPersonResponse> createSearchForPersonResponse(SearchForPersonResponse value) {
        return new JAXBElement<SearchForPersonResponse>(_SearchForPersonResponse_QNAME, SearchForPersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchForPerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://week38.ties456.jyu.fi/", name = "searchForPerson")
    public JAXBElement<SearchForPerson> createSearchForPerson(SearchForPerson value) {
        return new JAXBElement<SearchForPerson>(_SearchForPerson_QNAME, SearchForPerson.class, null, value);
    }

}
