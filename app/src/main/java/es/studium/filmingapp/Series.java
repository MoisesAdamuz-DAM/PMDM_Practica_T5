package es.studium.filmingapp;

//Esta clase la utilizaremos como fuente de datos para rellenar el listado
public class Series {
    //Con estos objetos alimentaremos al adaptador
    private final int imagen;
    private final String nombre;
    private final String director;
    private final String reparto;
    private final String sinopsi;
    private final String temporada;


    public Series(int imagen, String nombre, String director, String reparto, String sinopsi, String temporada) {
        this.imagen = imagen;
        this.nombre = nombre;
        //poner sinopsis, autor, etc....
        this.director = director;
        this.reparto = reparto;
        this.sinopsi = sinopsi;
        this.temporada = temporada;
    }

    public String getNombre()
    {
        return nombre;
    }
    public int getImagen()
    {
        return imagen;
    }
    public String getDirector()
    {
        return director;
    }
    public String getReparto()
    {
        return reparto;
    }
    public String getSinopsi() { return sinopsi; }
    public String getTemporada() { return temporada; }


}
