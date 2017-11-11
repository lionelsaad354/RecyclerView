package net.lionelsaad.recyclerviewwithswipe;

/**
 * Created by saadfauzi on 10/8/2017.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import javax.microedition.khronos.opengles.GL;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.CartViewHolder> {
    private Context context;
    private List<Item> cartList;

    public class CartViewHolder extends RecyclerView.ViewHolder {
        public TextView name,description,price;
        public ImageView thumbnail;
        public RelativeLayout viewBackground, viewForeground;

        public CartViewHolder(View view){
            super(view);
            name = view.findViewById(R.id.name);
            description = view.findViewById(R.id.description);
            price = view.findViewById(R.id.price);
            thumbnail = view.findViewById(R.id.thumbnail);
            viewBackground = view.findViewById(R.id.view_background);
            viewForeground = view.findViewById(R.id.view_foreground);
        }
    }
    public CartListAdapter(Context context, List<Item> cartList){
        this.context = context;
        this.cartList = cartList;
    }
    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_list_item, parent, false);
        return new CartViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(CartViewHolder holder, final int position){
        final Item item = cartList.get(position);
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.price.setText("₹" + item.getPrice());

        Glide.with(context)
                .load(item.getThumbnail())
                .into(holder.thumbnail);
    }
    @Override
    public int getItemCount(){
        return cartList.size();
    }
    public void removeItem (int position){
        cartList.remove(position);
        notifyItemRemoved(position);
    }
    public void restoreItem(Item item, int position){
        cartList.add(position, item);
        notifyItemInserted(position);
    }
}
