package com.example.navredesign;

public class CardItem2 {
    private String name;
    private double earnedPercent;
    private double totalPercent;
    private double rate;
    private int services;
    private int totalServices;
    private int starRating;

    public CardItem2(String name, double earnedPercent, double totalPercent, double rate, int services, int totalServices, int starRating) {
        this.name = name;
        this.earnedPercent = earnedPercent;
        this.totalPercent = totalPercent;
        this.rate = rate;
        this.services = services;
        this.totalServices = totalServices;
        this.starRating = starRating;
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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getServices() {
        return services;
    }

    public void setServices(int services) {
        this.services = services;
    }

    public int getTotalServices() {
        return totalServices;
    }

    public void setTotalServices(int totalServices) {
        this.totalServices = totalServices;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }
}
