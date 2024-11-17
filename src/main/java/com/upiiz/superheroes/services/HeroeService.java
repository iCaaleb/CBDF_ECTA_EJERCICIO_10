package com.upiiz.superheroes.services;

import com.upiiz.superheroes.entities.HeroeEntity;
import com.upiiz.superheroes.repositories.HeroeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroeService {

    @Autowired
    private HeroeRepository heroeRepository;

    // Obtener todos los Heroes
    public List<HeroeEntity> obtenerHeroes(){
        return heroeRepository.findAll();
    }

    // Obtener Heroe por ID
    public HeroeEntity obtenerHeroePorId(Long id) {
        return heroeRepository.findById(id).orElse(null);
    }

    // Agregar un héroe
    public HeroeEntity crearHeroe(HeroeEntity heroe) {
        return heroeRepository.save(heroe);
    }

    // Eliminar heroe por ID
    public void eliminarHeroe(Long id) {
        heroeRepository.deleteById(id);
    }
}
