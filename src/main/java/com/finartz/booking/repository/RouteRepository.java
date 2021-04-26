package com.finartz.booking.repository;

import com.finartz.booking.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route,Long> {

    @Query("select s from Route s where lower(s.name) like lower(concat('%', ?1,'%'))")
    List<Route> findByName(String name);

    @Query("select s from Route s where lower(s.code) like lower(concat('%', ?1,'%'))")
    List<Route> findByCode(String code);
}
