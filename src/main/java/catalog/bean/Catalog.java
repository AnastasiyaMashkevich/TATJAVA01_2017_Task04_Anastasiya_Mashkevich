package catalog.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Catalog implements Serializable {
    private ArrayList<NewsItem> newsItem;

    public Catalog() {
    }

    public ArrayList<NewsItem> getNewsItem() {
        return newsItem;
    }

    public void setNewsItem(ArrayList<NewsItem> newsItem) {
        this.newsItem = newsItem;
    }

    public String toString() {
        return "newsItem = " + printArray(newsItem);
    }

    private String printArray(List<NewsItem> array) {
        StringBuffer sb = new StringBuffer();
        for (NewsItem newsItem : array) {
            sb.append(newsItem.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

}
