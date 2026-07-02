
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

public class ProductoNegocio {
    private ProductoRepositorio repositorio;
    
    public ProductoNegocio (ProductoRepositorio repositorio){
    this.repositorio = repositorio;
    }
    
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
        throw new DatoInvalidoException ("Ya existe un producto con eser código.");                 
        } 
        repositorio.agregar(producto);
        
    }

}
