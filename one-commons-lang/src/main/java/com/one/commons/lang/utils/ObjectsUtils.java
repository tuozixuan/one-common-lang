/*
 * 描述： 对象工具类
 * 修改人：tuozixuan
 * 修改时间： Sep 26, 2018
 * 项目： one-commons-lang
 */
package com.one.commons.lang.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 对象工具类<br>
 * 
 * @author tuozixuan
 * @version [版本号, Sep 26, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public final class ObjectsUtils {
    
    private ObjectsUtils() {
    }
    
    /**
     * 判断对象是否为空
     * 
     * @param obj 对象
     * @return 是否为空
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj.toString().length() == 0) {
            return true;
        }
        return StringUtils.isEmpty(obj.toString());
    }
    
    /**
     * 格式化对象为字符串
     * 
     * @param object 对象
     * @return 格式化后的字符串
     */
    public static String toString(Object object) {
        return toString(object, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    /**
     * 通过指定的格式，格式化对象为字符串
     * 
     * @param obj 对象
     * @param toStringStyle 指定的格式，
     *                      {@code ToStringStyle.SIMPLE_STYLE }
     *                      {@code ToStringStyle.SHORT_PREFIX_STYLE }
     *                      {@code ToStringStyle.MULTI_LINE_STYLE }
     * @return 格式化后的字符串
     * @see ToStringStyle
     */
    public static String toString(Object obj, ToStringStyle toStringStyle) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Collection) {
            Collection<?> cs = (Collection<?>) obj;
            List<String> returnCs = new ArrayList<>();
            for (Object c : cs) {
                returnCs.add(ReflectionToStringBuilder.toString(c, toStringStyle));
            }
            return returnCs.toString();
        }
        if (obj instanceof Map) {
            Map<?, ?> maps = (Map<?, ?>) obj;
            Map<String, String> returnMaps = new HashMap<>();
            for (Map.Entry<?, ?> entry : maps.entrySet()) {
                String key = entry.getKey().toString();
                String value = ReflectionToStringBuilder.toString(entry.getValue(), toStringStyle);
                returnMaps.put(key, value);
            }
            return returnMaps.toString();
        }
        return ReflectionToStringBuilder.toString(obj, toStringStyle);
    }
}
