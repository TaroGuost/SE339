package edu.microserviceslab.vehiclemicroservice.repo;

import edu.microserviceslab.vehiclemicroservice.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Long> {

    @Query(value = "delete  from vehicle u where u.model is null" , nativeQuery = true)
    void deleteByModel();
}
