package catalog.bean;

import java.io.Serializable;

public class NewsItem implements Serializable {

    private String category;
    private String title;
    private String additionalInfo;
    private String year;

    public NewsItem(String category, String title, String additionalInfo, String year) {
        this.category = category;
        this.title = title;
        this.additionalInfo = additionalInfo;
        this.year = year;
    }
    public NewsItem () {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "category = " + category + ", title = " + title + ", additionalInfo = " + additionalInfo + ", year = " + year;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsItem newsItem = (NewsItem) o;

        if (!category.equals(newsItem.category)) return false;
        if (!title.equals(newsItem.title)) return false;
        if (!additionalInfo.equals(newsItem.additionalInfo)) return false;
        return year.equals(newsItem.year);

    }
    @Override
    public int hashCode() {
        int result = category.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + additionalInfo.hashCode();
        result = 31 * result + year.hashCode();
        return result;
    }
}
