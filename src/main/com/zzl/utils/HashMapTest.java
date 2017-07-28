package zzl.utils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class <code>Object</code> is the root of the class hierarchy.
 * Every class has <code>Object</code> as a superclass. All objects,
 * including arrays, implement the methods of this class.
 *
 * @author Administrator
 * @version 1.0
 * @see
 * @since JDK1.7
 * <p>
 * History
 * Created by Administrator on 2017/1/19 0019.
 * 比较HashMap 与 LinkedHashMap的区别
 */
public class HashMapTest {

    public static void main(String[] args) {
        /**
         *
         */
        Map<String, String> map = new LinkedHashMap<String, String>(16,0.75f,false);
        map.put("A","a");
        map.put("B","b");
        map.put("C","c");
        map.put("D","d");

        map.get("C");
        map.get("A");
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
