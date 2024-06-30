package com.project.hardcore.framework.model;

import java.util.Objects;

public class Instance {
    private String numberOfInstances;
    private String localSSD;
    private String dataCenterLocation;

    public Instance(String numberOfInstances, String localSSD, String dataCenterLocation){
        this.numberOfInstances = numberOfInstances;
        this.localSSD = localSSD;
        this.dataCenterLocation = dataCenterLocation;
    }

    public String getNumberOfInstances() { return numberOfInstances; }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getLocalSSD() { return localSSD; }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDataCenterLocation() { return dataCenterLocation; }

    public void setDataCenterLocation(String dataCenterLocation) {
        this.dataCenterLocation = dataCenterLocation;
    }

    @Override
    public String toString() {
        return "Instance{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", dataCenterLocation='" + dataCenterLocation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instance instance = (Instance) o;
        return Objects.equals(numberOfInstances, instance.numberOfInstances) && Objects.equals(localSSD, instance.localSSD) && Objects.equals(dataCenterLocation, instance.dataCenterLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, localSSD, dataCenterLocation);
    }
}
