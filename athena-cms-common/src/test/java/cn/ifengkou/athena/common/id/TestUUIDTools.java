package cn.ifengkou.athena.common.id;

import junit.framework.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * Created by Sloong on 2015/12/10.
 */
public class TestUUIDTools {
    @Test
    public void test(){

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 3000; i++) {
            String id1 = UUIDTools.uuid();
            String id2 = UUIDTools.uuid();
            String id3 = UUIDTools.uuid();
            set.add(id1);
            set.add(id2);
            set.add(id3);
            //System.out.println(id1+"  -> "+id2+"  -> "+id3);
        }

        Assert.assertEquals(9000,set.size());
    }
}
