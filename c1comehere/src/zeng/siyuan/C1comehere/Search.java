package zeng.siyuan.C1comehere;

import java.net.URI;
import java.net.URL;

/**
 * Created by SiyuanZeng's on 8/24/2016.
 */
public class Search {
    public static final String SPACE = " ";
    public static final String EMPTY_STRING = "";
    String searchEngine;
    String spaceHolder;
    String searchName;
    String key;
    String keywords;
    URI URI;

    public Search(String searchName, String key, String searchEngine, String spaceHolder) {
        this.searchName = searchName;
        this.key = key;
        this.searchEngine = searchEngine;
        this.spaceHolder = spaceHolder;
    }

    public URI getURI() {
        return URI;
    }

    public String getURIString() {
        return URI.toString();
    }

    public void setURI(String keywords) {
        try {
            String normalized = keywords.replace(key, EMPTY_STRING);
            this.keywords = normalized;
            URI = new URL(String.format(searchEngine, normalized.replace(SPACE, "+"))).toURI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
