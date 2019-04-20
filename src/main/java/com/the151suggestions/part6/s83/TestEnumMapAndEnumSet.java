package com.the151suggestions.part6.s83;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * 枚举用法7:枚举集合的使用
 * Created by ankang on 2017-08-14.
 */
public class TestEnumMapAndEnumSet {
    public static void main(String[] args) {
        testEnumMap();
        testEnumSet();
    }

    public static void testEnumSet() {
        EnumSet<SeasonEnum> enumSet = EnumSet.noneOf(SeasonEnum.class);
        enumSet.add(SeasonEnum.AUTUMN);
        enumSet.add(SeasonEnum.SPRING);

        for (SeasonEnum seasonEnum : enumSet) {
            System.out.println(seasonEnum);
        }
    }

    public static void testEnumMap() {
        EnumMap<SeasonEnum, String> enumMap = new EnumMap<>(SeasonEnum.class);
        enumMap.put(SeasonEnum.AUTUMN, "秋天");
        enumMap.put(SeasonEnum.SPRING, "春天");
        for (EnumMap.Entry<SeasonEnum, String> entry : enumMap.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey());
        }
    }
}
