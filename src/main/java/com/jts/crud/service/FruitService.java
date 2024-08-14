package com.jts.crud.service;

import com.jts.crud.entity.Fruit;
import com.jts.crud.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    // ini Get All Fruit
    public List<Fruit> findAll() {
        return fruitRepository.findByDeletedAtIsNull();
    }

    // ini fungsi find ID nanti bisa dipake di update atau delete atau bisa juga buat show misal ada show
    public Fruit findById(int id) {
        Optional<Fruit> fruit = fruitRepository.findByIdAndDeletedAtIsNull(id);

        if (fruit.isEmpty()) {
            throw new RuntimeException("Fruit Not Found!");
        }

        return fruit.get();
    }

    // ini post request
    public Fruit saveFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    // ini update request
    public Fruit updateFruit(int id, Fruit fruit) {
        // pertama cari dulu ada gak id nya fruit di database

        Fruit existingFruit = findById(id);
        existingFruit.setName(fruit.getName());
        existingFruit.setType(fruit.getType());
        existingFruit.setColor(fruit.getColor());
        existingFruit.setTaste(fruit.getTaste());
        existingFruit.setOrigin(fruit.getOrigin());
        existingFruit.setHarvestSeason(fruit.getHarvestSeason());

        return fruitRepository.save(existingFruit);
    }

    // ini normal Delete
    public String deleteFruit(int id) {
        // pertama cari dulu ada gak id nya fruit di database
        fruitRepository.delete(findById(id));

        return "Fruit Deleted Succesfully!";
    }

    // Soft Delete Fruit
    public String softDeleteFruit(int id) {
        // Check apakah ada ID nya di database
//        Optional<Fruit> dbFruit = fruitRepository.findById(id);
//
//        if (dbFruit.isEmpty()) {
//            throw new RuntimeException("Fruit Not Found!");
//        }

        Fruit existingFruit = findById(id);

        // gas soft delete
        existingFruit.setDeletedAt(LocalDateTime.now());

        // Save safe updated entity karena td udh di update deletedAt nya
        fruitRepository.save(existingFruit);

        return "Fruit Soft Deleted Succesfully!";
    }


}
