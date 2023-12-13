package com.dieutester.constants;

import com.dieutester.helpers.PropertiesHelper;

public class ConfigData {
    static {
        PropertiesHelper.loadAllFiles();
    }

    public static String URL = PropertiesHelper.getValue("url");
}
