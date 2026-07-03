
package Negocio;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 */
import Modelo.Producto;
import Repositorio.ProductoRepositorio;
import Excepciones.*;
import java.util.List;

public class ProductoNegocio {
    private ProductoRepositorio repositorio;
    
    public ProductoNegocio (ProductoRepositorio repositorio){
    this.repositorio = repositorio;
    }
    //exportar estadisticas
    public void exportarEstadisticas(String nombreArchivo){
        try (java.io.PrintWriter writer = new java.io.PrintWriter(nombreArchivo)){
            int totalProductos = getLista().size();
            int cantidadTotal = getLista().stream().mapToInt(Producto::getCantidad).sum();
            double valorTotal= getLista().stream().mapToDouble(p->p.getCantidad()* p.getPrecio()).sum();
            
            writer.println("Total de productos:" + totalProductos);
            writer.println("Cantidad total:" + cantidadTotal);
            writer.println("Valor total:" + valorTotal);
        }catch (java.io.IOException e){
            System.err.println("Error al exportar estadísticas:"+e.getMessage());
        }
    }
            
     //obtener lista        
    public List<Producto> getLista(){
        return repositorio.listar();
    }
    
    //se agregan productos con validaciones
    public void AgregarProductos (Producto producto) throws DatoInvalidoException, ProductoDuplicadoException 
    {
        
        if (producto.getCodigo() == null || producto.getCodigo().isEmpty()){
        throw new DatoInvalidoException ("El código es obligatorio.");                 
        } 
        
        if (producto.getNombre() == null || producto.getNombre().length()<3){
        throw new DatoInvalidoException ("El nombre debe contener al menos 3 caracteres."); 
        }
        
        if (producto.getCantidad()<0){
            throw new DatoInvalidoException ("La cantidad no puede ser menor a 0."); 
        }
       
        if (producto.getPrecio()<= 0){
            throw new DatoInvalidoException ("El precio debe ser mayor a 0."); 
        } 
        
        if (producto.getCategoria() == null || producto.getCategoria().isEmpty()){
        throw new DatoInvalidoException ("La categoria es obligatoria.");                 
        } 
        
        if (repositorio.ExisteCodigo(producto.getCodigo())){
        throw new DatoInvalidoException ("Ya existe un producto con ese código.");                 
        } 
        repositorio.agregar(producto);
        
    }
    //editar producto existente
    public void EditarProducto(Producto producto) throws DatoInvalidoException{
        if (producto.getCodigo()== null || producto.getCodigo().isEmpty()){
            throw new DatoInvalidoException("Debe ingresar el codigo a editar.");
        }
        Producto existente= repositorio.BuscarPorCodigo(producto.getCodigo());
        if (existente==null){
            throw new DatoInvalidoException("No se encontro el producto.");
        }
        repositorio.editarProducto(producto);
    }
        
    

    public void EliminarProducto(String codigo) throws DatoInvalidoException{
        if (codigo== null || codigo.isEmpty()){
            throw new DatoInvalidoException("Ingrese el código a eliminar.");
        }
        Producto producto= repositorio.BuscarPorCodigo(codigo);
        if (producto== null){
            throw new DatoInvalidoException("No se encontro el producto");
    }
        repositorio.eliminar(producto);
    }
    }