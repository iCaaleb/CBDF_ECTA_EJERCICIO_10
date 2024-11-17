package com.upiiz.superheroes.controllers;

import com.upiiz.superheroes.entities.HeroeEntity;
import com.upiiz.superheroes.services.HeroeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/superheroe/")
public class HeroeController {
    @Autowired
    HeroeService heroeService;

    // GET de todos los heroes
    @GetMapping
    public ResponseEntity<List<HeroeEntity>> getAllHeroes() {
        return ResponseEntity.ok(heroeService.obtenerHeroes());
    }

    // GET de un heroe por su ID
    @GetMapping("/{id}")
    public ResponseEntity<HeroeEntity> getHeroeById(@PathVariable Long id) {
        return ResponseEntity.ok(heroeService.obtenerHeroePorId(id));
    }

    // POST de un heroe
    @PostMapping
    public ResponseEntity<HeroeEntity> postHeroe(@RequestBody HeroeEntity heroe) {
        return ResponseEntity.ok(heroeService.crearHeroe(heroe));
    }
    // PUT de un héroe
    @PutMapping
    public ResponseEntity<HeroeEntity> putHeroe(@RequestBody HeroeEntity heroe, @PathVariable Long id) {
        heroe.setId(id);
        return ResponseEntity.ok(heroeService.crearHeroe(heroe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHeroe(@PathVariable Long id) {
        heroeService.eliminarHeroe(id);
        return ResponseEntity.noContent().build();
    }
}
