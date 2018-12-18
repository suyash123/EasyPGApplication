package com.easy.pg.model;

public class PGFilterInfo {

    private String pg;
    private String area;
    private String college;
    private float distance;
    private int price;
    private float rating;

    public PGFilterInfo() {
    }

    public PGFilterInfo(String pg, String area, String college, float distance, int price, float rating) {
        this.pg = pg;
        this.area = area;
        this.college = college;
        this.distance = distance;
        this.price = price;
        this.rating = rating;
    }

    public String getPg() {
        return pg;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "PGFilterInfo{" +
                "pg='" + pg + '\'' +
                ", area='" + area + '\'' +
                ", college='" + college + '\'' +
                ", distance=" + distance +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}
