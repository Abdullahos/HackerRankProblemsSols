/*
 * TCSS 305 Autumn 2011 Assignment 1 - Shopping Cart
 * Author: Daniel M. Zimmerman (Formatting and Comments) and Marty Stepp
 */

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * ShoppingFrame provides the user interface for a shopping cart program.
 * 
 * @author Marty Stepp
 * @author Daniel M. Zimmerman (Formatting and Comments)
 * @version 1.3 (Autumn 2011)
 */
public final class ShoppingFrame extends JFrame
{
  /** 
   * The Serialization ID.
   */
  private static final long serialVersionUID = 0;

  /**
   * The width of the text field in the GUI.
   */
  private static final int TEXT_FIELD_WIDTH = 12;

  /**
   * The background color for items in the GUI.
   */
  private static final Color BG_COLOR = new Color(0, 180, 0);

  /**
   * The shopping cart used by this GUI.
   */
  private final ShoppingCart my_items;

  /**
   * The text field used to display the total amount owed by the customer.
   */
  private final JTextField my_total;

  /**
   * Creates a new ShoppingGUI to sell the specified list of items.
   * 
   * @param the_items The list of items.
   */
  public ShoppingFrame(final List<Item> the_items)
  {
    // create frame and order list
    super("Holiday Gifts");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    my_items = new ShoppingCart();

    // set up text field with order total
    my_total = new JTextField("$0.00", TEXT_FIELD_WIDTH);
    add(makeTotalPanel(), "North");
    add(makeItemsPanel(the_items), "Center");
    add(makeCheckBoxPanel(), "South");

    // adjust size to just fit
    pack();
    setVisible(true);
  }

  /**
   * Creates a panel to hold the total.
   * 
   * @return The created panel.
   */
  private JPanel makeTotalPanel()
  {
    // tweak the text field so that users can't edit it, and set
    // its color appropriately

    my_total.setEditable(false);
    my_total.setEnabled(false);
    my_total.setDisabledTextColor(Color.black);

    // create the panel, and its label

    final JPanel p = new JPanel();
    p.setBackground(Color.blue);
    final JLabel l = new JLabel("order total");
    l.setForeground(Color.yellow);
    p.add(l);
    p.add(my_total);
    return p;
  }

  /**
   * Creates a panel to hold the specified list of items.
   * 
   * @param the_items The items.
   * @return The created panel.
   */
  private JPanel makeItemsPanel(final List<Item> the_items)
  {
    final JPanel p = new JPanel(new GridLayout(the_items.size(), 1));

    for (Item item : the_items)
    {
      addItem(item, p);
    }

    return p;
  }

  /**
   * Creates and returns the checkbox panel for our window.
   * 
   * @return the checkbox panel for our window.
   */
  private JPanel makeCheckBoxPanel()
  {
    final JPanel p = new JPanel();
    p.setBackground(Color.blue);
    final JCheckBox cb = new JCheckBox("qualify for discount");
    p.add(cb);
    cb.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent the_event)
      {
        my_items.setDiscount(cb.isSelected());
        updateTotal();
      }
    });
    return p;
  }

  /**
   * Adds the specified product to the specified panel.
   * 
   * @param the_item The product to add.
   * @param the_panel The panel to add the product to.
   */
  private void addItem(final Item the_item, final JPanel the_panel)
  {
    final JPanel sub = new JPanel(new FlowLayout(FlowLayout.LEFT));
    sub.setBackground(BG_COLOR);
    final JTextField quantity = new JTextField(3);
    quantity.setHorizontalAlignment(SwingConstants.CENTER);
    quantity.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent the_event)
      {
        updateItem(the_item, quantity);
        quantity.transferFocus();
      }
    });
    quantity.addFocusListener(new FocusAdapter()
    {
      public void focusLost(final FocusEvent the_event)
      {
        updateItem(the_item, quantity);
      }
    });
    sub.add(quantity);
    final JLabel l = new JLabel(the_item.toString());
    l.setForeground(Color.WHITE);
    sub.add(l);
    the_panel.add(sub);
  }

  /**
   * Updates the set of items by changing the quantity of the specified product
   * to the specified quantity.
   * 
   * @param the_item The product to update.
   * @param the_quantity The new quantity.
   */
  private void updateItem(final Item the_item, final JTextField the_quantity)
  {
    final String text = the_quantity.getText().trim();
    int number;
    try
    {
      number = Integer.parseInt(text);
      if (number < 0)
      {
        // disallow negative numbers
        throw new NumberFormatException();
      }
    }
    catch (final NumberFormatException e)
    {
      number = 0;
      the_quantity.setText("");
    }
    my_items.add(new ItemOrder(the_item, number));
    updateTotal();
  }

  /**
   * Updates the total displayed in the window.
   */
  private void updateTotal()
  {
    final double total = my_items.getTotal();
    my_total.setText(NumberFormat.getCurrencyInstance().format(total));
  }
}

// end of class ShoppingGUI