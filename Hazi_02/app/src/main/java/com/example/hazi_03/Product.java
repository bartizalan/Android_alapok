package com.example.hazi_03;

public class Product {
    private String pc;
    private String pn;
    private double pp;
    private int db;

    public Product(String pc, String pn, double pp, int db) {
        this.pc = pc;
        this.pn = pn;
        this.pp = pp;
        this.db = db;

    }

    public String getPc() {
        return pc;
    }

    public String getPn() {
        return pn;
    }

    public double getPp() {
        return pp;
    }
    public int getDb() {
        return db;
    }

    public void setDb(int db){
        this.db = db;

    }

    public void increaseDb(){
        db++;
    }


}
