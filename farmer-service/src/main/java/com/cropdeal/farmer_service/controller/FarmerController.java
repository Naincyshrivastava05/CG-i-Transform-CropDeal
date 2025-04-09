package com.cropdeal.farmer_service.controller;

import com.cropdeal.farmer_service.dto.FarmerDTO;
import com.cropdeal.farmer_service.model.Farmer;
import com.cropdeal.farmer_service.service.FarmerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farmers")
public class FarmerController {


    @Autowired
    private FarmerService farmerService;

    @GetMapping("/")
    public String home() {
        return "Welcome to Farmer Service";
    }

    @GetMapping
    public List<Farmer> getAllFarmers() {
        return farmerService.getAllFarmers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FarmerDTO> getFarmer(@PathVariable Long id) {
        Farmer farmer = farmerService.getFarmerById(id);

        FarmerDTO dto = new FarmerDTO();
        dto.setName(farmer.getName());
        dto.setEmail(farmer.getEmail());
        dto.setLocation(farmer.getLocation());

        return ResponseEntity.ok(dto);
    }



    @PostMapping
    public Farmer createFarmer(@Valid @RequestBody Farmer farmer) {
        return farmerService.addFarmer(farmer);
    }

    @PutMapping("/{id}")
    public Farmer updateFarmer(@PathVariable Long id,@Valid @RequestBody Farmer farmer) {
        return farmerService.updateFarmer(id, farmer);
    }

    @DeleteMapping("/{id}")
    public void deleteFarmer(@PathVariable Long id) {
        farmerService.deleteFarmer(id);
    }
}
