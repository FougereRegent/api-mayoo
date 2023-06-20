package com.mayoo.Service.ResponsabiltyChain.FieldFlatCheck.Component;

import com.mayoo.DTO.FlatMapper;
import com.mayoo.Entity.FlatEntity;
import com.mayoo.Exceptions.CustomException;
import com.mayoo.Repository.FlatRepository;
import com.mayoo.Service.ResponsabiltyChain.BaseComponent;
import com.mayoo.openapi.model.Flat;

public class CreateFlatComponent extends BaseComponent<com.mayoo.openapi.model.Flat> {
    private final FlatRepository flatRepository;
    
    public CreateFlatComponent(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
    }
    @Override
    public void execute(Flat flat) throws CustomException {
        FlatEntity flatEntity = FlatMapper.flatToFlatEntiry(flat);
        flatRepository.save(flatEntity);

        if(nextHandle != null)
            nextHandle.execute(flat);
    }
}
