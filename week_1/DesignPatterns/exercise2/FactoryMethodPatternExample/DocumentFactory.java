package exercise2.FactoryMethodPatternExample;

public abstract class DocumentFactory {
    public abstract Document createDocument();
}

//factory classes

class WordDocumentFactory extends DocumentFactory{
    public Document createDocument(){
        return new WordDocument();
    };
}

class PdfDocumentFactory extends DocumentFactory{
    public Document createDocument(){
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory{
    public Document createDocument(){
        return new ExcelDocument();
    }
}