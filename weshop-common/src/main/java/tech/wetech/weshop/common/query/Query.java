package tech.wetech.weshop.common.query;

import java.beans.Introspector;
import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author cjbi
 */
public class Query<T> {

    private Integer pageSize;
    private Integer pageNumber;
    private List<QueryCondition> conditions = new ArrayList<>();
    private List<String> selects = new ArrayList<>();
    private Sort sort;

    public Query<T> setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Query<T> setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public Query<T> setConditions(List<QueryCondition> conditions) {
        this.conditions = conditions;
        return this;
    }

    public List<String> getSelects() {
        return selects;
    }

    public Query<T> setSort(Sort sort) {
        this.sort = sort;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public List<QueryCondition> getConditions() {
        return conditions;
    }

    public Query<T> setSelects(String... properties) {
        this.selects = Arrays.asList(properties);
        return this;
    }

    public Query<T> setSelects(Property<T, ?>... properties) {
        this.selects = Arrays.stream(properties).map(this::getFunctionName).collect(Collectors.toList());
        return this;
    }

    public Sort getSort() {
        return sort;
    }

    public Query<T> andIsNotNull(Property<T, ?> property) {
        this.conditions.add(new QueryCondition(getFunctionName(property), "is not null", "and"));
        return this;
    }

    public Query<T> andEqualTo(Property<T, ?> property, Object value) {
        this.conditions.add(new QueryCondition(getFunctionName(property), value, "=", "and"));
        return this;
    }

    public Query<T> andNotEqualTo(Property<T, ?> property, Object value) {
        new QueryCondition(getFunctionName(property), value, "<>", "and");
        return this;
    }

    public Query<T> andGreaterThan(Property<T, ?> property, Object value) {
        this.conditions.add(new QueryCondition(getFunctionName(property), value, ">", "and"));
        return this;
    }

    public Query<T> andGreaterThanOrEqualTo(Property<T, ?> property, Object value) {
        this.conditions.add(new QueryCondition(getFunctionName(property), value, ">=", "and"));
        return this;
    }

    public Query<T> andLessThan(Property<T, ?> property, Object value) {
        this.conditions.add(new QueryCondition(getFunctionName(property), value, "<", "and"));
        return this;
    }

    public Query<T> andLessThanOrEqualTo(Property<T, ?> property, Object value) {
        this.conditions.add(new QueryCondition(getFunctionName(property), value, "<=", "and"));
        return this;
    }

    public Query<T> andIn(Property<T, ?> property, Iterable values) {
        this.conditions.add(new QueryCondition(getFunctionName(property), values, "in", "and"));
        return this;
    }

    public Query<T> andNotIn(Property<T, ?> property, Iterable values) {
        this.conditions.add(new QueryCondition(getFunctionName(property), values, "not in", "and"));
        return this;
    }

    public Query<T> andBetween(Property<T, ?> property, Object value1, Object value2) {
        this.conditions.add(new QueryCondition(getFunctionName(property), value1, value2, "between", "and"));
        return this;
    }

    public Query<T> andNotBetween(Property<T, ?> property, Object value1, Object value2) {
        this.conditions.add(new QueryCondition(getFunctionName(property), value1, value2, "not between", "and"));
        return this;
    }

    public Query<T> andLike(Property<T, ?> property, String value) {
        this.conditions.add(new QueryCondition(getFunctionName(property), value, "like", "and"));
        return this;
    }

    public Query<T> andNotLike(Property<T, ?> property, String value) {
        this.conditions.add(new QueryCondition(getFunctionName(property), value, "not like", "and"));
        return this;
    }

    public Query<T> orIsNull(Property<T, ?> property) {
        this.conditions.add(new QueryCondition(getFunctionName(property), "is null", "or"));
        return this;
    }

    public Query<T> orIsNotNull(Property<T, ?> property) {
        this.conditions.add(new QueryCondition(getFunctionName(property), "is not null", "or"));
        return this;
    }

    public Query<T> orEqualTo(Property<T, ?> property, Object value) {
        this.conditions.add(new QueryCondition(getFunctionName(property), value, "=", "or"));
        return this;
    }

    public Query<T> orNotEqualTo(Property<T, ?> property, Object value) {
        this.conditions.add(new QueryCondition(getFunctionName(property), value, "<>", "or"));
        return this;
    }

    public Query<T> orGreaterThan(Property<T, ?> property, Object value) {
        this.conditions.add(new QueryCondition(getFunctionName(property), value, ">", "or"));
        return this;
    }

    public Query<T> orGreaterThanOrEqualTo(Property<T, ?> property, Object value) {
        this.conditions.add(new QueryCondition(getFunctionName(property), value, ">=", "or"));
        return this;
    }

    public Query<T> orLessThan(Property<T, ?> property, Object value) {
        this.conditions.add(new QueryCondition(getFunctionName(property), value, "<", "or"));
        return this;
    }

    public Query<T> orLessThanOrEqualTo(Property<T, ?> property, Object value) {
        this.conditions.add(new QueryCondition(getFunctionName(property), value, "<=", "or"));
        return this;
    }

    public Query<T> orIn(Property<T, ?> property, Iterable values) {
        this.conditions.add(new QueryCondition(getFunctionName(property), values, "in", "or"));
        return this;
    }

    public Query<T> orNotIn(Property<T, ?> property, Iterable values) {
        this.conditions.add(new QueryCondition(getFunctionName(property), values, "not in", "or"));
        return this;
    }

    public Query<T> orBetween(Property<T, ?> property, Object value1, Object value2) {
        this.conditions.add(new QueryCondition(getFunctionName(property), value1, value2, "between", "or"));
        return this;
    }

    public Query<T> orNotBetween(Property<T, ?> property, Object value1, Object value2) {
        this.conditions.add(new QueryCondition(getFunctionName(property), value1, value2, "not between", "or"));
        return this;
    }

    public Query<T> orLike(Property<T, ?> property, String value) {
        this.conditions.add(new QueryCondition(getFunctionName(property), value, "like", "or"));
        return this;
    }

    public Query<T> orNotLike(Property<T, ?> property, String value) {
        this.conditions.add(new QueryCondition(getFunctionName(property), value, "not like", "or"));
        return this;
    }

    ////////////////////
    public Query<T> andIsNotNull(String property) {
        this.conditions.add(new QueryCondition(property, "is not null", "and"));
        return this;
    }

    public Query<T> andEqualTo(String property, Object value) {
        this.conditions.add(new QueryCondition(property, value, "=", "and"));
        return this;
    }

    public Query<T> andNotEqualTo(String property, Object value) {
        new QueryCondition(property, value, "<>", "and");
        return this;
    }

    public Query<T> andGreaterThan(String property, Object value) {
        this.conditions.add(new QueryCondition(property, value, ">", "and"));
        return this;
    }

    public Query<T> andGreaterThanOrEqualTo(String property, Object value) {
        this.conditions.add(new QueryCondition(property, value, ">=", "and"));
        return this;
    }

    public Query<T> andLessThan(String property, Object value) {
        this.conditions.add(new QueryCondition(property, value, "<", "and"));
        return this;
    }

    public Query<T> andLessThanOrEqualTo(String property, Object value) {
        this.conditions.add(new QueryCondition(property, value, "<=", "and"));
        return this;
    }

    public Query<T> andIn(String property, Iterable values) {
        this.conditions.add(new QueryCondition(property, values, "in", "and"));
        return this;
    }

    public Query<T> andNotIn(String property, Iterable values) {
        this.conditions.add(new QueryCondition(property, values, "not in", "and"));
        return this;
    }

    public Query<T> andBetween(String property, Object value1, Object value2) {
        this.conditions.add(new QueryCondition(property, value1, value2, "between", "and"));
        return this;
    }

    public Query<T> andNotBetween(String property, Object value1, Object value2) {
        this.conditions.add(new QueryCondition(property, value1, value2, "not between", "and"));
        return this;
    }

    public Query<T> andLike(String property, String value) {
        this.conditions.add(new QueryCondition(property, value, "like", "and"));
        return this;
    }

    public Query<T> andNotLike(String property, String value) {
        this.conditions.add(new QueryCondition(property, value, "not like", "and"));
        return this;
    }

    public Query<T> orIsNull(String property) {
        this.conditions.add(new QueryCondition(property, "is null", "or"));
        return this;
    }

    public Query<T> orIsNotNull(String property) {
        this.conditions.add(new QueryCondition(property, "is not null", "or"));
        return this;
    }

    public Query<T> orEqualTo(String property, Object value) {
        this.conditions.add(new QueryCondition(property, value, "=", "or"));
        return this;
    }

    public Query<T> orNotEqualTo(String property, Object value) {
        this.conditions.add(new QueryCondition(property, value, "<>", "or"));
        return this;
    }

    public Query<T> orGreaterThan(String property, Object value) {
        this.conditions.add(new QueryCondition(property, value, ">", "or"));
        return this;
    }

    public Query<T> orGreaterThanOrEqualTo(String property, Object value) {
        this.conditions.add(new QueryCondition(property, value, ">=", "or"));
        return this;
    }

    public Query<T> orLessThan(String property, Object value) {
        this.conditions.add(new QueryCondition(property, value, "<", "or"));
        return this;
    }

    public Query<T> orLessThanOrEqualTo(String property, Object value) {
        this.conditions.add(new QueryCondition(property, value, "<=", "or"));
        return this;
    }

    public Query<T> orIn(String property, Iterable values) {
        this.conditions.add(new QueryCondition(property, values, "in", "or"));
        return this;
    }

    public Query<T> orNotIn(String property, Iterable values) {
        this.conditions.add(new QueryCondition(property, values, "not in", "or"));
        return this;
    }

    public Query<T> orBetween(String property, Object value1, Object value2) {
        this.conditions.add(new QueryCondition(property, value1, value2, "between", "or"));
        return this;
    }

    public Query<T> orNotBetween(String property, Object value1, Object value2) {
        this.conditions.add(new QueryCondition(property, value1, value2, "not between", "or"));
        return this;
    }

    public Query<T> orLike(String property, String value) {
        this.conditions.add(new QueryCondition(property, value, "like", "or"));
        return this;
    }

    public Query<T> orNotLike(String property, String value) {
        this.conditions.add(new QueryCondition(property, value, "not like", "or"));
        return this;
    }

    public static class QueryCondition {
        private String property;
        private Object value;
        private Object secondValue;
        private String condition;
        private String andOr;
        private ValueType valueType;

        public enum ValueType {
            noValue, singleValue, betweenValue, listValue
        }

        public QueryCondition() {
        }

        public QueryCondition(String property, String condition, String andOr) {
            this.property = property;
            this.condition = condition;
            this.andOr = andOr;
            this.valueType = ValueType.noValue;
        }


        public QueryCondition(String property, Object value, String condition, String andOr) {
            this.property = property;
            this.value = value;
            this.condition = condition;
            this.andOr = andOr;

            if (value instanceof Iterable) {
                this.valueType = ValueType.listValue;
            } else {
                this.valueType = ValueType.singleValue;
            }
        }

        public QueryCondition(String property, Object value1, Object value2, String condition, String andOr) {
            this.property = property;
            this.value = value1;
            this.secondValue = value2;
            this.condition = condition;
            this.andOr = andOr;
            this.valueType = ValueType.betweenValue;
        }

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public void setSecondValue(Object secondValue) {
            this.secondValue = secondValue;
        }

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public String getAndOr() {
            return andOr;
        }

        public void setAndOr(String andOr) {
            this.andOr = andOr;
        }

        public ValueType getValueType() {
            return valueType;
        }

        public void setValueType(ValueType valueType) {
            this.valueType = valueType;
        }
    }

    private <FN extends Function> String getFunctionName(FN property) {
        try {
            Method declaredMethod = property.getClass().getDeclaredMethod("writeReplace");
            declaredMethod.setAccessible(Boolean.TRUE);
            SerializedLambda serializedLambda = (SerializedLambda) declaredMethod.invoke(property);
            String method = serializedLambda.getImplMethodName();
            String attr = null;
            if (method.startsWith("get")) {
                attr = method.substring(3);
            } else {
                attr = method.substring(2);
            }
            return Introspector.decapitalize(attr);
        } catch (ReflectiveOperationException var6) {
            throw new RuntimeException(var6);
        }
    }

    public interface Property<T, R> extends Function<T, R>, Serializable {
    }

    public static class Sort implements Serializable {

        public static final Sort.Direction DEFAULT_DIRECTION;

        private final List<Sort.Order> orders;

        static {
            DEFAULT_DIRECTION = Sort.Direction.ASC;
        }

        public Sort(List<Sort.Order> orders) {
            this.orders = orders;
        }

        public Sort(Sort.Direction direction, String... properties) {
            this(direction, properties == null ? new ArrayList<>() : Arrays.asList(properties));
        }

        public Sort(String... properties) {
            this(DEFAULT_DIRECTION, properties);
        }

        public Sort(Sort.Direction direction, List<String> properties) {
            if (properties == null || properties.isEmpty()) {
                throw new IllegalArgumentException("You have to provide at least one property to sort by!");
            }
            this.orders = new ArrayList<>(properties.size());
            for (String property : properties) {
                this.orders.add(new Sort.Order(direction, property));
            }
        }

        public List<Sort.Order> getOrders() {
            return orders;
        }

        public static enum Direction {
            ASC,
            DESC
        }

        public static class Order implements Serializable {

            private final String property;
            private final Sort.Direction direction;

            public Order(Sort.Direction direction, String property) {
                this.direction = direction;
                this.property = property;
            }

            public Order(String property) {
                this(DEFAULT_DIRECTION, property);
            }

            public String getProperty() {
                return property;
            }

            public Sort.Direction getDirection() {
                return direction;
            }
        }
    }

}
