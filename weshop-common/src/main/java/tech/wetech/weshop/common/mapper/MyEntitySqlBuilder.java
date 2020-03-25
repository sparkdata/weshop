package tech.wetech.weshop.common.mapper;

import tech.wetech.mybatis.builder.EntityMapping;
import tech.wetech.mybatis.mapper.AbstractEntityProvider;

/**
 * @author cjbi
 */
public class MyEntitySqlBuilder extends AbstractEntityProvider {

    public String delete(EntityMapping entityMapping) {
        StringBuilder builder = new StringBuilder();
        builder.append("delete from ").append(entityMapping.getTableName());
        builder.append(buildWhereNotNullXML(entityMapping));
        return builder.toString();
    }

}
