package br.com.bikeprati.service;

import br.com.bikeprati.models.Bike;
import br.com.bikeprati.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {
    @Autowired
    BikeRepository bikeRepository;

    public List<Bike> findAll(){
        List<Bike> bikeList = bikeRepository.findAll();
       if (!bikeList.isEmpty()){
           return bikeList;
       }
        return bikeList; // Exception ObjectNotFound
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
        }
        // Exception ObjectNotFound
    }

    @Bean
    public void setDbTeste(){
        save(new Bike(1, "teste", "Infantil", "2019-01-21", 125.55));
    }
}
