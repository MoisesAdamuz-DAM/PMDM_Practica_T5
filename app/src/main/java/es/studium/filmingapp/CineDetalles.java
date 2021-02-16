package es.studium.filmingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CineDetalles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cine_detalles);

        ImageView imgPeli = (ImageView) findViewById(R.id.imgPeliculaDetalle);
        TextView tituloPeli = (TextView) findViewById(R.id.txtTituloSerie);
        TextView director = (TextView) findViewById(R.id.txtDirectorPelicula);
        TextView reparto = (TextView) findViewById(R.id.txtRepartoPelicula);
        TextView sinopsis = (TextView) findViewById(R.id.txtSinopsisPelicula);
        ImageView puntuacion= (ImageView) findViewById(R.id.imgEstrellaCine);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        if(bundle != null){
            tituloPeli.setText(bundle.getString("txtTituloPeliculaDetalle"));
            imgPeli.setImageResource(bundle.getInt("imgPeliculaDetalle"));
            director.setText(bundle.getString("txtDirectorPelicula"));
            reparto.setText(bundle.getString("txtRepartoPelicula"));
            sinopsis.setText(bundle.getString("txtSinopsisPelicula"));
            puntuacion.setImageResource(bundle.getInt("imgEstrellaCine"));

        }

    }
}