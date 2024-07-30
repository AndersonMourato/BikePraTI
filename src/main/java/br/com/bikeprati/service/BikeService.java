package br.com.bikeprati.service;

import br.com.bikeprati.exception.NoSuchElementException;
import br.com.bikeprati.models.Bike;
import br.com.bikeprati.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService {
    @Autowired
    BikeRepository bikeRepository;

    public List<Bike> findAll(){
        List<Bike> bikeList = bikeRepository.findAll();
       if (!bikeList.isEmpty()){
           return bikeList;
       }
        throw new NoSuchElementException("Nem uma bike cadastrada no momento.");
    }

    public Bike findById(Integer id){
        Optional<Bike> bike = bikeRepository.findById(id);
        if (bike.isPresent()){
            return bike.get();
        }
        throw new NoSuchElementException("Id invalido ou Bike não cadastrada.");
    }

    public Bike save(Bike bike){
        bike.setId(null);
        return bikeRepository.save(bike);
    }

    public Bike update(Bike bike){
        if (bikeRepository.existsById(bike.getId())){
            return bikeRepository.save(bike);
        }
        return new Bike(); // Exception ObjectNotFound
    }

    public void deleteById(Integer id){
        if (bikeRepository.existsById(id)){
            bikeRepository.deleteById(id);
        }else {
            throw new NoSuchElementException("Id invalido ou Bike não cadastrada.");
        }
    }

    @Bean
    public void setDbTeste(){
        save(new Bike(1, "teste", "Infantil", "2019-01-21", 125.55));
    }
}
