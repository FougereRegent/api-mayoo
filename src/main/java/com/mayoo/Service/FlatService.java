package com.mayoo.Service;

import com.mayoo.DTO.FlatMapper;
import com.mayoo.Entity.FlatEntity;
import com.mayoo.Exceptions.CustomException;
import com.mayoo.Repository.FlatRepository;
import com.mayoo.Repository.PictogramRepository;
import com.mayoo.Service.ResponsabiltyChain.FieldFlatCheck.CheckCreatingFlatBuilder;
import com.mayoo.Service.ResponsabiltyChain.IComponentCheck;
import com.mayoo.openapi.model.Flat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlatService implements IFlatService{
    private final FlatRepository flatRepository;
    private final PictogramRepository pictogramRepository;
    @Override
    public List<Flat> allFlat() {
        List<FlatEntity> flatEntities = flatRepository.findAll();
        List<Flat> result = new ArrayList<>();
        
        flatEntities.forEach(flatEntity -> result.add(FlatMapper.flatEntityToFlat(flatEntity)));
        return result;
    }

    @Override
    public void addFlat(Flat flat) throws CustomException {
        IComponentCheck<Flat> check = CheckCreatingFlatBuilder.builder(flatRepository, pictogramRepository);
        try {
            check.execute(flat);
        }
        catch (CustomException exception) {
            throw exception;
        }
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