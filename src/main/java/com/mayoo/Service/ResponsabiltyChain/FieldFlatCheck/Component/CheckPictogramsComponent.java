package com.mayoo.Service.ResponsabiltyChain.FieldFlatCheck.Component;

import com.mayoo.Entity.PictogramEntity;
import com.mayoo.Exceptions.CustomException;
import com.mayoo.Exceptions.FlatIdPictogramsNotFound;
import com.mayoo.Repository.PictogramRepository;
import com.mayoo.Service.ResponsabiltyChain.BaseComponent;
import com.mayoo.openapi.model.Flat;

import java.math.BigDecimal;
import java.util.List;

public class CheckPictogramsComponent extends BaseComponent<com.mayoo.openapi.model.Flat> {
    private final PictogramRepository pictogramRepository;
    
    public CheckPictogramsComponent(PictogramRepository pictogramRepository) {
        this.pictogramRepository = pictogramRepository;
    }
    @Override
    public void execute(Flat user) throws CustomException {
        List<BigDecimal> pic = user.getPictograms();
        List<PictogramEntity> pictogramEntities = pictogramRepository.findAll();
        boolean result = false;
        long id_doesnt_exist = 0;

        for (BigDecimal id: pic) {
            if(idExist(id, pictogramEntities))
                result = true;
            else {
                result = false;
                id_doesnt_exist = id.longValue();
                break;
            }
        }
        
        if(!result)
            throw new FlatIdPictogramsNotFound(id_doesnt_exist);
        
        if(nextHandle != null)
            nextHandle.execute(user);
    }
    
    private boolean idExist(BigDecimal id, List<PictogramEntity> pictogramEntities) {

        for (PictogramEntity entity: pictogramEntities) {
            long _id = entity.getId();
            if(_id == id.longValue()) {
                return true;
            }
        }
        
        return false;
    }
}
