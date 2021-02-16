package es.studium.filmingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import es.studium.filmingapp.ui.cine.CineFragment;

public class CineImagenDetalles extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cine_imagen_detalles);

        ImageView imagen = findViewById(R.id.imagenPelicula);

        imagen.setImageResource(CineFragment.items.get(CineFragment.posicion).getImagen());
        imagen.setOnClickListener(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

    }

    @Override
    public void onClick(View v) {
        finish();
    }
}