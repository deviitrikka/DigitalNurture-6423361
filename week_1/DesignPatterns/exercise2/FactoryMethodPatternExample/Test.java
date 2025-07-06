package exercise2.FactoryMethodPatternExample;

public class Test {
    public static void main(String[] args) {
        createAndUseDoc(new WordDocumentFactory());
        createAndUseDoc(new PdfDocumentFactory());
        createAndUseDoc(new ExcelDocumentFactory());
    }

    public static void createAndUseDoc(DocumentFactory D){
        Document doc = D.createDocument();
        System.out.println("This is doc " + doc);
    }
}
