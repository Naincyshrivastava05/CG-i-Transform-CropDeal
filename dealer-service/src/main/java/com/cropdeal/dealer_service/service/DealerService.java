package com.cropdeal.dealer_service.service;

import com.cropdeal.dealer_service.model.Dealer;
import  com.cropdeal.dealer_service.repository.DealerRepository;
import  jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DealerService {
    @Autowired
    private DealerRepository repository;

    public Dealer addDealer(Dealer dealer){
        return repository.save(dealer);
    }

    public List<Dealer> getAllDealers(){
        return repository.findAll();
    }

    public Dealer getDealerById(Long id){
        return repository.findById(id).orElseThrow(()->new EntityNotFoundException("Dealer not found with id "+ id));
    }

    public Dealer updateDealer(Long id, Dealer dealer){
        Dealer existing = getDealerById(id);
        existing.setName(dealer.getName());
        existing.setEmail(dealer.getEmail());
        existing.setPhone(dealer.getPhone());
        existing.setLocation(dealer.getLocation());
        return  repository.save(existing);

    }
    public void deleteDealer(Long id){
        repository.deleteById(id);
    }
}
