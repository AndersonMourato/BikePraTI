package br.com.bikeprati.controller;

import br.com.bikeprati.models.Bike;
import br.com.bikeprati.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    BikeService bikeService;

    @GetMapping
    public ResponseEntity<List<Bike>> getAllBikes() {
        List<Bike> bikeList = bikeService.findAll();
        return ResponseEntity.ok().body(bikeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getBike(@PathVariable Integer id) {
        Bike bike = bikeService.findById(id);
        return ResponseEntity.ok().body(bike);
    }

    @PostMapping
    public ResponseEntity<Bike> saveBike(@RequestBody Bike bike){
        return ResponseEntity.ok().body(bikeService.save(bike));
    }

    @PutMapping
    public ResponseEntity<Bike> updateBike(@RequestBody Bike bike){
        return ResponseEntity.ok().body(bikeService.update(bike));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Bike> deleteBike(@PathVariable Integer id){
        bikeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
