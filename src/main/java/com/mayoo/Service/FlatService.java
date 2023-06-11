package com.mayoo.Service;

import com.mayoo.DTO.FlatMapper;
import com.mayoo.Entity.FlatEntity;
import com.mayoo.Repository.FlatRepository;
import com.mayoo.openapi.model.Flat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlatService implements IFlatService{
    private final FlatRepository flatRepository;
    @Override
    public List<Flat> allFlat() {
        List<FlatEntity> flatEntities = flatRepository.findAll();
        List<Flat> result = new ArrayList<>();
        
        flatEntities.forEach(flatEntity -> result.add(FlatMapper.flatEntityToFlat(flatEntity)));
        return result;
    }

    @Override
    public void addFlat(Flat flat) {
    }

    @Override
    public Flat deleteFlat(Flat flat) {
        return null;
    }

    @Override
    public Flat getDetailsFlat(Long id) {
        FlatEntity flat = flatRepository.findById(id)
                .orElseThrow();
        return FlatMapper.flatEntityToFlat(flat);
    }
}
