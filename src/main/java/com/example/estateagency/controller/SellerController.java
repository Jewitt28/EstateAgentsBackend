package com.example.estateagency.controller;

import com.example.estateagency.model.Sellers;
import com.example.estateagency.repo.SellerRepo;
import com.example.estateagency.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = "*")
@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerRepo mRepo;

    @Autowired
    SellerService service;

    @GetMapping("/read")
    public List<Sellers> read() {
        return service.getAll();
    }

    @GetMapping("/read/{id}")
    public Sellers readOne(@PathVariable long id) {
        return service.getSeller(id);
    }

    @PostMapping("/add")
    public Sellers add(@RequestBody Sellers newSeller) {
        return service.createSeller(newSeller);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        service.deleteSeller(id);
    }

    @PutMapping("/update/{id}")
    public Sellers updatePerson(@PathVariable long id
            , @RequestBody Sellers sellers) {
        return this.service.updateSeller(id, sellers);

    }
}
