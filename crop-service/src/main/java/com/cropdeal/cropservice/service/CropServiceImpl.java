package com.cropdeal.cropservice.service;

import com.cropdeal.cropservice.model.Crop;
import com.cropdeal.cropservice.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CropServiceImpl implements CropService {

    @Autowired
    private CropRepository repository;

    public Crop addCrop(Crop crop) {
        return repository.save(crop);
    }

    public List<Crop> getAllCrops() {
        return repository.findAll();
    }

    public Crop getCropById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Crop updateCrop(Long id, Crop updatedCrop) {
        Crop existing = getCropById(id);
        existing.setName(updatedCrop.getName());
        existing.setType(updatedCrop.getType());
        existing.setPrice(updatedCrop.getPrice());
        existing.setQuantity(updatedCrop.getQuantity());
        return repository.save(existing);
    }


    public void deleteCrop(Long id) {
        repository.deleteById(id);
    }
}
