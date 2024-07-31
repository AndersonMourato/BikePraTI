package br.com.bikeprati.service;

import br.com.bikeprati.exception.NoSuchElementException;
import br.com.bikeprati.exception.ObjectNotFoundException;
import br.com.bikeprati.models.Bike;
import br.com.bikeprati.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BikeService {
    @Autowired
    BikeRepository bikeRepository;

    public List<Bike> findAll() {
        List<Bike> bikeList = bikeRepository.findAll();
        if (!bikeList.isEmpty()) {
            return bikeList;
        }
        throw new ObjectNotFoundException("Nem uma bike cadastrada no momento.");
    }

    public Bike findById(Integer id) {
        Optional<Bike> bike = bikeRepository.findById(id);
        if (bike.isPresent()) {
            return bike.get();
        }
        throw new NoSuchElementException("Id invalido ou Bike não cadastrada.");
    }

    public Bike save(Bike bike) {
        bike.setId(null);
        return bikeRepository.save(bike);
    }

    public Bike update(Bike bike) {
        if (bikeRepository.existsById(bike.getId())) {
            return bikeRepository.save(bike);
        }
        throw new NoSuchElementException("Id invalido ou Bike não cadastrada.");
    }

    public String deleteById(Integer id) {
        if (bikeRepository.existsById(id)) {
            bikeRepository.deleteById(id);
            return "Bike removida com exito.";
        } else {
            throw new NoSuchElementException("Id invalido ou Bike não cadastrada.");

        }
    }

    @Bean
    public void setDbTeste() {
        save(new Bike(null, "BlowRed", "Infantil", new Date(), 281.55));
        save(new Bike(null, "BlackWhite", "Adulto", new Date(), 125.55));
    }
}
