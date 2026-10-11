package com.examenT2.LP2_T2_BiaggiWilfredo.service;
import com.examenT2.LP2_T2_BiaggiWilfredo.model.OrdenCompraBiaggiWilfredo;
import com.examenT2.LP2_T2_BiaggiWilfredo.repository.OrdenCompraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdenCompraService {
    private final OrdenCompraRepository repository;

    public List<OrdenCompraBiaggiWilfredo> listarTodos() {
        return repository.findAllByOrderByNroOrdenDesc();
    }
    public OrdenCompraBiaggiWilfredo buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }
    public OrdenCompraBiaggiWilfredo guardar(OrdenCompraBiaggiWilfredo orden) {
        return repository.save(orden);
    }
}
