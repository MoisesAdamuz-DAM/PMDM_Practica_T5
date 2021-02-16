package es.studium.filmingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesViewHolder> {
    private List<Series> items;
    //Añadimos RecyclerViewOnItemClickListener
    public final SeriesInterfaz seriesInterfaz;

    //public MaterialPaletteAdapter
    //Guardar la referencia en la estructura de datos, con los datos a mostrar
    public SeriesAdapter(List<Series> items, SeriesInterfaz seriesInterfaz) {
        this.items = items;
        this.seriesInterfaz = seriesInterfaz;
    }

    @NonNull
    @Override
    //AnimeViewHolder || PaletteViewHolder
    //Inflamos el layout de la fila
    // viewType = getItemViewType
    public SeriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.series_card, parent, false);
        return new SeriesViewHolder(row, seriesInterfaz);
    }

    //Establece los datos correspondientes al elemento de la posición position
    @Override
    public void onBindViewHolder(@NonNull SeriesViewHolder viewHolder, int position) {
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

