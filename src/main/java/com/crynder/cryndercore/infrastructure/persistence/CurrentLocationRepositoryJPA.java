package com.crynder.cryndercore.infrastructure.persistence;

import com.crynder.cryndercore.domain.models.location.Location;
import com.crynder.cryndercore.domain.models.user.User;
import com.crynder.cryndercore.domain.repositories.CurrentLocationRepository;
import com.crynder.cryndercore.infrastructure.persistence.dao.CurrentLocationDao;
import com.crynder.cryndercore.infrastructure.persistence.dao.UserDAO;
import com.crynder.cryndercore.infrastructure.persistence.entities.CurrentLocationEntity;
import com.crynder.cryndercore.infrastructure.persistence.entities.UserEntity;
import com.crynder.cryndercore.infrastructure.persistence.mappers.CurrentLocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class CurrentLocationRepositoryJPA implements CurrentLocationRepository {

    private final CurrentLocationMapper currentLocationMapper;
    private final CurrentLocationDao currentLocationDao;
    private final UserDAO userDAO;

    @Autowired
    public CurrentLocationRepositoryJPA(CurrentLocationMapper currentLocationMapper, CurrentLocationDao currentLocationDao, UserDAO userDAO) {
        this.currentLocationMapper = currentLocationMapper;
        this.currentLocationDao = currentLocationDao;
        this.userDAO = userDAO;
    }

    @Override
    public void saveCurrentLocation(Location location) {
        UserEntity userEntity = userDAO.findById(location.getUserId())
                .orElseThrow(RuntimeException::new);

        CurrentLocationEntity maybeActualCurrentLocation = currentLocationDao.findByUser(userEntity)
                .map(currentLocationEntity -> {
                    currentLocationEntity.setModificationDate(LocalDate.now());
                    currentLocationEntity.setLongitude(location.getCoordinate().getLongitude());
                    currentLocationEntity.setLatitude(location.getCoordinate().getLatitude());
                    return currentLocationEntity;
                })
                .orElseGet(() -> currentLocationMapper.map(location));

        currentLocationDao.save(maybeActualCurrentLocation);
    }

    @Override
    public Optional<Location> findByUser(User user) {
        return Optional.empty();
    }
}
