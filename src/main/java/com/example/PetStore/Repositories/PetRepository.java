package com.example.PetStore.Repositories;

import com.example.PetStore.Entities.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends JpaRepository<PetEntity, Integer> {
    List<PetEntity> findAll();

    void deleteById(Integer id);

    PetEntity getById(Integer id);


    @Modifying
    @Query(value = "UPDATE pet_entity SET weight = :weight, price = :price, definition = :definition, name = :name WHERE id=:id", nativeQuery = true)
    void updatePetEntityById(@Param("id")Integer id,
                             @Param("weight") Double weight,
                             @Param("price")Double price,
                             @Param("definition")String definition,
                             @Param("name")String name);
}
