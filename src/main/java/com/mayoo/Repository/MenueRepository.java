package com.mayoo.Repository;

import com.mayoo.Entity.MenueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenueRepository extends JpaRepository<MenueEntity, Long> {
    List<MenueEntity> findAll();
}
