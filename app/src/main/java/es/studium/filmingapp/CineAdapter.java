package es.studium.filmingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//Clase AnimeAdapter || Clase MaterialPaletteAdapter
public class CineAdapter extends RecyclerView.Adapter<CineViewHolder> {
    private List<Cine> items;
    //Añadimos RecyclerViewOnItemClickListener
    public final CineInterfaz cineInterfaz;

    //public MaterialPaletteAdapter
    //Guardar la referencia en la estructura de datos, con los datos a mostrar
    public CineAdapter(List<Cine> items, CineInterfaz cineInterfaz)
    {
        this.items = items;
        this.cineInterfaz = cineInterfaz;
    }

    @NonNull
    @Override
    //AnimeViewHolder || PaletteViewHolder
    //Inflamos el layout de la fila
    // viewType = getItemViewType
    public CineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.cine_card, parent, false);
        return new CineViewHolder(row, cineInterfaz);
    }

    //Establece los datos correspondientes al elemento de la posición position
    @Override
    public void onBindViewHolder(@NonNull CineViewHolder viewHolder, int position) {
        // viewHolder.imagen.setImageResource(items.get(position).getImage());
        //viewHolder.nombre.setText(items.get(position).getNombre());
        viewHolder.bindRow(items.get(position));

    }

    //Devuelve en número total de fillas que tiene el adapter
    @Override
    public int getItemCount() {
        return items.size();
    }


}
