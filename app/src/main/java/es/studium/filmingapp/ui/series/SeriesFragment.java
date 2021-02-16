package es.studium.filmingapp.ui.series;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.studium.filmingapp.Series;
import es.studium.filmingapp.R;
import es.studium.filmingapp.SeriesAdapter;
import es.studium.filmingapp.SeriesDetalles;
import es.studium.filmingapp.SeriesImagenesDetalles;
import es.studium.filmingapp.SeriesInterfaz;

public class SeriesFragment extends Fragment {
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    public static java.util.List<Series> items;
    private SeriesInterfaz seriesInterfaz;
    public static int posicion;
    View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_series, container, false);
        items = new ArrayList();
        //Poner sinopsis etc...

        items.add(new Series(R.drawable.bigban, "The Big Bang Theory","Mark Cendrowski","Penny: Kaley Cuoco, Leonard Hofstadter: Johnny Galecki, Sheldon Cooper: Jim Parsons","The Big Bang Theory trata de dos cerebritos que comparten piso, Leonard (Johnny Galecki) y Sheldon (Jim Parsons). ... Penny, que habita las antípodas vitales e intelectuales de ambos cerebritos, altera la tranquila vida sentimental de Leonard y resulta un continuo detonador para el desorden obsesivo-compulsivo de Sheldon.", "12" ));
        items.add(new Series(R.drawable.wanda, "La Bruja Escarlata y Visión", "Matt Shakman","Wanda: Elizabeth Olsen, Pietro: Evan Peters, Visión: Paul Bettany ","Bruja Escarlata y Visión combina el estilo de las clásicas 'sitcom' con el UCM en el que Wanda Maximoff y Visión -dos seres con superpoderes que viven sus idílicas vidas suburbanas- comienzan a sospechar que todo no es como parece. Tenemos, por lo tanto, una mezcla de estilos de lo más interesante.", "1"));
        items.add(new Series(R.drawable.mandalorian, "El Mandaloriano", "Jon Favreau","Mandaloriano: Pedro Pascal, Greef Karga: Carl Weathers, Moff Gideon: Giancarlo Esposito","The Mandalorian es una serie de Disney + ambientada en el universo de Star Wars que se desarrolla tras la caída del Imperio y antes de la aparición de la Primera Orden, la serie sigue los pasos de Mando, un cazarecompensas perteneciente a la legendaria tribu de los Mandalorian, un pistolero solitario que trabaja en los confines de la galaxia, donde no alcanza","2"));
        items.add(new Series(R.drawable.vikingos, "Vikingos", "Michael Hirst","Ladgerda: Katheryn Winnick, Björn: Alexander Ludwig, Ragnar: Travis Fimmel","Narra las aventuras del héroe Ragnar Lothbrok, de sus hermanos vikingos y su familia, cuando él se subleva para convertirse en el rey de las tribus vikingas. Además de ser un guerrero valiente, Ragnar encarna las tradiciones nórdicas de la devoción a los dioses.", "Temporadas:6"));
        items.add(new Series(R.drawable.witcher, "The Witcher", "Alex García López","Geralt de Rivia: Henry Cavill, Yennefer: Anya Chalo, Ciri: Freya Allan","Geralt de Rivia es un brujo, mutado durante su infancia para ser más efectivo en su labor, matar monstruos por dinero. ... Debido al destino, Geralt y Ciri están unidos para siempre desde antes del nacimiento de esta. Durante sus viajes Geralt conoce a Jaskier, un trovador demasiado hablador, y a Yennefer, una hechicera.","2"));
        items.add(new Series(R.drawable.breaking, "Breaking Bad", "Vince Gilligan","Walter White: Bryan Cranston, Jesse Pinkman: Aaron Paul","Walter White (Bryan Cranston) es un frustrado profesor de química en un instituto, padre de un joven discapacitado y con una mujer (Anna Gunn) embarazada. Además, trabaja en un lavadero de vehículos por las tardes. Cuando le diagnostican un cáncer pulmonar terminal se plantea qué pasará con su familia cuando él muera.","4"));

        //Obtenemos el recycler
        recycler = (RecyclerView) rootView.findViewById(R.id.seriesRecyclerView);
        recycler.setHasFixedSize(true);

        //Usar un adinistrador para LinearLayout
        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);

        //Crear un nuevo adaptador

        adapter = new SeriesAdapter(items, seriesInterfaz);
        recycler.setAdapter(adapter);
        setupRecyclerView();
        return rootView;

    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = recycler.findViewById(R.id.seriesRecyclerView);
        recyclerView.setAdapter(new SeriesAdapter(items,new SeriesInterfaz()
        {
            @Override
            public void onClick(View v, int position ) {
                String titulo = "" + items.get(position).getNombre();
                String imagen = "" + items.get(position).getImagen();


                switch(v.getId())
                {
                    case R.id.imagenSerie:

                        posicion = position;
                        Intent imagenesDetalles = new Intent(rootView.getContext(), SeriesImagenesDetalles.class);
                        imagenesDetalles.putExtra("imgSerieDetalle", items.get(position).getImagen());
                        startActivity(imagenesDetalles);
                        break;

                    case R.id.nombreSerie:
                        //  Toast.makeText(rootView.getContext(), titulo, Toast.LENGTH_SHORT).show();
                        Intent serieDetalles = new Intent(rootView.getContext(), SeriesDetalles.class);
                        serieDetalles.putExtra("imgSerieDetalle", items.get(position).getImagen());
                        serieDetalles.putExtra("txtTituloSerie", items.get(position).getNombre());
                        serieDetalles.putExtra("txtDirectorSeries", items.get(position).getDirector());
                        serieDetalles.putExtra("txtRepartoSeries", items.get(position).getReparto());
                        serieDetalles.putExtra("txtSinopsisSeries", items.get(position).getSinopsi());
                        serieDetalles.putExtra("txtTemporadaSeries", items.get(position).getTemporada());
                        startActivity(serieDetalles);
                        break;

                }
            }

        }));

        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));

    }


}

