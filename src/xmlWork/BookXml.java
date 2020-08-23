package xmlWork;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BookXml {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader=new SAXReader();
        Document read = saxReader.read(new File("src/xmlWork/work.xml"));
        Element rootElement = read.getRootElement();
        List<Element> elements = rootElement.elements("book");
        List<Book> bookList=new ArrayList<>();
        for (Element element : elements) {
            String name = String.valueOf(element.element("name").getText());
            String library = String.valueOf(element.element("library").getText());
            String date = String.valueOf(element.element("date").getText());
            Element price = element.element("price");
            String priceText = price.getText();
            Double priceDouble= Double.valueOf(priceText);
            bookList.add(new Book(name,library,date,priceDouble));
        }
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}
class Book{
    private String name;
    private String library;
    private String date;
    private Double price;

    public Book(String name, String library, String date, Double price) {
        this.name = name;
        this.library = library;
        this.date = date;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLibrary() {
        return library;
    }

    public void setLibrary(String library) {
        this.library = library;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", library='" + library + '\'' +
                ", date=" + date +
                ", price=" + price +
                '}';
    }
}
