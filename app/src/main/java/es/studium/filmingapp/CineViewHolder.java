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
class CineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    //Creamos los atributos
    public ImageView imagen;//cine_card
    public TextView nombre;//cine_card
    //Añadimos RecyclerViewOnItemClickListener
    private final CineInterfaz listener;

    //AnimeViewHolder || public PaletteViewHolder
    public CineViewHolder(@NonNull View itemView, CineInterfaz listener) {
        super(itemView);

        imagen = (ImageView)  itemView.findViewById(R.id.imagenCine);
        nombre = (TextView) itemView.findViewById(R.id.nombreCine);
        nombre.setOnClickListener(this);
        imagen.setOnClickListener(this);

        this.listener = listener;
    }

    public void bindRow(Cine cine)
    {
        imagen.setImageResource(cine.getImagen());
        nombre.setText(cine.getNombre());
    }

    @Override
    public void onClick(View v) {

        listener.onClick(v, getAdapterPosition());

    }
}
