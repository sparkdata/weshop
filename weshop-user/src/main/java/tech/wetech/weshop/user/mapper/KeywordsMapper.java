package tech.wetech.weshop.user.mapper;


import tech.wetech.weshop.common.mapper.MyMapper;
import tech.wetech.weshop.user.po.Keywords;

import java.util.List;

public interface KeywordsMapper extends MyMapper<Keywords> {

    List<String> selectByKeywordLike(String keyword);
}
