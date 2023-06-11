package com.mayoo.Service;

import com.mayoo.openapi.model.Flat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlatService implements IFlatService{
    @Override
    public List<Flat> allFlat() {
        return null;
    }

    @Override
    public void addFlat() {

    }

    @Override
    public Flat deleteFlat() {
        return null;
    }

    @Override
    public Flat getDetailsFlat() {
        return null;
    }
}
