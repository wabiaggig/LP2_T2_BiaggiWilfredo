package com.examenT2.LP2_T2_BiaggiWilfredo.controller;

import com.examenT2.LP2_T2_BiaggiWilfredo.model.OrdenCompraBiaggiWilfredo;
import com.examenT2.LP2_T2_BiaggiWilfredo.service.OrdenCompraService;
import com.examenT2.LP2_T2_BiaggiWilfredo.service.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ordenes")
@RequiredArgsConstructor
public class OrdenCompraController {

    private final OrdenCompraService ordenCompraService;
    private final ProveedorService proveedorService;

    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("lstOrdenes", ordenCompraService.listarTodos());
        return "listadoBiaggiWilfredo"; 
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("orden", new OrdenCompraBiaggiWilfredo());
        model.addAttribute("lstProveedores", proveedorService.listarTodos());
        return "nuevoBiaggiWilfredo"; 
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute OrdenCompraBiaggiWilfredo orden, RedirectAttributes flash) {
        OrdenCompraBiaggiWilfredo registrada = ordenCompraService.guardar(orden);
        flash.addFlashAttribute("alert", "<script>Swal.fire('Éxito', 'Orden de compra Nro. " + registrada.getNroOrden() + " registrada.', 'success');</script>");
        return "redirect:/ordenes/listado";
    }

    @GetMapping("/edicion/{id}")
    public String edicion(@PathVariable Integer id, Model model) {
        model.addAttribute("orden", ordenCompraService.buscarPorId(id));
        model.addAttribute("lstProveedores", proveedorService.listarTodos());
        return "edicionBiaggiWilfredo"; 
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute OrdenCompraBiaggiWilfredo orden, RedirectAttributes flash) {
        OrdenCompraBiaggiWilfredo actualizada = ordenCompraService.guardar(orden);
        flash.addFlashAttribute("alert", "<script>Swal.fire('Éxito', 'Orden de compra Nro. " + actualizada.getNroOrden() + " actualizada.', 'success');</script>");
        return "redirect:/ordenes/listado";
    }
}