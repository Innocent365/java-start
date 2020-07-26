import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hw
 * @version on 2019/2/21
 */
public class configUtils {

    public static Map<String, String> getClassName(String path) throws IOException, DocumentException {
        Map handlerMap = new HashMap();

        SAXReader reader = new SAXReader();
        File file = new File(path);
        Document doc = reader.read(file);
        Element root = doc.getRootElement();
        List<Element> childElementsList = root.elements();

        for (Element ele: childElementsList){
            String key = ele.element("url-pattern").getText();
            String val = ele.element("servlet-class").getText();
            handlerMap.put(key, val);
        }

        return handlerMap;
    }
}
