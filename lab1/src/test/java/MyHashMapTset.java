import org.junit.Test;
import java.util.ArrayList;
import org.junit.Assert;

/**
 * Created by Acer on 24.03.2018.
 */



public class MyHashMapTset extends Assert {
    MyHashMap<String, Integer>map;

    @Test
    public void addGet() {
        map = new MyHashMap<>();
        map.add("SuperPuperKey", 1);
        int val = map.get("SuperPuperKey");
        assertEquals(1, val);
    }

    @Test
    public void addRemove() {
        map = new MyHashMap<>();
        map.add("SuperPuperKey",1 );
        map.remove("SuperPuperKey");
        assertNull(map.get("SuperPuperKey"));
    }

    @Test
    public void isEmpty() {
        map = new MyHashMap<>();
        assertTrue(map.isEmpty());
        map.add("SuperPuperKey",1 );
        assertFalse(map.isEmpty());
    }

    @Test
    public void size() {
        map = new MyHashMap<>();
        map.add("1",1 );
        map.add("2",2 );
        map.add("3",3 );
        assertEquals(3, map.size());
    }

    @Test
    public void whiteBoxAdd() {
        System.out.println("Whiteboxing hash map add");
        ArrayList<String> expected = new ArrayList<>();
        expected.add("---Adding key value pair: test:1");
        expected.add("Hash: 3556498, bucket: 3");
        expected.add("Bucket Array before: [null, null, null, null, null]");
        expected.add("Key test not found!");
        expected.add("Bucket Array after: [null, null, null, (test:1->null), null]");
        expected.add("---Adding key value pair: test2:2");
        expected.add("Hash: 110251488, bucket: 3");
        expected.add("Bucket Array before: [null, null, null, (test:1->null), null]");
        expected.add("Key test2 not found!");
        expected.add("Bucket Array after: [null, null, null, (test2:2->(test:1->null)), null]");
        expected.add("---Adding key value pair: test:4");
        expected.add("Hash: 3556498, bucket: 3");
        expected.add("Bucket Array before: [null, null, null, (test2:2->(test:1->null)), null]");
        expected.add("Key test found!");
        expected.add("Bucket Array after: [null, null, null, (test2:2->(test:4->null)), null]");
        expected.add("---Adding key value pair: x:3");
        expected.add("Hash: 120, bucket: 0");
        expected.add("Bucket Array before: [null, null, null, (test2:2->(test:4->null)), null]");
        expected.add("Key x not found!");
        expected.add("Bucket Array after: [(x:3->null), null, null, (test2:2->(test:4->null)), null]");
        expected.add("---Adding key value pair: y:3");
        expected.add("Hash: 121, bucket: 1");
        expected.add("Bucket Array before: [(x:3->null), null, null, (test2:2->(test:4->null)), null]");
        expected.add("Key y not found!");
        expected.add("Bucket Array after: [(x:3->null), (y:3->null), null, (test2:2->(test:4->null)), null]");
        expected.add("Resizing HashTable");
        expected.add("Bucket Array after resize: [(x:3->null), (y:3->null), null, null, null, null, null, null, (test:4->(test2:2->null)), null]");
        map = new MyHashMap<>();
        map.debug=true;
        map.resetLogList();
        map.add("test",1 );
        map.add("test2",2 );
        map.add("test",4 );
        map.add("x",3 );
        map.add("y",3 );
        //System.out.println(map.logList.toArray().toString());
        assertArrayEquals(expected.toArray(), map.logList.toArray());
    }

}

