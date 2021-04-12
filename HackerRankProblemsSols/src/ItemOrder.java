/**
 * @author Alex
 *@version Oct 8 2011
 */
public class ItemOrder
{
  
  /**
   *  
   */
  private final Item my_item;
  /**
   *  
   */
  private final int my_quantity;
  
  /**
   * @param the_item_name sets my_item to equal the_item_name
   * @param the_quantity_of_items set my_quantity to equal the_quantityof_items
   */
  public ItemOrder(final Item the_item_name, final int the_quantity_of_items)
  {
    my_item = the_item_name;
    my_quantity = the_quantity_of_items;
  }

  /**
   * @return my_item.(priceFor(my_quantity
   */
  public double getPrice()
  {
    
    return (my_item).priceFor(my_quantity);
  }

  /**
   * @return my_item
   */
  public Item getItem()
  {
    
    return my_item;
  }
}