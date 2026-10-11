package com.examenT2.LP2_T2_BiaggiWilfredo.service;
import com.examenT2.LP2_T2_BiaggiWilfredo.repository.ProveedorRepository;
import com.examenT2.LP2_T2_BiaggiWilfredo.model.ProveedorBiaggiWilfredo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedorService {
    private final ProveedorRepository proveedorRepository;

    public List<ProveedorBiaggiWilfredo> listarTodos() {
        return proveedorRepository.findAll();
    }
}