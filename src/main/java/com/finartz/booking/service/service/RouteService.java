package com.finartz.booking.service.service;

import com.finartz.booking.dto.RouteDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RouteService {

    RouteDto save(RouteDto routeDto);

    List<RouteDto> saveAll(List<RouteDto> routeDtoList);

    void delete(Long id);

    List<RouteDto> getAll() ;

    List<RouteDto> findByName(Optional<String> name);

    List<RouteDto> findByCode(Optional<String> code);

    RouteDto findById(Long id);
}
