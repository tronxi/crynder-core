package com.crynder.cryndercore.domain.models.location;

public class Location {
    private final String userId;
    private final Coordinate coordinate;

    public Location(String userId, Coordinate coordinate) {
        this.userId = userId;
        this.coordinate = coordinate;
    }

    public String getUserId() {
        return userId;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
