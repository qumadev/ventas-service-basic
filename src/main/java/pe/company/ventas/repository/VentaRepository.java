package pe.company.ventas.repository;

import pe.company.ventas.model.Venta;

import java.util.Collection;

public interface VentaRepository {

    public abstract void insert(Venta venta);
    public abstract void update(Venta venta);
    public abstract void delete(int nroVenta);
    public abstract Venta findById(int nroVenta);
    public abstract Collection<Venta> findAll();
}
