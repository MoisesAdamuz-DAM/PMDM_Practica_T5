package es.studium.filmingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SeriesDetalles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_detalles);

        ImageView imgPeli = (ImageView) findViewById(R.id.imgSerieDetalle);
        TextView tituloPeli = (TextView) findViewById(R.id.txtTituloSerie);
        TextView director = (TextView) findViewById(R.id.txtDirectorSeries);
        TextView reparto = (TextView) findViewById(R.id.txtRepartoSeries);
        TextView sinopsis = (TextView) findViewById(R.id.txtSinopsisSeries);
        TextView temporada= (TextView) findViewById(R.id.txtTemporadaSeries);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        if(bundle != null){
            tituloPeli.setText(bundle.getString("txtTituloSerie"));
            imgPeli.setImageResource(bundle.getInt("imgSerieDetalle"));
            director.setText(bundle.getString("txtDirectorSeries"));
            reparto.setText(bundle.getString("txtRepartoSeries"));
            sinopsis.setText(bundle.getString("txtSinopsisSeries"));
            temporada.setText(bundle.getString("txtTemporadaSeries"));

        }

    }
}