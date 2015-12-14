package cn.ifengkou.athena.common.id;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * Created by Sloong on 2015/11/23.
 */
public class TestIdWorker {

    @Test
    public void testIdWorker() {
        final long idepo = System.currentTimeMillis() - 3600 * 1000L;
        IdWorker iw = new IdWorker(1, 1, 0, idepo);
        IdWorker iw1 = new IdWorker(2, 1, 0, idepo);
        IdWorker iw2 = new IdWorker(idepo);
        HashSet<String> ids = new HashSet<>();
        for (int i = 0; i < 30; i++) {
            System.out.println(iw.getId() + " -> " + iw1.getId() + " -> " + iw2.getId());
            ids.add("" + iw.getId());
            ids.add("" + iw1.getId());
            ids.add("" + iw2.getId());
        }
        System.out.println(iw);
        System.out.println(iw1);
        System.out.println(iw2);
        System.out.println(ids.size());

        Assert.assertEquals(90, ids.size());
    }
}
