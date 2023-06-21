package com.mayoo.Controller;

import com.mayoo.Service.IFlatService;
import com.mayoo.openapi.api.FlatApi;
import com.mayoo.openapi.model.Flat;
import com.mayoo.openapi.model.FlatGet200ResponseInner;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FlatController implements com.mayoo.openapi.api.FlatApi {
    private final IFlatService flatService;

    @Override
    public ResponseEntity<List<FlatGet200ResponseInner>> flatGet() {
        List<Flat> flats = flatService.allFlat();
        
        return new ResponseEntity(flats, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Flat> flatIdGet(Integer id) {
        return FlatApi.super.flatIdGet(id);
    }

    @Override
    public ResponseEntity<Void> flatPost(Flat flat) {
        return FlatApi.super.flatPost(flat);
    }
}