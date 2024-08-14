package com.jts.crud.controller;

import com.jts.crud.entity.Fruit;
import com.jts.crud.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FruitController {
    @Autowired
    private FruitService fruitService;

    @GetMapping("/fruits")
    private List<Fruit> findAll() {
        return fruitService.findAll();
    }

    @GetMapping("/findById")
    private Fruit findById(@RequestParam int id) {
        return fruitService.findById(id);
    }

    @PostMapping("/fruits")
    public Fruit save(@RequestBody Fruit fruit) {
        return fruitService.saveFruit(fruit);
    }

    @PutMapping("/fruits")
    public Fruit update(@RequestParam int id, @RequestBody Fruit fruit) {
        return fruitService.updateFruit(id, fruit);
    }

    @DeleteMapping("/fruits")
    public String delete(@RequestParam int id) {
        return fruitService.softDeleteFruit(id);
    }
}
