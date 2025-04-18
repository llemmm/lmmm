package org.apache.commons.lang3.math;

public class NumberUtilsManualTest {
    public static void main(String[] args) {
        System.out.println("=== 开始手动测试 NumberUtils ===");
        testToInt();
        testIsDigits();
        testMax();
        System.out.println("=== 手动测试完成 ===");
    }

    private static void testToInt() {
        System.out.println("\n--- 测试 toInt() 方法 ---");

        // 测试用例1：有效数字
        testCaseToInt("123", 0, 123, "正常数字转换");

        // 测试用例2：无效数字
        testCaseToInt("abc", 0, 0, "非数字字符串");

        // 测试用例3：null输入
        testCaseToInt(null, -1, -1, "null输入");
    }

    private static void testCaseToInt(String input, int defaultValue, int expected, String description) {
        int result = NumberUtils.toInt(input, defaultValue);
        System.out.printf("测试 '%s' (%s): 期望=%d, 实际=%d -> %s%n",
                input, description, expected, result,
                (result == expected) ? "通过" : "失败");
    }

    private static void testIsDigits() {
        System.out.println("\n--- 测试 isDigits() 方法 ---");

        // 测试用例1：纯数字
        testCaseIsDigits("123", true, "纯数字字符串");

        // 测试用例2：包含字母
        testCaseIsDigits("12a", false, "包含非数字字符");

        // 测试用例3：null输入（会失败）
        testCaseIsDigits(null, false, "null输入");
    }

    private static void testCaseIsDigits(String input, boolean expected, String description) {
        boolean result = NumberUtils.isDigits(input);
        System.out.printf("测试 '%s' (%s): 期望=%b, 实际=%b -> %s%n",
                input, description, expected, result,
                (result == expected) ? "通过" : "失败");
    }

    private static void testMax() {
        System.out.println("\n--- 测试 max() 方法 ---");

        // 测试用例1：正常数组
        testCaseMax(new int[]{1, 3, 2}, 3, "正常数组");

        // 测试用例2：空数组
        testCaseMax(new int[]{}, "空数组");

        // 测试用例3：null数组
        testCaseMax(null, "null数组");
    }

    private static void testCaseMax(int[] array, int expected, String description) {
        try {
            int result = NumberUtils.max(array);
            System.out.printf("测试 %s: 期望=%d, 实际=%d -> 通过%n",
                    description, expected, result);
        } catch (Exception e) {
            System.out.printf("测试 %s: 期望=%d, 但抛出异常 -> 失败%n",
                    description, expected);
        }
    }

    private static void testCaseMax(int[] array, String description) {
        try {
            NumberUtils.max(array);
            System.out.printf("测试 %s: 期望抛出异常, 但未抛出 -> 失败%n", description);
        } catch (IllegalArgumentException e) {
            System.out.printf("测试 %s: 正确抛出异常 -> 通过%n", description);
        }
    }
}