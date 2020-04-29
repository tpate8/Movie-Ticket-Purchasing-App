package com.example.omtp1;

public class conf {
    String email;
    String id;
    String quantity;
    String movie;
    String time;
    Number num;
    public conf(String id, String em, Number num, String movie, String quantity,String time){
        this.id=id;
        this.email = em;
        this.num=num;
        this.movie=movie;
        this.quantity = quantity;
        this.time=time;
    }


    public String getEmail() {
        return email;
    }

    public Number getNum() {
        return num;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getMovie() {
        return movie;
    }

    public String getTime() {
        return time;
    }
}
