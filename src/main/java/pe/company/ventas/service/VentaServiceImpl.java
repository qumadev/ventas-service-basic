package pe.company.ventas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.company.ventas.model.Venta;
import pe.company.ventas.repository.VentaRepository;

import java.util.Collection;

@Service
public class VentaServiceImpl implements VentaService{

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public void insert(Venta venta){
        ventaRepository.insert(venta);
    }

    @Override
    public void update(Venta venta){
        ventaRepository.update(venta);
    }

    @Override
    public void delete(int nroVenta){
        ventaRepository.delete(nroVenta);
    }

    @Override
    public Venta findById(int nroVenta){
        return ventaRepository.findById(nroVenta);
    }

    @Override
    public Collection<Venta> findAll(){
        return ventaRepository.findAll();
    }
}
