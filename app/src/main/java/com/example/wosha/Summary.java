package com.example.wosha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Summary extends AppCompatActivity {

    ListView mSummary;
    TextView mTotal;
    Double Total = 0d;
    ArrayList<Item> itemOrders = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        mSummary = findViewById(R.id.lvSummary);
        mTotal = findViewById(R.id.tvTotal);
        getOrderItemData();

    }

    private void getOrderItemData(){
        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            String orderItems = extras.getString("orderItems", null);
            if(orderItems!=null && orderItems.length()>0)
            {
                try{
                    JSONArray jsonOrderItems = new JSONArray(orderItems);
                    for(int i=0;i<jsonOrderItems.length();i++)
                    {
                        JSONObject jsonObject = new JSONObject(jsonOrderItems.getString(i));
                        Item item = new Item(
                                jsonObject.getString("ItemName")
                                ,jsonObject.getDouble("ItemPrice")
                                ,jsonObject.getInt("ItemImage")
                        );
                        item.CartQuantity = jsonObject.getInt("CartQuantity");
                        //Calculate total
                        Total = Total + (item.CartQuantity * item.ItemPrice);
                        itemOrders.add(item);
                    }

                    if(itemOrders.size()>0)
                    {
                        ListAdapter listAdapter = new ListAdapter(this,itemOrders);
                        mSummary.setAdapter(listAdapter);
                        mTotal.setText("Order Total: " + Total);
                    }
                    else
                    {
                        showMessage("Empty");
                    }
                }
                catch (Exception e)
                {
                    showMessage(e.toString());
                }
            }
        }
    }
    public void showMessage(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void pushServ(View view){
        startActivity(new Intent(getApplicationContext(), Seeker.class));
        finish();
    }
}