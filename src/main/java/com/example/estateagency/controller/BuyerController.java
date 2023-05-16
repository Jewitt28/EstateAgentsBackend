package com.example.estateagency.controller;

import com.example.estateagency.model.Buyers;
import com.example.estateagency.repo.BuyerRepo;
import com.example.estateagency.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    BuyerService service;

    @Autowired
    BuyerRepo bRepo;

    @GetMapping("/read")
    public List<Buyers> read() {
        return service.getAll();
    }

    @GetMapping("/read/{id}")
    public Buyers readOne(@PathVariable long id) {
        return service.getBuyer(id);
    }

    @PostMapping("/add")
    public Buyers add(@RequestBody Buyers newBuy) {
        return service.createBuyer(newBuy);
    }

    @DeleteMapping("/delete/{id}")
    public Buyers delete(@PathVariable long id) {
        return service.deleteBuyer(id);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody Buyers newBuy, @PathVariable long id) {
         service.updateBuyers(id, newBuy);
    }
}

