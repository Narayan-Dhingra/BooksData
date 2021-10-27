package com.example.retrofittest.model;

import com.google.gson.annotations.SerializedName;

public class Book {

    @SerializedName("isbn")
    private String isbn;
    @SerializedName("title")
    private String title;
    @SerializedName("subtitle")
    private String subtitle;
    @SerializedName("author")
    private String author;
    @SerializedName("published")
    private String published;
    @SerializedName("publisher")
    private String publisher;
    @SerializedName("pages")
    private int pages;
    @SerializedName("description")
    private String description;
    @SerializedName("website")
    private String website;
    @SerializedName("thumbnail")
    private String thumbnail;

    public Book(String isbn, String title, String subtitle, String author, String published, String publisher, int pages, String description, String website, String thumbnail) {
        this.isbn = isbn;
        this.title = title;
        this.subtitle = subtitle;
        this.author = author;
        this.published = published;
        this.publisher = publisher;
        this.pages = pages;
        this.description = description;
        this.website = website;
        this.thumbnail = thumbnail;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}




//"isbn":"978-1593279509",
//        "title":"Eloquent JavaScript, Third Edition",
//        "subtitle":"A Modern Introduction to Programming",
//        "author":"Marijn Haverbeke",
//        "published":"2018-12-04T00:00:00.000Z",
//        "publisher":"No Starch Press",
//        "pages":472,
//        "description":"JavaScript lies at the heart of almost every modern web application, from social apps like Twitter to browser-based game frameworks like Phaser and Babylon. Though simple for beginners to pick up and play with, JavaScript is a flexible, complex language that you can use to build full-scale applications.",
//        "website":"http://eloquentjavascript.net/",
//        "thumbnail":"https://retrofit-backend-demo.herokuapp.com/eloquentjavascript.jpg"