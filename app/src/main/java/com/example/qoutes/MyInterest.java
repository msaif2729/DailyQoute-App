package com.example.qoutes;

public class MyInterest {

    String categorytxt;
    String categoryimg;

    public MyInterest(String categorytxt, String categoryimg) {
        this.categorytxt = categorytxt;
        this.categoryimg = categoryimg;
    }

    public String getCategorytxt() {
        return categorytxt;
    }

    public void setCategorytxt(String categorytxt) {
        this.categorytxt = categorytxt;
    }

    public String getCategoryimg() {
        return categoryimg;
    }

    public void setCategoryimg(String categoryimg) {
        this.categoryimg = categoryimg;
    }
}
