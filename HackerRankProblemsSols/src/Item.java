import java.text.NumberFormat;

/**
 * @author Alex Stringham
 *@version Oct 8 2011
 */
public class Item 
{
  
  /**
   * String my_item_names Shows item names.
   */
  private final String my_item_names;
  
  /**
   * double my_price Shows item price.
   */
  private final double my_price;
 
  /**
   * int my_bulk Shows amount of bulk.
   */
  private final int my_bulk;
  
  /**
   * double my_bulk_cost Shows cost of bulk items.
   */
  private final double my_bulk_cost;
 
  /**
   * NumberFormat my_formatted_numbers Shows currency format for item.
   */
  private final NumberFormat my_formatted_numbers;
  
  /**
   * @param the_item_name assigns item name
   * @param the_item_price assigns item price
   */
  public Item(final String the_item_name, final double the_item_price) 
  {
    
    this(the_item_name, the_item_price, 0, 0.0);
   
  }

  /**
   * @param the_item_name assigns item name
   * @param the_item_price assigns item price
   * @param the_quantity_in_bulk assigns set amount for bulk quantity
   * @param the_price_in_bulk assigns bulk price
   */
  public Item(final String the_item_name, final double the_item_price, 
              final int the_quantity_in_bulk, final double the_price_in_bulk) 
  {
    my_item_names = the_item_name;
    my_price = the_item_price;
    my_bulk = the_quantity_in_bulk;
    my_bulk_cost = the_price_in_bulk;
    my_formatted_numbers = NumberFormat.getCurrencyInstance();
  }

  /**
   * @param a_quantity Shows a certain quantity of a given item.
   * @return price
   */
  public double priceFor( int a_quantity) 
  {
    
    final int quantity = a_quantity;
    double bulk_num;
    
    if (quantity >= my_bulk && my_bulk > 0)
    {
      final int bulk_quantity = quantity / my_bulk;
      final int reg_quantity = quantity % my_bulk;
      bulk_num =  bulk_quantity * my_bulk_cost +  reg_quantity * my_price;
    } 
    else
    {
      bulk_num =  quantity * my_price;
    }
    return bulk_num;
  }

  // methods overridden from java.lang.Object
/**
 * {@inheritDoc}
 */
  public String toString() 
  {
    StringBuilder stringbuilder;
    stringbuilder = new StringBuilder().append(my_item_names);
    stringbuilder.append(", ");
    stringbuilder.append(my_formatted_numbers.format(my_price));
    if (my_bulk > 0)
    {
      stringbuilder.append(" (");
      stringbuilder.append(my_bulk);
      stringbuilder.append(" for ");
      stringbuilder.append(my_formatted_numbers.format(my_bulk_cost));
      stringbuilder.append(")");
    }
    return stringbuilder.toString();
  }
  
  /**
   * {@inheritDoc}
   */
  public boolean equals(final Object the_other)
  {
    final Item check =  (Item) the_other;
    boolean temporary_checker;
    
    if (check.my_item_names != null && 
        check.my_item_names.equals(my_item_names) &&
        check.my_price == my_price && 
        check.my_bulk == my_bulk && 
        check.my_bulk_cost == my_bulk_cost)
    {
      temporary_checker = true;
    } 
    else 
    {
      temporary_checker = false;
    }
  
    return temporary_checker;
  
  }
  
  /**
   * {@inheritDoc}
   */
  public int hashCode()
  {
    
    return my_item_names.hashCode();
  }
}