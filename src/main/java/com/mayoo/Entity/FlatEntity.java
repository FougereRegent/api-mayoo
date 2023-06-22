package com.mayoo.Entity;

import com.mayoo.Entity.Enum.EnumFlatType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "flat")
public class FlatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private EnumFlatType flatType;
    @ManyToMany
    private List<PictogramEntity> pictogramEntities;
}
