package es.studium.filmingapp;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//Clase AnimeViewHolder || Clase PaletteViewHolder
//implementamos OnClickListener
/*Con esta clase gestioanmos el layout*/
class SeriesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    //Creamos los atributos
    public ImageView imagen;//cine_card
    public TextView nombre;//cine_card
    //Añadimos RecyclerViewOnItemClickListener
    private final SeriesInterfaz listener;

    //AnimeViewHolder || public PaletteViewHolder
    public SeriesViewHolder(@NonNull View itemView, SeriesInterfaz listener) {
        super(itemView);

        imagen = (ImageView)  itemView.findViewById(R.id.imagenSerie);
        nombre = (TextView) itemView.findViewById(R.id.nombreSerie);
        nombre.setOnClickListener(this);
        imagen.setOnClickListener(this);

        this.listener = listener;
    }

    public void bindRow(Series series)
    {
        imagen.setImageResource(series.getImagen());
        nombre.setText(series.getNombre());
    }

    @Override
    public void onClick(View v) {

        listener.onClick(v, getAdapterPosition());

    }
}