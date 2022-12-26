package com.sewerynkamil.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class SaleTransaction {
    private String uuid;
    private String timestamp;
    private String type;
    private String size;
    private String price;
    private String offer;
    private String discount;
    private long userId;

    @JsonProperty("tran_id")
    @JsonAlias("transaction_id")
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    @JsonProperty("coffee_type")
    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    @JsonProperty("coffe_size")
    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public long getUserId() {
        return userId;
    }

    @JsonProperty("userid")
    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleTransaction that = (SaleTransaction) o;
        return uuid.equals(that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public String toString() {
        return "SaleTransaction{" +
                "uuid='" + uuid + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", price='" + price + '\'' +
                ", offer='" + offer + '\'' +
                ", discount='" + discount + '\'' +
                ", userId=" + userId +
                '}';
    }
}
