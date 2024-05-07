package in.bitcode.a10_4_24_recyclerviewversion2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {
    Product product;
    ArrayList<Product> products;
    TextView txtTitle;
    TextView txtPrice;
    ImageView imgProduct;

    public ProductsAdapter(ArrayList<Product> products) {
        this.products = products;
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtPrice = itemView.findViewById(R.id.txtPrice);
        }
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View productView = layoutInflater.inflate(R.layout.product_view,null);
        imgProduct = productView.findViewById(R.id.imgProduct);
        txtTitle = productView.findViewById(R.id.txtTitle);
        txtPrice =  productView.findViewById(R.id.txtPrice);

        //way 1 --> attach listener in onCreateViewHolder
        //by passing an object of anonymous class
        imgProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "image is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "txtTitle is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        txtPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "txtPrice is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return new ProductViewHolder(productView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
           Product product1 = products.get(position);
           txtTitle = holder.itemView.findViewById(R.id.txtTitle);
           txtTitle.setText(product1.getTxtTitle());

           txtPrice = holder.itemView.findViewById(R.id.txtPrice);
           txtPrice.setText(product1.getPrice() + "");
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
