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
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.------------------------------------------------------------------------------ 0064
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
      Product producto = findProduct(id);
      if(producto != null){
         producto.increaseQuantity(amount);
      }
      else{
        System.out.println("El id indicado no pertenece a ningun producto");
      }
    }
   
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     * return El producto identificado, o null si no hay ninguno
     *         with a matching ID.------------------------------------------------------------------------------- 0064
     */
    public Product findProduct(int id)
    {
      Product producto = null;
      int index = 0;
      boolean encontrado = false;
      while(!encontrado && index < stock.size()){
        if (stock.get(index).getID() == id)
        {
        	producto = stock.get(index);
          encontrado = true;
        }
        index++;
      }
      return producto;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.------------------------------------------------------------------------------ 0064
     * @return The quantity of the given product in stock.
     */
     public int numberInStock(int id)
    {
			int cantidad = 0;
      Product producto = findProduct(id); 
      if (producto != null) {
      	 cantidad = producto.getQuantity();
      }
      return cantidad;
    }

     /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {for(Product products: stock){
       System.out.println(products.toString());//------------------------------------------------------0064
    }
    }
}
 
