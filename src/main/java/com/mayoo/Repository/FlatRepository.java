package com.mayoo.Repository;

import com.mayoo.Entity.Enum.EnumFlatType;
import com.mayoo.Entity.FlatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FlatRepository extends JpaRepository<FlatEntity, Long> {
    Optional<FlatEntity> findByName(String name);
    List<FlatEntity> findFlatEntitiesByFlatType(EnumFlatType flatType);
}
