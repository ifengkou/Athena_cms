package cn.ifengkou.athena.dao;

import cn.ifengkou.athena.model.Ups;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * Created by Sloong on 2015/12/10.
 */
@Repository
public interface UpsDao {
    Ups getUpsByReplyIdAndUserId(HashMap<String,Object> map);

    int add(Ups ups);

    int delete(Ups ups);
}
