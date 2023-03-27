package by.itacademy.it_bootcamp.converter;


public interface UserConverter <E, D> {

        D toDto(E entity);

        E toEntity(D dto);
    }


