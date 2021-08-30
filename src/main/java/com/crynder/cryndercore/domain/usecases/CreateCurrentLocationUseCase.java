package com.crynder.cryndercore.domain.usecases;

import com.crynder.cryndercore.domain.models.location.Location;
import com.crynder.cryndercore.domain.models.user.User;
import com.crynder.cryndercore.domain.repositories.CurrentLocationRepository;
import com.crynder.cryndercore.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCurrentLocationUseCase {

    private final CurrentLocationRepository currentLocationRepository;
    private final UserService userService;

    @Autowired
    public CreateCurrentLocationUseCase(CurrentLocationRepository currentLocationRepository,
                                        UserService userService) {
        this.currentLocationRepository = currentLocationRepository;
        this.userService = userService;
    }

    public void create(Location location) {
        User user = userService.findById(location.getUserId());
        currentLocationRepository.saveCurrentLocation(location);
    }
}
