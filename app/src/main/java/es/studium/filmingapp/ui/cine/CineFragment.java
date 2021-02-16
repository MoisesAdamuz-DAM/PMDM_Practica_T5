package es.studium.filmingapp.ui.cine;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.studium.filmingapp.Cine;
import es.studium.filmingapp.CineAdapter;
import es.studium.filmingapp.CineDetalles;
import es.studium.filmingapp.CineImagenDetalles;
import es.studium.filmingapp.CineInterfaz;
import es.studium.filmingapp.R;

public class CineFragment extends Fragment {
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    //Array donde meteremos contenido
    public static java.util.List<Cine> items;
    private CineInterfaz cineInterfaz;
    public static int posicion;
    View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_cine, container, false);
        items = new ArrayList();
        //Poner sinopsis etc...

        items.add(new Cine(R.drawable.fantasma, "Star Wars: La Amenaza Fantasma","George Lucas","Padmé Amidala: Natalie Portman, Qui-Gon Jinn: Liam Neeson, Obi-Wan: Ewan McGregor","La trama describe la historia del maestro jedi Qui-Gon Jinn y de su aprendiz Obi-Wan Kenobi, que escoltan y protegen a la Reina Amidala desde su planeta Naboo hasta Coruscant con la esperanza de encontrar una salida pacífica a un conflicto comercial interplanetario a gran escala.", R.drawable.estrella_5 ));
        items.add(new Cine(R.drawable.hobbit, "El Hobbit: La Desolación de Smaug", "Peter Jackson","Bilbo Bolsón: Martin Freeman, Thorin: Richard Armitage, Gandalf: Ian Mckellen ","El Hobbit: la desolación de Smaug narra la continuación de la aventura de Bilbo Baggins en su periplo junto al mago Gandalf y trece Enanos liderados por Thorin Escudo de Roble, en una épica búsqueda para recuperar la Montaña Solitaria y el Reino Enano de Erebor.", R.drawable.estrella_5));
        items.add(new Cine(R.drawable.retorno, "El Señor de los Anillos: El Retorno del Rey", "Peter Jackson","Gandalf: Ian Mckellen, Aragorn: Viggo Mortensen, Frodo Bolsón: Elijah Wood ","Hombres, elfos y enanos unen sus fuerzas para presentar batalla a Sauron y sus huestes. Ajenos a estos preparativos, Frodo y Sam siguen adentrándose en el país de Mordor en su heroico viaje para destruir el Anillo de Poder en las Grietas del Destino.", R.drawable.estrella_5));
        items.add(new Cine(R.drawable.sargento, "El Sargento de Hierro", "Clint Eastwood","Tom Highway: Clint Eastwood, Aggie: Marsha Mason, Stitch: Mario Van Peebles","El sargento Tom Higway, del arma de Artillería, que ha hecho toda su carrera militar en los \"marines\", pide que se le transfiera al segundo pelotón de reconocimiento de este cuerpo, donde comenzó su ilustre carrera. Es veterano de las guerras de Corea y Vietnam, en los que ganó sendas medallas.", R.drawable.estrella_4));
        items.add(new Cine(R.drawable.piratas, "Piratas del Caribe: La Maldición de la Perla Negra", "Joachim Rønning, Espen Sandberg, Rob Marshall, Gore Verbinski","Jack Sparrow: Johnny Deep, Will Turner: Orlando Bloom, Geoffrey Rush: Héctor Barbosa","Esta saga de películas se basa libremente en mitos y leyendas de los mares, como el pirata Davy Jones y su tripulación fantasmal a bordo de El holandés errante; la mitología griega que incluye dioses como Poseidón, monstruos como el Kraken, sirenas, brujería y la vida de los piratas de la época.", R.drawable.estrella_4));
        items.add(new Cine(R.drawable.vengadores, "Los Vengadores: Infinity War", "Jose Russo, Anthony Russo","Iron Man: Robert Downey Jr., Spider-Man: Tom Holland, Capitán América: Chris Evans","Los Vengadores y sus superhéroes aliados deberán estar dispuestos a sacrificarlo todo para derrotar al poderoso Thanos.", R.drawable.estrella_5));

        //Obtenemos el recycler
        recycler = (RecyclerView) rootView.findViewById(R.id.cineRecyclerView);
        recycler.setHasFixedSize(true);

        //Usar un adinistrador para LinearLayout
        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);

        //Crear un nuevo adaptador

        adapter = new CineAdapter(items, cineInterfaz);
        recycler.setAdapter(adapter);
        setupRecyclerView();
        return rootView;

    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = recycler.findViewById(R.id.cineRecyclerView);
        recyclerView.setAdapter(new CineAdapter(items,new CineInterfaz()
        {
            @Override
            public void onClick(View v, int position ) {
                //Obtenemso la posición del elemento pulsado
                String titulo = "" + items.get(position).getNombre();
                String imagen = "" + items.get(position).getImagen();


               switch(v.getId())
                {
                    case R.id.imagenCine:

                        //Utilizamos la pulsación obtenida
                        posicion = position;
                        Intent imagenesDetalles = new Intent(rootView.getContext(), CineImagenDetalles.class);
                        imagenesDetalles.putExtra("imgPeliculaDetalle", items.get(position).getImagen());
                        startActivity(imagenesDetalles);
                        break;

                    case R.id.nombreCine:
                        //  Toast.makeText(rootView.getContext(), titulo, Toast.LENGTH_SHORT).show();
                        Intent pelisDetalles = new Intent(rootView.getContext(), CineDetalles.class);
                        pelisDetalles.putExtra("imgPeliculaDetalle", items.get(position).getImagen());
                        pelisDetalles.putExtra("txtTituloPeliculaDetalle", items.get(position).getNombre());
                        pelisDetalles.putExtra("txtDirectorPelicula", items.get(position).getDirector());
                        pelisDetalles.putExtra("txtRepartoPelicula", items.get(position).getReparto());
                        pelisDetalles.putExtra("txtSinopsisPelicula", items.get(position).getSinopsi());
                        pelisDetalles.putExtra("imgEstrellaCine", items.get(position).getCalificacion());
                        startActivity(pelisDetalles);
                        break;

                }
            }

        }));

        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));

    }


}
