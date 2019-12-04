package tech.wetech.weshop.user.mapper;

import tech.wetech.weshop.common.mapper.MyMapper;
import tech.wetech.weshop.user.po.Region;

public interface RegionMapper extends MyMapper<Region> {

    String selectNameById(Short id);
}
