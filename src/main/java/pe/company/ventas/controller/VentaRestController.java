package pe.company.ventas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.company.ventas.model.Venta;
import pe.company.ventas.service.VentaService;

import java.util.Collection;

@RestController
@RequestMapping("/venta")
public class VentaRestController {

    @Autowired
    private VentaService ventaService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        Collection<Venta> itemsVenta = ventaService.findAll();
        return new ResponseEntity<>(itemsVenta, HttpStatus.OK);
    }

    @GetMapping("/buscar/{nroVenta}")
    public ResponseEntity<?> buscar(@PathVariable int nroVenta){
        Venta venta = ventaService.findById(nroVenta);
        if(venta!=null){
            return new ResponseEntity<>(venta,HttpStatus.OK );
        }
        return  new ResponseEntity<>("Venta no encontrada",HttpStatus.NOT_FOUND);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Venta venta){
        ventaService.insert(venta);
        return  new ResponseEntity<>("Venta creada",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{nroVenta}")
    public ResponseEntity<?> editar(@PathVariable int nroVenta, @RequestBody Venta ventaModified){
        Venta venta = ventaService.findById(nroVenta);
        if(venta!=null){
            venta.setfVenta(ventaModified.getfVenta()==null ? venta.getfVenta() : ventaModified.getfVenta());
            venta.setCliente(ventaModified.getCliente()==null ? venta.getCliente() : ventaModified.getCliente());
            venta.setProducto(ventaModified.getProducto()==null ? venta.getProducto() : ventaModified.getProducto());
            venta.setpUnit(ventaModified.getpUnit()==0.0 ? venta.getpUnit():ventaModified.getpUnit());
            venta.setCantidad(ventaModified.getCantidad()== 0 ? venta.getCantidad():ventaModified.getCantidad());
            venta.setTotal(venta.getpUnit()*venta.getCantidad());
            ventaService.update(venta);
            return new ResponseEntity<>("Venta actualizada",HttpStatus.OK);
        }
        return new ResponseEntity<>("Venta no existente",HttpStatus.NOT_FOUND);
    }
}
