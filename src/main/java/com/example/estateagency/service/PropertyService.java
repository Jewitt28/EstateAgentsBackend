package com.example.estateagency.service;

import com.example.estateagency.model.Properties;
import com.example.estateagency.model.Buyers;
import com.example.estateagency.repo.PropertyRepo;
import com.example.estateagency.repo.SellerRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PropertyService {
    @Autowired
    private SellerRepo sRepo;
    @Autowired
    private PropertyRepo repo;

    public PropertyService(SellerRepo sRepo, PropertyRepo repo) {
        this.sRepo = sRepo;
        this.repo = repo;
    }

    public SellerRepo getsRepo() {
        return sRepo;
    }

    public void setsRepo(SellerRepo sRepo) {
        this.sRepo = sRepo;
    }

    public PropertyService() {

    }

    public PropertyRepo getRepo() {
        return repo;
    }

    public void setRepo(PropertyRepo repo) {
        this.repo = repo;
    }

    public List<Properties> getAll() {
        return this.repo.findAll();
    }


    public Properties getProperty(Long id) {
        // Optional is a wrapper around something which may or may not exist
        Optional<Properties> propertyOptional =  this.repo.findById(id);
        if (propertyOptional.isPresent()) return  propertyOptional.get();
        throw new EntityNotFoundException("Property with id " + id + " does not exist");
    }


    public Properties createProperty(Properties prop) {
//        Optional<Sellers> seller = this.sRepo.findById(properties.getSellers().getId());
//        properties.setSellers(seller.get());
        return this.repo.save(prop);

    }

    public Properties deleteProperty(Long id) {
        Properties removed = this.getProperty(id);
        this.repo.deleteById(id);
        return removed;

    }

    public Properties updateProperty(Long id, Properties newProp) {

       // Optional<Properties> properties = repo.findById(id);
       // if (properties.isPresent()) {
            Properties toUpdate = this.getProperty(id);
          //  newProp = Properties.get();
            if (newProp.getAddress() != null)
                toUpdate.setAddress(newProp.getAddress());

            if (newProp.getPostcode() != null)
                toUpdate.setPostcode(newProp.getPostcode());

            if (newProp.getPrice() >= 0)
                toUpdate.setPrice(newProp.getPrice());

            if (newProp.getStatus() != null)
                toUpdate.setStatus(newProp.getStatus());

            if (newProp.getType() != null)
                toUpdate.setType(newProp.getType());

            if (newProp.getBedrooms() >= 0)
                toUpdate.setBedrooms(newProp.getBedrooms());

            if (newProp.getBathrooms() >= 0)
                toUpdate.setBathrooms(newProp.getBathrooms());

            if (newProp.getGarden() >= 0)
                toUpdate.setGarden(newProp.getGarden());
            if (newProp.getSellers() != null) toUpdate.setSellers(newProp.getSellers());

            //return properties.get();
            return this.repo.save(toUpdate);
        }

    public Properties updateStatus(long id, String status) {
        Properties toUpdate = getProperty(id);
        toUpdate.setStatus(status);
        return repo.save(toUpdate);
    }
}
