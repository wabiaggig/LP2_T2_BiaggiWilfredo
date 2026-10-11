package com.examenT2.LP2_T2_BiaggiWilfredo.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tbl_rubro")
@Getter @Setter
public class RubroBiaggiWilfredo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rubro")
    private Integer idRubro;
    
    private String denominacion;
}
