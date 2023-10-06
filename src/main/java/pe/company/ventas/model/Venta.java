package pe.company.ventas.model;

import java.io.Serializable;
import java.util.Date;

public class Venta implements Serializable{

    private static final long serialVersionUID = 1L;

    private int nroVenta;
    private Date fVenta;
    private String cliente;
    private String producto;
    private double pUnit;
    private int cantidad;
    private double total=0;

    public Venta(Venta venta){
        this(venta.getNroVenta(),venta.getfVenta(),venta.getCliente(),venta.getProducto(),venta.getpUnit(),
                venta.getCantidad(),venta.getTotal());
    }

    public Venta(int nroVenta, Date fVenta, String cliente, String producto, double pUnit, int cantidad, double total) {
        this.nroVenta = nroVenta;
        this.fVenta = fVenta;
        this.cliente = cliente;
        this.producto = producto;
        this.pUnit = pUnit;
        this.cantidad = cantidad;
        this.total = total;
    }

    public int getNroVenta() {
        return nroVenta;
    }

    public void setNroVenta(int nroVenta) {
        this.nroVenta = nroVenta;
    }

    public Date getfVenta() {
        return fVenta;
    }

    public void setfVenta(Date fVenta) {
        this.fVenta = fVenta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getpUnit() {
        return pUnit;
    }

    public void setpUnit(double pUnit) {
        this.pUnit = pUnit;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = pUnit*cantidad;
    }
}
