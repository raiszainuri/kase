package com.mhs.kase.utils;

import java.util.HashMap;
import java.util.Map;

public interface KaseApi {
    String URL_BASE = "https://kase.fikriwado.com/";
    String URL_MAIN = "https://kase.fikriwado.com/kase/api/";

    /*String URL_BASE = "http://kase.fikriwado.com/";
    String URL_MAIN = "http://kase.fikriwado.com/kase/api/";*/

    Map<String, String> paramsList = new HashMap<>();

    void executeUrl(String url, Map<String, String> params);
}
