package com.zakat.myapp.entity;

import javax.persistence.Entity;

public class SortedMethodModel {

    private String sortedStatus;
    private double sortedSum;
    private String sortedProducer;
    private String sortedBase;

    public SortedMethodModel() {
    }


    public SortedMethodModel(String sortedStatus, double sortedSum, String sortedProducer, String sortedBase) {
        this.sortedStatus = sortedStatus;
        this.sortedSum = sortedSum;
        this.sortedProducer = sortedProducer;
        this.sortedBase = sortedBase;
    }

    public String getSortedStatus() {
        return sortedStatus;
    }

    public void setSortedStatus(String sortedStatus) {
        this.sortedStatus = sortedStatus;
    }

    public double getSortedSum() {
        return sortedSum;
    }

    public void setSortedSum(double sortedSum) {
        this.sortedSum = sortedSum;
    }

    public String getSortedProducer() {
        return sortedProducer;
    }

    public void setSortedProducer(String sortedProducer) {
        this.sortedProducer = sortedProducer;
    }

    public String getSortedBase() {
        return sortedBase;
    }

    public void setSortedBase(String sortedBase) {
        this.sortedBase = sortedBase;
    }
}
