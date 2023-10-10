package pe.company.ventas.repository;

import org.springframework.stereotype.Repository;
import pe.company.ventas.model.Venta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Repository
public class VentaRepositoryImpl implements VentaRepository{
    public static Collection<Venta> itemsVenta = new ArrayList<>();

    @Override
    public void insert(Venta venta){
        venta.setTotal();
        itemsVenta.add(venta);
    }

    @Override
    public void update(Venta venta){
        Venta oldVenta = findById(venta.getNroVenta());
        itemsVenta.remove(oldVenta);

        Venta newVenta = new Venta(venta);
        itemsVenta.add(newVenta);
    }

    @Override
    public void delete(int nroVenta){
        Venta venta = findById(nroVenta);
        itemsVenta.remove(venta);
    }

    @Override
    public Venta findById(int nroVenta){
        Optional<Venta> venta = itemsVenta.stream()
                .filter(v -> v.getNroVenta() == nroVenta)
                .findFirst();

        return venta.orElse(null);
    }

    @Override
    public Collection<Venta> findAll(){
        return itemsVenta;
    }
}
