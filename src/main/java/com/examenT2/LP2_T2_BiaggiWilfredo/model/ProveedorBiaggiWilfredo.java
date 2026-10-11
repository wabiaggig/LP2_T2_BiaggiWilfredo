package com.examenT2.LP2_T2_BiaggiWilfredo.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;


@Entity
@Table(name = "tbl_proveedor")
@Getter @Setter
public class ProveedorBiaggiWilfredo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer idProveedor;
    
    private String ruc;
    
    @Column(name = "razon_social")
    private String razonSocial;
    
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
    
    private String direccion;
    
    @Column(name = "pagina_web")
    private String paginaWeb;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rubro")
    private RubroBiaggiWilfredo rubro;
}
