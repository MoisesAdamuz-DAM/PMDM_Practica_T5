package es.studium.filmingapp;

//Esta clase la utilizaremos como fuente de datos para rellenar el listado
public class Cine {
    //Con estos objetos alimentaremos al adaptador
    private final int imagen;
    private final String nombre;
    private final String director;
    private final String reparto;
    private final String sinopsi;
    private final int calificacion;


    public Cine(int imagen, String nombre, String director, String reparto, String sinopsi, int calificacion) {
        this.imagen = imagen;
        this.nombre = nombre;
        //poner sinopsis, autor, etc....
        this.director = director;
        this.reparto = reparto;
        this.sinopsi = sinopsi;
        this.calificacion = calificacion;
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
    public int getCalificacion() { return calificacion; }


}
