package org.apache.commons.lang3.math;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SelectClasses(NumberUtilsTest.class)
@SuiteDisplayName("NumberUtils 测试套件")
public class NumberUtilsTestSuite {
    // 这个类仅作为测试套件的容器
}
