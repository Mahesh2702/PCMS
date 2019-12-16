package com.example.navredesign;

public class TabTitle {
    private String name;
    private double earnedPercent;
    private double totalPercent;
    private String tabTitle;
    private String tabSubTitle;
    private int progress;

    public TabTitle(String name, double earnedPercent, double totalPercent) {
        this.name = name;
        this.earnedPercent = earnedPercent;
        this.totalPercent = totalPercent;
        this.tabTitle = name;
        this.tabSubTitle = earnedPercent + "%/" + totalPercent +"%";
        this.progress = (int) Math.round(earnedPercent / totalPercent * 100) ;
    }

    public String getTabTitle() {
        return tabTitle;
    }

    public void setTabTitle(String tabTitle) {
        this.tabTitle = tabTitle;
    }

    public String getTabSubTitle() {
        return tabSubTitle;
    }

    public void setTabSubTitle(String tabSubTitle) {
        this.tabSubTitle = tabSubTitle;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
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
}
