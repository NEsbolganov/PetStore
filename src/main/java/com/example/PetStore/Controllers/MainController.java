package com.example.PetStore.Controllers;

import com.example.PetStore.Entities.PetEntity;
import com.example.PetStore.Services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    private final PetService petService;

    @Autowired
    public MainController(PetService petService) {
        this.petService = petService;
    }


    @GetMapping("/main")
    public String getMainPage(){
        return "index";
    }

    @PostMapping("/add/pet")
    public String addPet(@RequestParam("name") String name,
                         @RequestParam("price")Double price,
                         @RequestParam("weight") Double weight,
                         @RequestParam("description")String definition
                         ){
        PetEntity newPet = new PetEntity(name,definition,price,weight);
        petService.addPet(newPet);
        return "redirect:/main";
    }

    @ModelAttribute("petsList")
    public List<PetEntity> petsList(){
        return petService.getAllPets();
    }

    @PostMapping("/delete/pet")
    public String deletePet(@RequestParam("id") Integer petId){
        petService.deletePetById(petId);
        return "redirect:/main";
    }

    @GetMapping("/update/pet/{id}")
    public String petPage(@PathVariable("id")Integer id, Model model){
        model.addAttribute("pet", petService.getPetById(id));
        return "/pet";
    }

    @PostMapping("/update/pet")
    public String updatePet(@RequestParam("id") Integer id,
                            @RequestParam("pet-name") String name,
                            @RequestParam("pet-price")Double price,
                            @RequestParam("pet-weight") Double weight,
                            @RequestParam("pet-definition")String definition){
        petService.updatePetInfo(id, name, definition, price, weight);
        return "redirect:/main";
    }
}
