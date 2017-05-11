package com.cryprocodes.newsfeed.fetcher;

import com.cryprocodes.newsfeed.constants.ApiConstants;
import com.cryprocodes.newsfeed.model.NewsItem;

import java.util.ArrayList;

public class NewsFetcher {
    private final static int MAX_ARTICLES_DEFAULT = 20; //todo - Move MAX_ARTICLES to fetch to the settings

    public static ArrayList<NewsItem> FetchNews(int maxArticles, NewsSource source, FetchType fetchType) {
        if (maxArticles == 0) {
            maxArticles = MAX_ARTICLES_DEFAULT;
        }

        String type = getFetchTypeString(fetchType);
        String src = getNewsSourceString(source);

        String requestUrl = BuildRequestUrl(src, type);

        ArrayList<NewsItem> items = new ArrayList<>();

        // get the JSON from the response and parse it to news items

        return items;
    }

    private static String getFetchTypeString(FetchType fetchType) {
        switch (fetchType) {
            case latest:
                return "latest";
            case top:
                return "top";
            default:
                return "latest";
        }
    }

    private static String getNewsSourceString(NewsSource source) {
        switch(source) {
            case bloomberg:
                return "bloomberg";
            case engadget:
                return "engadget";
            default:
                return "all"; // todo - Verify that "all" is a valid news source
        }
    }

    private static String BuildRequestUrl(String source, String fetchType) {

        return ApiConstants.ARTICLES_BASE_URL + "source=" + source + "&" +
                "sortBy=" + fetchType + "&" +
                "apiKey=" + ApiConstants.API_KEY;
    }
}
