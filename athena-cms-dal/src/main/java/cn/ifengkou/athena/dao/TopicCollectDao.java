package cn.ifengkou.athena.dao;

import cn.ifengkou.athena.model.TopicCollect;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/11/26.
 */
@Repository
public interface TopicCollectDao {
    List<TopicCollect> getTopicCollectsByUserId(long userId);

    TopicCollect get(HashMap<String,Object> map);
    int add(TopicCollect bean);
    int delete(TopicCollect bean);
}
