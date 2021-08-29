package com.example.wosha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.andanhm.quantitypicker.QuantityPicker;

import java.util.ArrayList;

import static com.andanhm.quantitypicker.QuantityPicker.BOLD;

public class ListAdapter extends BaseAdapter {

    public ArrayList<Item> listItems;
    private Context context;

    public ListAdapter(Context context, ArrayList<Item> listItems){
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        final ListViewHolder listViewHolder;
        if(convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.custom_listview,parent,false);
            listViewHolder = new ListViewHolder();
            listViewHolder.tvName = row.findViewById(R.id.tvName);
            listViewHolder.ivItem = row.findViewById(R.id.item);
            listViewHolder.tvPrice = row.findViewById(R.id.tvPrice);
            listViewHolder.mPicker = row.findViewById(R.id.picker1);
            row.setTag(listViewHolder);
        }
        else
        {
            row = convertView;
            listViewHolder = (ListViewHolder) row.getTag();
        }
        final Item items = (Item) getItem(position);

        listViewHolder.tvName.setText(items.ItemName);
        listViewHolder.ivItem.setImageResource(items.ItemImage);
        listViewHolder.tvPrice.setText(items.ItemPrice+ "Ksh");
        listViewHolder.mPicker.getQuantity();

        listViewHolder.mPicker.setOnQuantityChangeListener(new QuantityPicker.OnQuantityChangeListener() {
            @Override
            public void onValueChanged(int quantity) {
                Item items = (Item) getItem(position);
                if(quantity > 0)
                {
                    items.CartQuantity = items.CartQuantity + 1;
                }
                else
                {
                    if(items.CartQuantity > 0)
                    {
                        items.CartQuantity = items.CartQuantity - 1;
                    }
                }
            }
        });
        return row;
    }
}
