package com.mayoo.Entity;

import com.mayoo.Entity.Enum.Right;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.security.PrivateKey;

@Setter
@Getter
@Entity
@Table(name = "UserRight")
public class RightEnity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private Right droit;
    
    @OneToOne
    private UserEntity user;
}
