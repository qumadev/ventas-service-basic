package pe.company.ventas.service;

import pe.company.ventas.model.Venta;

import java.util.Collection;

public interface VentaService {
    public abstract void insert(Venta venta);
    public abstract void update(Venta venta);
    public abstract void delete(int nroVenta);
    public abstract Venta findById(int nroVenta);
    public abstract Collection<Venta> findAll();
}
