package org.apache.commons.lang3.math;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("NumberUtils 单元测试")
class NumberUtilsTest {

    @Test
    @DisplayName("测试 toInt() 方法")
    void testToInt() {
        // 正常数字转换
        assertEquals(123, NumberUtils.toInt("123", 0), "正常数字转换失败");

        // 非数字字符串
        assertEquals(0, NumberUtils.toInt("abc", 0), "非数字字符串处理失败");

        // null输入
        assertEquals(-1, NumberUtils.toInt(null, -1), "null输入处理失败");
    }

    @Test
    @DisplayName("测试 isDigits() 方法")
    void testIsDigits() {
        // 纯数字字符串
        assertTrue(NumberUtils.isDigits("123"), "纯数字字符串识别失败");

        // 包含非数字字符
        assertFalse(NumberUtils.isDigits("12a"), "非数字字符识别失败");

        // null输入（这个测试会失败）
        assertFalse(NumberUtils.isDigits(null), "null输入应返回false");
    }

    @Test
    @DisplayName("测试 max() 方法")
    void testMax() {
        // 正常数组
        assertEquals(3, NumberUtils.max(new int[]{1, 3, 2}), "最大值计算错误");

        // 空数组应抛出异常
        assertThrows(IllegalArgumentException.class,
                () -> NumberUtils.max(new int[]{}),
                "空数组未抛出异常");

        // null数组应抛出异常 - 明确指定为 int 数组
        assertThrows(IllegalArgumentException.class,
                () -> NumberUtils.max((int[]) null),
                "null数组未抛出异常");
    }
}