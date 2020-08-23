package xmlTest;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class TestXML {
    public static void main(String[] args) throws DocumentException, IOException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(new File("src/xmlTest/乙女解剖.xml"));
        Element rootElement = read.getRootElement();

        //ArrayList<String> strings = new ArrayList<>();
        HashMap<String,String> hashMap=new HashMap<>();

        List<Element> d = rootElement.elements("d");
        for (Element element : d) {
            String text = element.getText();
            Attribute p = element.attribute("p");
            String value = p.getValue();
            String[] split = value.split(",");
            hashMap.put(split[0],text);
            // strings.add(text);
        }
        //strings.forEach(s -> System.out.println(s));

        File file=new File("src/xmlTest/乙女解剖.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        BufferedWriter writer=new BufferedWriter(new FileWriter(file));
//        for (String string : strings) {
//            writer.write(string);
//            writer.newLine();
//        }
        hashMap.forEach((s, s2) -> {
            try {
                writer.write(s);
                writer.write("----"+s2);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writer.flush();
        writer.close();
        System.out.println("success");
    }
}