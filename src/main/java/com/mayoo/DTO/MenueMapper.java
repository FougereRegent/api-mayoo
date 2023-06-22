package com.mayoo.DTO;

import com.mayoo.Entity.MenueEntity;
import com.mayoo.openapi.model.Menue;

import java.util.ArrayList;
import java.util.List;

public class MenueMapper {
    public static com.mayoo.openapi.model.Menue MenueEntityToMenue(MenueEntity menue) {
        com.mayoo.openapi.model.Menue m = new Menue();
        List<com.mayoo.openapi.model.Flat> flats = new ArrayList<>();
        menue.getFlats()
                        .forEach(FlatMapper::flatEntityToFlat);
        m.date(menue.getDate().toString());
        m.setFlats(flats);
        return m; 
    }
    
    public static MenueEntity MenueToMenuEntity(com.mayoo.openapi.model.Menue menue) {
        return null; 
    }
}
