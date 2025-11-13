// Objeto simples representando o documento a ser validado
public class NFeDocument {
    private final String xmlContent;

    public NFeDocument(String xmlContent) {
        this.xmlContent = xmlContent;
    }

    public String getXmlContent() {
        return xmlContent;
    }
}