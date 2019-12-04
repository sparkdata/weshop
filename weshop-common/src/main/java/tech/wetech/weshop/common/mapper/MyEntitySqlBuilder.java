package tech.wetech.weshop.common.mapper;

import tech.wetech.mybatis.builder.EntityMapping;
import tech.wetech.mybatis.mapper.AbstractEntityProvider;
import tech.wetech.mybatis.session.ExtConfiguration;

/**
 * @author cjbi
 */
public class MyEntitySqlBuilder extends AbstractEntityProvider {

    public String delete(ExtConfiguration extConfiguration, EntityMapping entityMapping) {
        StringBuilder builder = new StringBuilder();
        builder.append("delete from ").append(entityMapping.getTableName());
        builder.append(buildWhereNotNullXML(extConfiguration, entityMapping));
        return builder.toString();
    }

}
