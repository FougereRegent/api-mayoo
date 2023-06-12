package com.mayoo.Service.ResponsabiltyChain.FieldFlatCheck.Component;

import com.mayoo.Exceptions.CustomException;
import com.mayoo.Repository.FlatRepository;
import com.mayoo.Repository.PictogramRepository;
import com.mayoo.Service.ResponsabiltyChain.BaseComponent;
import com.mayoo.openapi.model.Flat;

public class CreateFlatComponent extends BaseComponent<com.mayoo.openapi.model.Flat> {
    private final FlatRepository flatRepository;
    private final PictogramRepository pictogramRepository;
    
    public CreateFlatComponent(FlatRepository flatRepository, PictogramRepository pictogramRepository) {
        this.flatRepository = flatRepository;
        this.pictogramRepository = pictogramRepository;
    }
    @Override
    public void execute(Flat user) throws CustomException {
        
        
        if(nextHandle != null)
            nextHandle.execute(user);
    }
}
