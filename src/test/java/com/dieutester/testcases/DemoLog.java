package com.dieutester.testcases;

import com.dieutester.utils.LogUtils;
import org.testng.annotations.Test;

public class DemoLog {
    @Test
    public void test(){
        LogUtils.info("1");
    }
    @Test
    public void test2(){
        LogUtils.info("2");
    }
}
