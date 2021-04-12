/*
 * TCSS 305 Autumn 2011 Assignment 1 - Shopping Cart
 * Author: Daniel M. Zimmerman (Formatting and Comments) and Marty Stepp
 */

import java.util.Arrays;

/**
 * ShoppingMain provides the main method for a simple shopping cart GUI
 * displayer and calculator.
 * 
 * @author Marty Stepp
 * @author Daniel M. Zimmerman (Formatting and Comments)
 * @version 1.3 (Autumn 2011)
 */

public final class ShoppingMain
{
  /**
   * The list of items to be displayed in the shopping cart.
   */
  private static final Item[] ITEMS =
    new Item[] {new Item("Silly Putty", 3.95, 10, 19.99),
                new Item("Silly String", 3.50, 10, 14.95),
                new Item("Bottle o' Bubbles", 0.99),
                new Item("Pinwheel", 1.49),
                new Item("Sony PlayStation", 99.99),
                new Item("Computer Science pen", 1.20),
                new Item("Rubik's Cube", 9.10),
                new Item("Computer Science Barbie", 9.99),
                new Item("'Java Rules!' button", 0.99, 10, 5.0),
                new Item("'Java Rules!' bumper sticker", 0.99, 20, 8.95)};

  /**
   * A private constructor, to prevent instances from being constructed.
   */
  private ShoppingMain()
  {
  }

  /**
   * The main() method - displays and runs the shopping cart GUI.
   * 
   * @param the_args Command line arguments, ignored by this program.
   */
  public static void main(final String... the_args)
  {
    new ShoppingFrame(Arrays.asList(ITEMS));
  }
}