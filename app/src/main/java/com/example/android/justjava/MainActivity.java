/*IMPORTANT: Add your package below.
Package name can be found in the project's AndroidManifest.xml file.
This is the package name our example uses:
package com.example.android.justjava;*/

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.android.justjava.R;

import java.text.NumberFormat;

/*This app displays an order form to order coffee.*/
public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*This method is called when the order button is clicked.*/
    public void submitOrder(View view) {
        EditText nameField = (EditText) findViewByID(R.id.name_field);
        String name = text.getText().toString();

        // Figure out if the user wants whipped cream topping
        CheckBox whippedCreamCheckBox = (Checkbox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        // Figure out if the user wants chocolate topping
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice();
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);
    }

    /*Calculates the price of the order.
    @param addWhippedCream is whether or not the user wants whipped cream topping
    @param addChocolate is whether or not the user wants chocolate topping
    @return total price*/
    private int calculatePrice(boolean add) {
        return quantity * 5;
    }

    /*Create summary of the order.
    @param price of the order
    @param addWhippedCream is whether or not the user wants whipped cream topping
    @param addChocolate is whether or not the user wants chocolate topping
    @return text summary*/
    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /*This method is called when the + button is clicked.*/
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    /*This method is called when the - button is clicked.*/
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }

    /*This method displays the given quantity value on the screen.*/
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /*This method displays the given text on the screen.*/
    private void displayMessage(String message) {
        View orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}