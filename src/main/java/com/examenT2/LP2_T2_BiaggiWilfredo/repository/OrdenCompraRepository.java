package com.examenT2.LP2_T2_BiaggiWilfredo.repository;
import com.examenT2.LP2_T2_BiaggiWilfredo.model.OrdenCompraBiaggiWilfredo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;



public interface OrdenCompraRepository extends JpaRepository<OrdenCompraBiaggiWilfredo, Integer> {
	List<OrdenCompraBiaggiWilfredo> findAllByOrderByNroOrdenDesc();
}
