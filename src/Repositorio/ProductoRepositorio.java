
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
    //agregar producto
    public void agregar (Producto producto){
    productos.add (producto);
    codigos.add(producto.getCodigo());
    }
    //se listan todos los productos
    public List<Producto> listar(){
    return productos;
    }
    //buscar producto por codigo
    public Producto BuscarPorCodigo (String codigo){
    for (Producto p: productos){
    if (p.getCodigo(). equalsIgnoreCase(codigo)){
        return p;
    }
    }
    return null;
    }
    //eliminar producto
    public void eliminar (Producto producto){
    productos.remove (producto);
    codigos.remove (producto.getCodigo());
    }
    //eliminar por codigo
    public void eliminarPorCodigo (String codigo){
    Producto p= BuscarPorCodigo(codigo);
    if (p !=null){
        productos.remove(p);
        codigos.remove(codigo);
    }
    }
    //verificar si existe ya un codigo
    public boolean ExisteCodigo (String codigo){
        return codigos.contains (codigo);
    }
    public void editarProducto(Producto producto){
        for (int i=0; i<productos.size();i++){
            if (productos.get(i).getCodigo().equalsIgnoreCase(producto.getCodigo())){
                productos.set(i,producto);
                return;
            }
        }throw new RuntimeException("No se encontró el producto con ese código:"+ producto.getCodigo());
    }
    
    //ordenar productos por nombre
   public void ordenarPorNombre(){
    productos.sort(Comparator.comparing(Producto::getNombre));
}
    //ordenar por codigo
    public void ordenarPorCodigo(){
    productos.sort(Comparator.comparing(Producto::getCodigo));
}     

}

