package io.dreamstudio.springboot.commons.util;

import io.dreamstudio.springboot.commons.primitives.Ints;

import java.util.Collection;
import java.util.Map;

/**
 * 集合工具类
 */
public abstract class CollectionUtils {

    public static int size(Collection col) {
        return col!=null ? col.size() : Ints.ZERO;
    }

    public static int size(Map map) {
        return map!=null ? map.size() : Ints.ZERO;
    }

    //------Collection
    public static boolean isEmpty(Collection col) {
        return col == null || col.isEmpty();
    }

    public static boolean isNotEmpty(Collection col) {
        return !isEmpty(col);
    }

    //------Map
    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }

}
