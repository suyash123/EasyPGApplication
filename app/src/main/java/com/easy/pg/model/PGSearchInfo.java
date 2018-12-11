package com.easy.pg.model;

public class PGSearchInfo {

    private String coverImgUrl;
    private String pgSharingInfo;
    private String pgAreaInfo;
    private String address;
    private String desc;
    private String price;
    private String distance;

    public PGSearchInfo() {
    }

    public PGSearchInfo(String pgSharingInfo, String pgAreaInfo, String address, String desc, String price, String distance) {
        this.pgSharingInfo = pgSharingInfo;
        this.pgAreaInfo = pgAreaInfo;
        this.address = address;
        this.desc = desc;
        this.price = price;
        this.distance = distance;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public String getPgSharingInfo() {
        return pgSharingInfo;
    }

    public void setPgSharingInfo(String pgSharingInfo) {
        this.pgSharingInfo = pgSharingInfo;
    }

    public String getPgAreaInfo() {
        return pgAreaInfo;
    }

    public void setPgAreaInfo(String pgAreaInfo) {
        this.pgAreaInfo = pgAreaInfo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "PGSearchInfo{" +
                "coverImgUrl='" + coverImgUrl + '\'' +
                ", pgSharingInfo='" + pgSharingInfo + '\'' +
                ", pgAreaInfo='" + pgAreaInfo + '\'' +
                ", address='" + address + '\'' +
                ", desc='" + desc + '\'' +
                ", price='" + price + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }
}
