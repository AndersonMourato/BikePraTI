package br.com.bikeprati.repository;

import br.com.bikeprati.models.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, Integer> {
}
