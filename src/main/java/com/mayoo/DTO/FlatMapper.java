package com.mayoo.DTO;

import com.mayoo.Entity.FlatEntity;
import com.mayoo.Entity.PictogramEntity;
import com.mayoo.openapi.model.Flat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FlatMapper {
    public static com.mayoo.openapi.model.Flat flatEntityToFlat(FlatEntity flatEntity) {
        com.mayoo.openapi.model.Flat flat = new Flat();
        List<BigDecimal> listPictograms = new ArrayList<>();
        flat.name(flatEntity.getName());
        flat.description(flatEntity.getDescription());
        flat.pictograms(listPictograms);
        
        for(PictogramEntity pictogramEntity : flatEntity.getPictogramEntities()) {
            listPictograms.add(BigDecimal.valueOf(pictogramEntity.getId()));
        }
        
        switch (flatEntity.getFlatType()) {
            case FLAT -> flat.flatType(Flat.FlatTypeEnum.FLAT);
            case STARTER -> flat.flatType(Flat.FlatTypeEnum.STARTER);
            case DESSERT -> flat.flatType(Flat.FlatTypeEnum.DESSERT);
        }
        
        return flat;
    }
    
    public static FlatEntity flatToFlatEntiry(Flat flat) {
        
        return null;
    }
}
