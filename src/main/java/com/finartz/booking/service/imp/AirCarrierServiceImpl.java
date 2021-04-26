package com.finartz.booking.service.imp;

import com.finartz.booking.Util.Util;
import com.finartz.booking.dto.AirCarrierDto;
import com.finartz.booking.model.AirCarrier;
import com.finartz.booking.repository.AirCarrierRepository;
import com.finartz.booking.service.service.AirCarrierService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AirCarrierServiceImpl implements AirCarrierService {

    private final AirCarrierRepository airCarrierRepository;
    private static ModelMapper modelMapper = new ModelMapper();

    @Override
    @Transactional
    public AirCarrierDto save(AirCarrierDto airCarrierDto) {
        AirCarrier airCarrier = modelMapper.map(airCarrierDto,AirCarrier.class);
        airCarrier = airCarrierRepository.save(airCarrier);
        airCarrierDto.setId(airCarrier.getId());
        return  airCarrierDto;
    }

    @Override
    public void delete(Long id) {
        airCarrierRepository.deleteById(id);
    }

    @Override
    public List<AirCarrierDto> getAll() {
        List<AirCarrier> carrierList = airCarrierRepository.findAll();
        List<AirCarrierDto> airCarrierDtos = new ArrayList<>();
        if(carrierList!=null){
            airCarrierDtos = Util.mapAll(carrierList,AirCarrierDto.class);
        }
        return airCarrierDtos;
    }

    @Override
    public List<AirCarrierDto> findByName(Optional<String> name) {
        List<AirCarrier> carrierList = airCarrierRepository.findByName(name.orElse("_"));
        List<AirCarrierDto> airCarrierDtos = Util.mapAll(carrierList,AirCarrierDto.class);
        return airCarrierDtos;
    }

    @Override
    public AirCarrierDto findById(Long id) {
        AirCarrier airCarrier = airCarrierRepository.findById(id).orElse(null);
        AirCarrierDto airCarrierDto = null;
        if (airCarrier !=null){
            airCarrierDto = modelMapper.map(airCarrier,AirCarrierDto.class);
        }
        return airCarrierDto;
    }
}
