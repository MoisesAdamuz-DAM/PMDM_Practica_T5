package es.studium.filmingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import es.studium.filmingapp.ui.cine.CineFragment;
import es.studium.filmingapp.ui.series.SeriesFragment;

public class SeriesImagenesDetalles extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_imagenes_detalles);

        ImageView imagen = findViewById(R.id.imagenSerie);

        imagen.setImageResource(SeriesFragment.items.get(SeriesFragment.posicion).getImagen());
        imagen.setOnClickListener(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

    }

    @Override
    public void onClick(View v) {
        finish();
    }
}