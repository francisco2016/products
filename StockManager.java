import java.util.ArrayList;
import java.util.Arrays;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
    }
    
    /**
     * que permita encontrar productos por su nombre en vez de por su id. En caso de no encontrarse una coincidencia
     * exacta el método devuelve null --------------------------------------------------------   0065
     * ----------------------------------------------------------------------------------------------------   0065
     */
    public Product findProduct(String name){
        Product productos = null;
        for(Product producto : stock){ //1ºrecorro la colección
            if(producto.getName().equals(name)) { //2º comparo el ID de cada producto con el ID del producto pasdo por parámetro.
               productos = producto;  //3º al tener diferentes ID , lo añado a la colección stock.
            }
        }
        return productos;
    }
    
    
    /**
     * Add a product to the list. ----------------Añadir un producto a la lista.
     * @param item The item to be added.
     * 0065 3.	Modifica el método addProduct para que no permita añadir un producto que tenga un id de otro 
     *          producto ya existente.
     *          ---------------------------------------------------------------------------------------------------   0065
     */
    public void addProduct(Product item)
    {
        for(Product producto : stock){ //1ºrecorro la colección
            if(producto.getID()  != item.getID()) { //2º comparo el ID de cada producto con el ID del producto pasdo por parámetro.
                stock.add(item);   //3º al tener diferentes ID , lo añado a la colección stock.
            }
        }
    }

    
    
    /**
     * que imprima los detalles de todos los productos cuyo stock está por debajo de un determinado número que será pasado
     * como parámetro al método --------------------------------------------------------
     * ---------------------------------------------------------------------------------------------------- 0065
     */
    public void underGivenNumberInStock(int id){
           
        for(Product producto : stock){// 1ºrecorro los productos de la colección.
            if (producto.getQuantity() < id) {  // 2º si del productos hay menor cantidad de unidades que señala el parametro id.      
                System.out.println(producto);   // se imprimen en pantalla.
            }
        }
        

    } 

    /**
     * Receive a delivery of a particular product. --------- Recibir una entrega de un producto en particular.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.------------------------------------------------------------------------------ 0704
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product producto = findProduct(id);//1º buscamos el producto con el id del parámetro.(utilizando el mt findProduct(id))
        //si lo hay, lo guardo en la VL producto.
        if(producto != null){     //2º si hay producto, aplico el mt increaseQuantity(amount) de la cl Products, pasandole como
            producto.increaseQuantity(amount); //parámetro la cantidad que señala el parámetro del mt.
        }
        else{
            System.out.println("El id indicado no pertenece a ningun producto");
        }

    }

    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     * return El producto identificado, o null si no hay ninguno
     *         with a matching ID.------------------------------------------------------------------------------- 0704
     */
    public Product findProduct(int id)
    {
        Product producto = null;   //1º VL para guardar el id del producto, o devolver null, si no existe.
        int index = 0;             //3º VL necesaria para que funcione el bucle while.
        boolean encontrado = false;//3º VL para que el bucle while se pare si encuentra el id pasado como parámetro.
        while(!encontrado && index < stock.size()){//3º while porque cuando encuentra el id buscado, no itera más veces.
            if (stock.get(index).getID() == id)//4º al recorrer la colección,comprueba si coinciden el id de los productos
            {                                       //con el id pasado como parámetro.
                producto = stock.get(index);  //5º si encuentra algun id igual al id parámetro lo guarda en la VL producto.
                encontrado = true;              //5º entonces ponemos encotrado a verdadero. y el bucle no iterará más
            }
            index++;
        }
        return producto;          //2º Retornamos el valor de la VL.

    }

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.------------------------------------------------------------------------------ 0704
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        int cantidad = 0;     //1º VL para almacenar la solución, en este caso la cantidad de unidades que tienen el id dado.
        Product producto = findProduct(id); //2º buscamos el producto con el id del parámetro.(utilizando el mt findProduct(id))
        //si lo hay, lo guardo en la VL producto.
        if (producto != null) {       //3º si hay producto, aplico el mt getQuantity() de la cl Produc, el cual devuelve el nº 
            cantidad = producto.getQuantity(); // elementos que tienen ese id, y lo guardo en la VL cantidad. 
        }
        return cantidad;     //1º retorno al VL, 

    }

    /**
     * Print details of all the products.------------------------------------------------------------------------------ 0704
     */
    public void printProductDetails()
    {for(Product products: stock){
            System.out.println(products);
        }
    }
}

