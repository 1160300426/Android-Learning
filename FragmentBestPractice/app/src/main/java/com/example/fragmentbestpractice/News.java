package com.example.fragmentbestpractice;

/**
 * Created by HP on 2018/1/30.
 */

public class News {

    private String title;
    private String content;
    //获取新闻标题.
    public String getTitle() {
        return title;
    }
    //设置新闻标题.
    public void setTitle(String title) {
        this.title = title;
    }
    //获取新闻内容.
    public String getContent() {
        return content;
    }
    //设置新闻内容.
    public void setContent(String content) {
        this.content = content;
    }
}
