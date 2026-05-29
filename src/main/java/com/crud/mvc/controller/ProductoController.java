package com.crud.mvc.controller;

import com.crud.mvc.model.Producto;
import com.crud.mvc.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/")
    public String home() {
        return "redirect:/productos";
    }

    @GetMapping("/productos")
    public String listarProductos(Model model) {
        List<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);
        return "productos/lista";
    }

    @GetMapping("/productos/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("accion", "Crear");
        return "productos/formulario";
    }

    @PostMapping("/productos/guardar")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoRepository.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()) {
            model.addAttribute("producto", productoOptional.get());
            model.addAttribute("accion", "Editar");
            return "productos/formulario";
        }
        return "redirect:/productos";
    }

    @PostMapping("/productos/actualizar/{id}")
    public String actualizarProducto(@PathVariable Integer id, @ModelAttribute Producto producto) {
        producto.setId(id);
        productoRepository.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/ver/{id}")
    public String verProducto(@PathVariable Integer id, Model model) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()) {
            model.addAttribute("producto", productoOptional.get());
            return "productos/detalle";
        }
        return "redirect:/productos";
    }

    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable Integer id) {
        productoRepository.deleteById(id);
        return "redirect:/productos";
    }
}