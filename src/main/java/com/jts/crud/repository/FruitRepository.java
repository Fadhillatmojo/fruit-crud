package com.jts.crud.repository;

import com.jts.crud.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {
    // Temukan entitas berdasarkan ID dan pastikan belum dihapus
    Optional<Fruit> findByIdAndDeletedAtIsNull(Integer id);

    // Temukan semua entitas di mana deletedAt adalah null
    List<Fruit> findByDeletedAtIsNull();
}
