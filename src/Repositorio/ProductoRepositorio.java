
package Repositorio;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 */

import Modelo.Producto;
import java.util.*;

public class ProductoRepositorio {
    private List<Producto>productos;
    private Set<String> codigos;
    
    public ProductoRepositorio (){
    productos = new ArrayList <> ();
    codigos = new HashSet <> ();
    }
    public void agregar (Producto producto){
    productos.add (producto);
    codigos.add(producto.getCodigo());
    }
    public List<Producto> listar(){
    return productos;
    }
    public Producto BuscarPorCodigo (String codigo){
    for (Producto p: productos){
    if (p.getCodigo(). equalsIgnoreCase(codigo)){
        return p;
    }
    }
    return null;
    }
    public void eliminar (Producto producto){
    productos.remove (productos);
    codigos.remove (producto.getCodigo());
    }
    public boolean ExisteCodigo (String codigo){
        return codigos.contains (codigo);
    }
    
}
