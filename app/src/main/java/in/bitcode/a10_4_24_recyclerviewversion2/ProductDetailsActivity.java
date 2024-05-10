package in.bitcode.a10_4_24_recyclerviewversion2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class ProductDetailsActivity extends Activity {
    ImageView imgProduct;
    TextView txtTitle;
    TextView txtPrice;
    int id, price, imageId;
    String title;
    Product product;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_view);
        initViews();
        extractData();
    }

    private void initViews(){
        imgProduct = findViewById(R.id.imgProduct);
        txtTitle = findViewById(R.id.txtTitle);
        txtPrice = findViewById(R.id.txtPrice);
    }

    private void extractData(){
        //way 3 --> extracting data from intent on the basis of product key
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        product = (Product) bundle.get("product");
        id = product.getId();
        title = product.getTxtTitle();
        price = product.getPrice();
        imageId = product.getImageId();

        txtPrice.setText(" " + price);
        txtTitle.setText(title);

          //way 1--> extracting data separately on the basis of separate keys from intent
//        Intent intent = getIntent();
//        id = intent.getIntExtra("id",10);
//        title = intent.getStringExtra("title");
//        price = intent.getIntExtra("price",100);
//        imageId = intent.getIntExtra("image",100);
//
//        txtTitle.setText(title);
//        txtPrice.setText(price + "");
          //imgProduct.setImageResource(imageId);

//        Bundle bundle = intent.getExtras();
//        bundle.getInt("id");
//        bundle.getString("title","amrut");
//        bundle.getInt("price");
    }
}