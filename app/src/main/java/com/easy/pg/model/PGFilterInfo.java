package com.easy.pg.model;

public class PGFilterInfo {

    private String pg;
    private String area;
    private String college;
    private float distance;
    private int priceRangeStart;
    private int priceRangeEnd;
    private float rating;

    public PGFilterInfo() {
    }

    public PGFilterInfo(String pg, String area, String college, float distance, int priceRangeStart, int priceRangeEnd, float rating) {
        this.pg = pg;
        this.area = area;
        this.college = college;
        this.distance = distance;
        this.priceRangeStart = priceRangeStart;
        this.priceRangeEnd = priceRangeEnd;
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

    public int getPriceRangeStart() {
        return priceRangeStart;
    }

    public void setPriceRangeStart(int priceRangeStart) {
        this.priceRangeStart = priceRangeStart;
    }

    public int getPriceRangeEnd() {
        return priceRangeEnd;
    }

    public void setPriceRangeEnd(int priceRangeEnd) {
        this.priceRangeEnd = priceRangeEnd;
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
                ", priceRangeStart=" + priceRangeStart +
                ", priceRangeEnd=" + priceRangeEnd +
                ", rating=" + rating +
                '}';
    }
}
