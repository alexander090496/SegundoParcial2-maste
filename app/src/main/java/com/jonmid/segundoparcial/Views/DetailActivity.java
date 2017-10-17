package com.jonmid.segundoparcial.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonmid.segundoparcial.Array.Images;
import com.jonmid.segundoparcial.R;
import com.jonmid.segundoparcial.TeamActivity;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    ImageView imagendetail;
    TextView textViewdetname, textViewdetcode;
    Button butonreg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tv1= (TextView) findViewById(R.id.id_tv_namedetail);
        TextView tv2= (TextView) findViewById(R.id.id_tv_codedetail);

        tv1.setText(getIntent().getExtras().getString("name"));
        tv2.setText(getIntent().getExtras().getString("code"));
        imagendetail = (ImageView) findViewById(R.id.id_img_item_detail);

        Picasso.with(this).load(Images.imageRandom()).into(imagendetail);

    }

    public  void  regresar(View view){
        Intent intent= new Intent(this, TeamActivity.class);
        startActivity(intent);
    }


}
