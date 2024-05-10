package in.bitcode.a10_4_24_recyclerviewversion2;

import android.content.Intent;
import android.os.AsyncTask;
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

            //way 3 --> attaching listener to imageView in ProductViewHolder constructor
            imgProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Product product1 = products.get(getAdapterPosition());
                    Intent intent = new Intent(view.getContext(),ProductDetailsActivity.class);
                    intent.putExtra("product",product1);
                    view.getContext().startActivity(intent);
                }
            });
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
//        imgProduct.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(view.getContext(), "image is clicked", Toast.LENGTH_LONG).show();
//
//            }
//        });

//        txtTitle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(view.getContext(), "txtTitle is clicked", Toast.LENGTH_LONG).show();
//            }
//        });

//        txtPrice.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(view.getContext(), "txtPrice is clicked", Toast.LENGTH_LONG).show();
//            }
//        });

        return new ProductViewHolder(productView);
    }

    //way 2 --> attaching listener in onBindViewHolder method because we get position as an argument
    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

           Product product1 = products.get(position);
           txtTitle = holder.itemView.findViewById(R.id.txtTitle);
           txtTitle.setText(product1.getTxtTitle());
//           txtTitle.setOnClickListener(new View.OnClickListener() {
//               @Override
//               public void onClick(View view) {
//                   Intent intent = new Intent(view.getContext(),ProductDetailsActivity.class);
//                   intent.putExtra("id",product1.getId());
//                   intent.putExtra("title",product1.getTxtTitle());
//                   intent.putExtra("image", product1.getImageId());
//                   intent.putExtra("price",product1.getPrice());
//                   view.getContext().startActivity(intent);
//                   Toast.makeText(view.getContext(), "Title " + product1.getTxtTitle(), Toast.LENGTH_LONG).show();
//               }
//           });

           txtPrice = holder.itemView.findViewById(R.id.txtPrice);
           txtPrice.setText(product1.getPrice() + "");

//           txtPrice.setOnClickListener(new View.OnClickListener() {
//               @Override
//               public void onClick(View view) {
//                    Toast.makeText(view.getContext() ,"Price " +product1.getPrice(),Toast.LENGTH_LONG).show();
//               }
//           });

           imgProduct = holder.itemView.findViewById(R.id.imgProduct);
           imgProduct.setImageResource(R.drawable.ic_launcher_background);
//           imgProduct.setOnClickListener(new View.OnClickListener() {
//               @Override
//               public void onClick(View view) {
//                    Toast.makeText(view.getContext(), "Image " + product1.getImageId(), Toast.LENGTH_LONG).show();
//               }
//           });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
