package com.mayoo.Service;

import com.mayoo.Exceptions.CustomException;

import java.util.List;

public interface IFlatService {
    List<com.mayoo.openapi.model.Flat> allFlat();
    void addFlat(com.mayoo.openapi.model.Flat flat) throws CustomException;
    com.mayoo.openapi.model.Flat deleteFlat(com.mayoo.openapi.model.Flat flat);
    com.mayoo.openapi.model.Flat getDetailsFlat(Long id);
}