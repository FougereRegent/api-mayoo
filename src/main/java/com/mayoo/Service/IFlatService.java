package com.mayoo.Service;

import java.util.List;

public interface IFlatService {
    List<com.mayoo.openapi.model.Flat> allFlat();
    void addFlat(com.mayoo.openapi.model.Flat flat);
    com.mayoo.openapi.model.Flat deleteFlat(com.mayoo.openapi.model.Flat flat);
    com.mayoo.openapi.model.Flat getDetailsFlat(Long id);
}