package com.example.PetStore.Services;

import com.example.PetStore.Entities.PetEntity;
import com.example.PetStore.Repositories.PetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public void addPet(PetEntity newPet) {
        petRepository.save(newPet);
    }

    public List<PetEntity> getAllPets(){
        return petRepository.findAll();
    }

    public void deletePetById(Integer id){
        petRepository.deleteById(id);
    }

    public PetEntity getPetById(Integer id) {
        return petRepository.getById(id);
    }

    @Transactional(rollbackOn = Exception.class)
    public void updatePetInfo(Integer id, String name, String definition, Double price, Double weight){
        petRepository.updatePetEntityById(id, weight, price, definition, name);
    }
}
