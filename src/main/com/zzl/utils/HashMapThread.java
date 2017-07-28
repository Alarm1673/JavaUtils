package zzl.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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
 */
public class HashMapThread extends Thread{

    private static AtomicInteger ai = new AtomicInteger(0);
    private static Map<Integer, Integer> map = new HashMap<Integer, Integer>(1);

    public void run()
    {
        while (ai.get() < 100000)
        {
            map.put(ai.get(), ai.get());
            ai.incrementAndGet();
        }
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 10000; i++){
            HashMapThread hmt0 = new HashMapThread();
            HashMapThread hmt1 = new HashMapThread();
            HashMapThread hmt2 = new HashMapThread();
            HashMapThread hmt3 = new HashMapThread();
            HashMapThread hmt4 = new HashMapThread();
            hmt0.start();
            hmt1.start();
            hmt2.start();
            hmt3.start();
            hmt4.start();
            System.out.println(ai);
        }

    }
}
