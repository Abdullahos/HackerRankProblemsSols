import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 *@author Alex
 *@version Oct 8 2011
 */
public class ShoppingCart
{
  
  
  /**
   * Constant DISCOUNT.
   */
  private static final double DISCOUNT = 0.9;
  
  /**
   * boolean my_discount Sets if there is a discount or not.
   */
  private boolean my_discount;
  
  /**
   * 
   */
  private final List<ItemOrder> my_item_list = new ArrayList<ItemOrder>();
  
  /**
   *  Creates an empty shopping cart.
   */
  public ShoppingCart()
  {
    my_discount = false;
  }

  /**
   * Adds an order to the cart.
   * @param the_item_order orders the items
   */
  public final void add(final ItemOrder the_item_order)
  {
    
    for (int i = 0; i < my_item_list.size(); i++)
    {
      if (((ItemOrder) my_item_list.get(i)).getItem().equals(the_item_order.getItem()))
      {
        my_item_list.set(i, the_item_order);
        return;
      }    
    }
    my_item_list.add(the_item_order);
    
  }

  /**
   * Sets if the cart gets a discount.
   * @param the_discount sets the discount
   */
  public void setDiscount(final boolean the_discount)
  {
    my_discount = the_discount;
  }

  /**
   * Returns total cost of the cart.
   * @return total
   */
  public double getTotal()
  {
   
    double total = 0.0;
    
    for (final Iterator<ItemOrder> iterator = my_item_list.iterator(); 
        iterator.hasNext();)
    {
      final ItemOrder next_item = (ItemOrder) iterator.next();
      total = total + next_item.getPrice();
    }
    
    if (my_discount)
    {
      total = total * DISCOUNT;
    }
    
    return total;
  }
 }