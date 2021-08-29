package com.example.wosha;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.andanhm.quantitypicker.QuantityPicker;

import org.json.JSONArray;

import java.util.ArrayList;

import static com.andanhm.quantitypicker.QuantityPicker.*;

public class createOrder extends AppCompatActivity {
    QuantityPicker mPicker;
    private ListView listView;
    private ListAdapter listAdapter;
    ArrayList<Item> items = new ArrayList<>();
    Button orderBtn;
    ArrayList<Item> itemOrders = new ArrayList<>();
    ArrayList<String> lOrderItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_order);
        mPicker = findViewById(R.id.picker1);
        getItem();
        listView = findViewById(R.id.customListView);
        listAdapter = new ListAdapter(this,items);
        listView.setAdapter(listAdapter);
        orderBtn = findViewById(R.id.btnPlaceOrder);
        orderBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                placeOrder();
            }
        });
    }

    private void placeOrder(){
        itemOrders.clear();
        lOrderItems.clear();
        for(int i=0; i<listAdapter.listItems.size();i++)
        {
            if(listAdapter.listItems.get(i).CartQuantity>0)
            {
                Item items = new Item(
                        listAdapter.listItems.get(i).ItemName
                        ,listAdapter.listItems.get(i).ItemPrice
                        ,listAdapter.listItems.get(i).ItemImage
                );
                items.CartQuantity = listAdapter.listItems.get(i).CartQuantity;
                itemOrders.add(items);
                lOrderItems.add(items.getJsonObject().toString());
            }
        }
        JSONArray jsonArray = new JSONArray(lOrderItems);
        showMessage("Order Item Count : " +itemOrders.size());
        openSummary(jsonArray.toString());
    }
    
    public void showMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
    public void openSummary(String orderItems)
    {
        Intent intent = new Intent(this, Summary.class);
        intent.putExtra("orderItems", orderItems);
        startActivity(intent);
    }

    public void getItem(){
        items.add(new Item("Hoodies",50.0,R.drawable.hoodie));
        items.add(new Item("Suits",200.0,R.drawable.suit));
        items.add(new Item("Shorts",30.0,R.drawable.shorts));
        items.add(new Item("Sweaters",50.0,R.drawable.sweater));
        items.add(new Item("Shirts",30.0,R.drawable.shirt));
        items.add(new Item("Linens",150.0,R.drawable.linens));
        items.add(new Item("Dresses", 70.0,R.drawable.dress));
        items.add(new Item("Pants",60.0,R.drawable.pants));
        items.add(new Item("Shoes", 65.0,R.drawable.shoe));
        items.add(new Item("Underwear",40.0,R.drawable.underwear));
    }
}
