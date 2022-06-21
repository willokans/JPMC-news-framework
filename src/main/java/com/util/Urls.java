package com.util;

import java.util.HashMap;

public class Urls {

        public static String getURL(String urlValue){
        HashMap<String, String> urls = new HashMap<>();
        urls.put("google", "https://www.google.com/");
        urls.put("Times", "https://www.thetimes.co.uk/");
        urls.put("Telegraph", "https://www.telegraph.co.uk/");
        urls.put("BBC", "https://www.bbc.co.uk/");
        urls.put("BBC", "https://uk.yahoo.com/");
        urls.put("theguardian", "https://www.theguardian.com/tone/news");
        urls.put("broken_url_guardian", "https://www.theguardian.org");

        String url = urls.get(urlValue);
        return url;
    }
}
