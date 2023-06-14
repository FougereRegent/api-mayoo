package com.mayoo.Service.ResponsabiltyChain.FieldFlatCheck;

import com.mayoo.Repository.FlatRepository;
import com.mayoo.Repository.PictogramRepository;
import com.mayoo.Service.ResponsabiltyChain.FieldFlatCheck.Component.CheckExistComponent;
import com.mayoo.Service.ResponsabiltyChain.FieldFlatCheck.Component.CheckNameComponent;
import com.mayoo.Service.ResponsabiltyChain.FieldFlatCheck.Component.CheckPictogramsComponent;
import com.mayoo.Service.ResponsabiltyChain.FieldFlatCheck.Component.CreateFlatComponent;
import com.mayoo.Service.ResponsabiltyChain.IComponentCheck;

public class CheckCreatingFlatBuilder {
    public static IComponentCheck<com.mayoo.openapi.model.Flat> builder(FlatRepository flatRepository, PictogramRepository pictogramRepository) {
        IComponentCheck<com.mayoo.openapi.model.Flat> checkNameComponent =  new CheckNameComponent();
        IComponentCheck<com.mayoo.openapi.model.Flat> checkExistComponent = new CheckExistComponent(flatRepository);
        IComponentCheck<com.mayoo.openapi.model.Flat> checkPictogramComponent = new CheckPictogramsComponent(pictogramRepository);
        IComponentCheck<com.mayoo.openapi.model.Flat> createFlatComponenent = new CreateFlatComponent(flatRepository);
        checkNameComponent.setNext(checkExistComponent);
        checkExistComponent.setNext(checkPictogramComponent);
        checkPictogramComponent.setNext(createFlatComponenent);
        
        return checkNameComponent;
    }
}
