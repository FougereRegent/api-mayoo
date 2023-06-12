package com.mayoo.Service.ResponsabiltyChain.FieldFlatCheck.Component;

import com.mayoo.Entity.FlatEntity;
import com.mayoo.Exceptions.CustomException;
import com.mayoo.Repository.FlatRepository;
import com.mayoo.Service.ResponsabiltyChain.BaseComponent;
import com.mayoo.openapi.model.Flat;

import java.util.Optional;

public class CheckExistComponent extends BaseComponent<Flat> {
    private final FlatRepository flatRepository;
    
    public CheckExistComponent(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
    }
    
    @Override
    public void execute(Flat user) throws CustomException {
        final String name = user.getName();

        Optional<FlatEntity> flatEntity = flatRepository.findByName(name);
        
        if(flatEntity.isPresent())
                
        if(nextHandle != null)
            nextHandle.execute(user);
    }
}
