package com.krokky.pro0513.builderAndUser;

public class 商品 {
    private Integer id;

    public 商品(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "商品[id=" + id + ']';
    }
}
