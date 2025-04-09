package com.cropdeal.farmer_service.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cropdeal.farmer_service.model.Farmer;
import com.cropdeal.farmer_service.repository.FarmerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmerService {

    private  static final Logger logger = LoggerFactory.getLogger(FarmerService.class);

    @Autowired
    private FarmerRepository repo;

    public List<Farmer> getAllFarmers() {
        logger.info("Fetching all farmers");
        return repo.findAll();
    }

    public Farmer getFarmerById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Farmer not found with id " + id));
    }
    public Farmer addFarmer(Farmer farmer) {
        logger.info("Saving new farmer: {}", farmer.getName());
        return repo.save(farmer);
    }


    public void deleteFarmer(Long id) {
        repo.deleteById(id);
    }

    public Farmer updateFarmer(Long id, Farmer updated) {
        updated.setId(id);
        return repo.save(updated);
    }
}
