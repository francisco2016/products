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
     * exacta el m�todo devuelve null --------------------------------------------------------   0065
     * ----------------------------------------------------------------------------------------------------   0065
     */
    public Product findProduct(String name){
        Product productos = null;
        for(Product producto : stock){ //1�recorro la colecci�n
            if(producto.getName().equals(name)) { //2� comparo el ID de cada producto con el ID del producto pasdo por par�metro.
               productos = producto;  //3� al tener diferentes ID , lo a�ado a la colecci�n stock.
            }
        }
        return productos;
    }
    
    
    /**
     * Add a product to the list. ----------------A�adir un producto a la lista.
     * @param item The item to be added.
     * 0065 3.	Modifica el m�todo addProduct para que no permita a�adir un producto que tenga un id de otro 
     *          producto ya existente.
     *          ---------------------------------------------------------------------------------------------------   0065
     */
    public void addProduct(Product item)
    {
        for(Product producto : stock){ //1�recorro la colecci�n
            if(producto.getID()  != item.getID()) { //2� comparo el ID de cada producto con el ID del producto pasdo por par�metro.
                stock.add(item);   //3� al tener diferentes ID , lo a�ado a la colecci�n stock.
            }
        }
    }

    
    
    /**
     * que imprima los detalles de todos los productos cuyo stock est� por debajo de un determinado n�mero que ser� pasado
     * como par�metro al m�todo --------------------------------------------------------
     * ---------------------------------------------------------------------------------------------------- 0065
     */
    public void underGivenNumberInStock(int id){
           
        for(Product producto : stock){// 1�recorro los productos de la colecci�n.
            if (producto.getQuantity() < id) {  // 2� si del productos hay menor cantidad de unidades que se�ala el parametro id.      
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
        Product producto = findProduct(id);//1� buscamos el producto con el id del par�metro.(utilizando el mt findProduct(id))
        //si lo hay, lo guardo en la VL producto.
        if(producto != null){     //2� si hay producto, aplico el mt increaseQuantity(amount) de la cl Products, pasandole como
            producto.increaseQuantity(amount); //par�metro la cantidad que se�ala el par�metro del mt.
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
        Product producto = null;   //1� VL para guardar el id del producto, o devolver null, si no existe.
        int index = 0;             //3� VL necesaria para que funcione el bucle while.
        boolean encontrado = false;//3� VL para que el bucle while se pare si encuentra el id pasado como par�metro.
        while(!encontrado && index < stock.size()){//3� while porque cuando encuentra el id buscado, no itera m�s veces.
            if (stock.get(index).getID() == id)//4� al recorrer la colecci�n,comprueba si coinciden el id de los productos
            {                                       //con el id pasado como par�metro.
                producto = stock.get(index);  //5� si encuentra algun id igual al id par�metro lo guarda en la VL producto.
                encontrado = true;              //5� entonces ponemos encotrado a verdadero. y el bucle no iterar� m�s
            }
            index++;
        }
        return producto;          //2� Retornamos el valor de la VL.

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
        int cantidad = 0;     //1� VL para almacenar la soluci�n, en este caso la cantidad de unidades que tienen el id dado.
        Product producto = findProduct(id); //2� buscamos el producto con el id del par�metro.(utilizando el mt findProduct(id))
        //si lo hay, lo guardo en la VL producto.
        if (producto != null) {       //3� si hay producto, aplico el mt getQuantity() de la cl Produc, el cual devuelve el n� 
            cantidad = producto.getQuantity(); // elementos que tienen ese id, y lo guardo en la VL cantidad. 
        }
        return cantidad;     //1� retorno al VL, 

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

