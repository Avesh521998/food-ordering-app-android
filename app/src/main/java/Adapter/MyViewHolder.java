package Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.foodordering1.R;

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView cart_item_name,Cart_item_price;
    ImageView cart_item_image,mDeleteImage;

    public MyViewHolder(View itemView){
        super(itemView);
        cart_item_image = (ImageView)itemView.findViewById(R.id.pizzaone);
        cart_item_name = (TextView) itemView.findViewById(R.id.txtpizzaname);
        Cart_item_price = (TextView) itemView.findViewById(R.id.txtpizzaprice1);
    }
}
