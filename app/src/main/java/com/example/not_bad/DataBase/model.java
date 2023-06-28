package com.example.not_bad.DataBase;

public class model {
    int id;
    boolean liked;

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public model(int id, boolean liked, String titel, String msg, String time) {
        this.id = id;
        this.liked = liked;
        this.titel = titel;
        this.msg = msg;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public model(boolean liked, String titel, String msg, String time) {
        this.liked = liked;
        this.titel = titel;
        this.msg = msg;
        this.time = time;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public model(String titel, String msg, String time) {
        this.titel = titel;
        this.msg = msg;
        this.time = time;
    }

    public model(String msg, boolean liked) {
        this.liked = liked;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public model(String titel, String msg) {
        this.titel = titel;
        this.msg = msg;
    }

    public model(int id, String titel, String msg) {
        this.id = id;
        this.titel = titel;
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public model(int id, String titel, String msg, String time) {
        this.id = id;
        this.titel = titel;
        this.msg = msg;
        this.time = time;
    }

    String titel,msg,time;
}
