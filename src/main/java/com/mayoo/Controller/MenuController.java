package com.mayoo.Controller;

import com.mayoo.Service.IMenueService;
import com.mayoo.openapi.model.Menue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController implements com.mayoo.openapi.api.MenueApi {
    private final IMenueService menueService; 
    
    public MenuController(IMenueService menueService) {
        this.menueService = menueService;
    }
    @Override
    public ResponseEntity<List<Menue>> menueGet() {
        return new ResponseEntity<List<Menue>>(menueService.getAllMenue(), HttpStatus.OK);
    }
}
