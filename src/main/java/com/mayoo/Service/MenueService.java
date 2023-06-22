package com.mayoo.Service;

import com.mayoo.DTO.MenueMapper;
import com.mayoo.Entity.MenueEntity;
import com.mayoo.Repository.MenueRepository;
import com.mayoo.openapi.model.Menue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenueService implements IMenueService{
    private final MenueRepository menueRepository;
    
    public MenueService(MenueRepository menueRepository) {
        this.menueRepository = menueRepository;
    }
    @Override
    public List<Menue> getAllMenue() {
        List<MenueEntity> menues = menueRepository.findAll();
        List<Menue> m = new ArrayList<>();
        
        menues.forEach(c -> {
            m.add(MenueMapper.MenueEntityToMenue(c));
        });
        return m;
    }
}
