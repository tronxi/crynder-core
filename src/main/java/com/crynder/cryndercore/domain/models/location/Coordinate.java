package com.crynder.cryndercore.domain.models.location;

public class Coordinate {
    private final Double latitude;
    private final Double longitude;

    public Coordinate(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
