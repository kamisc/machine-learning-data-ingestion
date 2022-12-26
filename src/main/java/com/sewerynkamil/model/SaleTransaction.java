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

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

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

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public static final class SaleTransactionBuilder {
        private String uuid;
        private String timestamp;
        private String type;
        private String size;
        private String price;
        private String offer;
        private String discount;
        private Long userId;

        @JsonProperty("tran_id")
        @JsonAlias("transaction_id")
        public SaleTransactionBuilder uuid(final String uuid) {
            this.uuid = uuid;
            return this;
        }

        public SaleTransactionBuilder timestamp(final String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        @JsonProperty("coffee_type")
        public SaleTransactionBuilder type(final String type) {
            this.type = type;
            return this;
        }

        public SaleTransactionBuilder size(final String size) {
            this.size = size;
            return this;
        }

        public SaleTransactionBuilder price(final String price) {
            this.price = price;
            return this;
        }

        public SaleTransactionBuilder offer(final String offer) {
            this.offer = offer;
            return this;
        }

        public SaleTransactionBuilder discount(final String discount) {
            this.discount = discount;
            return this;
        }

        @JsonProperty("userid")
        public SaleTransactionBuilder userId(final Long userId) {
            this.userId = userId;
            return this;
        }

        public SaleTransaction build() {
            SaleTransaction saleTransaction = new SaleTransaction();
            saleTransaction.uuid = this.uuid;
            saleTransaction.timestamp = this.timestamp;
            saleTransaction.type = this.type;
            saleTransaction.size = this.size;
            saleTransaction.price = this.price;
            saleTransaction.offer = this.offer;
            saleTransaction.discount = this.discount;
            saleTransaction.userId = this.userId;

            return saleTransaction;
        }
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
        return "Transaction{" +
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
