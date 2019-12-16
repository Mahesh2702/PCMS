package com.example.navredesign;

public class CardItem {
    private String name;
    private double earnedPercent;
    private double totalPercent;
    private int progress;

    public CardItem(String name, double earnedPercent, double totalPercent) {
        this.name = name;
        this.earnedPercent = earnedPercent;
        this.totalPercent = totalPercent;
        this.progress = (int)Math.round(earnedPercent / totalPercent  * 100) ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEarnedPercent() {
        return earnedPercent;
    }

    public void setEarnedPercent(double earnedPercent) {
        this.earnedPercent = earnedPercent;
    }

    public double getTotalPercent() {
        return totalPercent;
    }

    public void setTotalPercent(double totalPercent) {
        this.totalPercent = totalPercent;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
