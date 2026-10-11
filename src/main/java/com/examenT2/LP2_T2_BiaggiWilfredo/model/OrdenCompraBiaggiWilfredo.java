package com.examenT2.LP2_T2_BiaggiWilfredo.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_orden_compra")
@Getter @Setter
public class OrdenCompraBiaggiWilfredo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_orden")
    private Integer nroOrden;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private ProveedorBiaggiWilfredo proveedor;

    private BigDecimal monto;

    @Column(name = "direccion_entrega")
    private String direccionEntrega;

    @Column(name = "fecha_entrega")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaEntrega;

    @Column(name = "estado", insertable = false)
    private String estado = "P";

    public String getEstadoDescripcion() {
        if ("C".equals(estado)) return "Completado";
        if ("A".equals(estado)) return "Anulado";
        return "Pendiente";
    }
}
