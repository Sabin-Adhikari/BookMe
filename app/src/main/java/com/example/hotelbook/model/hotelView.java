package com.example.hotelbook.model;

public class hotelView {
    String countryName;
    String placeName;
    String price;


    public hotelView() {
    }

    int imageUrl;

    public hotelView(String placeName,int imageUrl,String price,String countryName ){
        this.countryName = countryName;
        this.placeName = placeName;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

}
