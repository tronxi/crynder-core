package com.crynder.cryndercore.domain.repositories;

import com.crynder.cryndercore.domain.models.location.Location;
import com.crynder.cryndercore.domain.models.user.User;

import java.util.Optional;

public interface CurrentLocationRepository {
    void saveCurrentLocation(Location location);
    Optional<Location> findByUser(User user);
}
