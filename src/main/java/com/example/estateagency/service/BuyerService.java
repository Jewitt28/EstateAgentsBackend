package com.example.estateagency.service;

import com.example.estateagency.model.Buyers;
import com.example.estateagency.repo.BuyerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepo repo;

    public BuyerService(BuyerRepo repo){
        this.repo = repo;
    }
    public BuyerService(){

    }

    public List<Buyers> getAll() {
        return this.repo.findAll();
    }


    public Buyers getBuyer(Long id) {

        return this.repo.findById(id).get();

    }


    public Buyers createBuyer (Buyers dep){

        return this.repo.save(dep);

    }
    public Buyers updateBuyers (long buyer_id, Buyers updatedBuyer)
    {
        Buyers toUpdate = this.getBuyer(buyer_id);
        toUpdate.setFirstName(updatedBuyer.getFirstName());
        toUpdate.setLastName(updatedBuyer.getLastName());
        toUpdate.setEmail(updatedBuyer.getEmail());
        toUpdate.setPhone(updatedBuyer.getPhone());

        return this.repo.save(toUpdate);
    }

    public Buyers deleteBuyer (long id){
        Buyers removed = this.getBuyer(id);
        this.repo.deleteById(id);
        return removed;

    }


}
