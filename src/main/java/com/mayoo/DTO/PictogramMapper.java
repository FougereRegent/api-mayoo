package com.mayoo.DTO;

import com.mayoo.Entity.PictogramEntity;
import com.mayoo.openapi.model.Pictograms;

public class PictogramMapper {
    public static com.mayoo.openapi.model.Pictograms PictogramEntityToPictogram(PictogramEntity pictogramEntity) {
        com.mayoo.openapi.model.Pictograms pictogram = new Pictograms();
        pictogram.name(pictogramEntity.getName());
        pictogram.description(pictogram.getDescription());
        switch (pictogramEntity.getEnumDangerType()) {
            case NORMAL -> pictogram.typepictogram(Pictograms.TypepictogramEnum.NORMAL);
            case WARNING -> pictogram.typepictogram(Pictograms.TypepictogramEnum.WARNING);
            case DANGER -> pictogram.typepictogram(Pictograms.TypepictogramEnum.DANGER);
            default -> pictogram.typepictogram(Pictograms.TypepictogramEnum.NORMAL);
        }
               
        return pictogram;         
    }
}
