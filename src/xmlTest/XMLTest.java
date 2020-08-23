package xmlTest;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLTest {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(new File("src/xmlTest/student.xml"));
        Element rootElement = read.getRootElement();
        List<Element> listElement = rootElement.elements("student");
        List<Student> studentList=new ArrayList<>();
        listElement.forEach(element -> {
            Attribute attributeSid = element.attribute("id");
            String sid = attributeSid.getValue();
            System.out.println(sid);

            Element elementName = element.element("name");
            String name = elementName.getText();

            Element ageElement = element.element("age");
            Integer age = Integer.valueOf(ageElement.getText());

            studentList.add(new Student(name,age));
        });
        studentList.forEach(student -> System.out.println(student));



/*        SAXReader reader=new SAXReader();
        Document document = reader.read(new File("src/xmlTest/student.xml"));
        Element element = document.getRootElement();
        List<Element> elementList = element.elements("student");
        List<Student> studentList=new ArrayList<>();
        elementList.forEach(s->{
            Attribute attribute = s.attribute("id");
            String id=attribute.getValue();
            Element element1 = s.element("name");
            String name = element1.getText();

            Element ageElement = s.element("age");
            Integer age = Integer.valueOf(ageElement.getText());
            Student student=new Student(name,age);
            studentList.add(student);

        });
        System.out.println(studentList);*/
    }
}
