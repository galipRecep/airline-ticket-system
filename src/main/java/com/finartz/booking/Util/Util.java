package com.finartz.booking.Util;

import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    private static ModelMapper modelMapper = new ModelMapper();

    public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> modelMapper.map(entity, outCLass))
                .collect(Collectors.toList());
    }

    public static Double calculatePrice(int count, int quota, Double basePrice){
        Double updatedPrice = basePrice;

        if (count > 0  && count <quota){
            int percentage = (100 * count) / quota;
            if (percentage >= 10) {
                updatedPrice = updatedPrice + (basePrice/10);
            }
            if (percentage >= 20){
                updatedPrice = updatedPrice + (basePrice/10);
            }
            if (percentage >= 30){
                updatedPrice = updatedPrice + (basePrice/10);
            }
            if (percentage >= 40){
                updatedPrice = updatedPrice + (basePrice/10);
            }
            if (percentage >= 50){
                updatedPrice = updatedPrice + (basePrice/10);
            }
            if (percentage >= 60){
                updatedPrice = updatedPrice + (basePrice/10);
            }
            if (percentage >= 70){
                updatedPrice = updatedPrice + (basePrice/10);
            }
            if (percentage >= 80){
                updatedPrice = updatedPrice + (basePrice/10);
            }
            if (percentage >= 90){
                updatedPrice = updatedPrice + (basePrice/10);
            }
            return updatedPrice;
        }

        return  updatedPrice;
    }

    public static String maskCardNumber(String cardNumber) {
        cardNumber = cardNumber.replaceAll("-", "");
        cardNumber = cardNumber.replaceAll(",", "");
        cardNumber = cardNumber.trim();
        if(cardNumber.length()==16){
            StringBuilder maskedNumber = new StringBuilder();
            for (int i = 0; i < 16; i++) {
                if( i>3 && i<12){
                    maskedNumber.append('*');
                }else{
                    maskedNumber.append(cardNumber.charAt(i));
                }
            }
            return maskedNumber.toString();
        }else throw new IllegalArgumentException("Kart Numarası Hatalı");

    }
}
