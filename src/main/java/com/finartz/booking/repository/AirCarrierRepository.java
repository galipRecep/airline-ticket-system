package com.finartz.booking.repository;

import com.finartz.booking.model.AirCarrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AirCarrierRepository extends JpaRepository<AirCarrier,Long> {

    @Query("select s from AirCarrier s where lower(s.name) like lower(concat('%', ?1,'%'))")
    List<AirCarrier> findByName(String name);
}
