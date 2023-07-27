package com.mayoo.Repository;

import com.mayoo.Entity.PictogramEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PictogramRepository extends JpaRepository<PictogramEntity, Long> {
    Optional<PictogramEntity> findByName(String name);
    Optional<PictogramEntity> findById(long id);
}
