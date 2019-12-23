package com.aite.jiananseller.utils;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    public static boolean isEmpty(String string) {
        return TextUtils.isEmpty(string) && string.length() == 0 && string.equals("") || string.equals("null");
    }

    public int chriendNumber(Object o) {
        if (o instanceof String)
            return ((String) o).length();
        else if (o instanceof List)
            return ((List) o).size();
        else if (o instanceof ArrayList)
            return ((ArrayList) o).size();
        else
            return 0;
    }
}
