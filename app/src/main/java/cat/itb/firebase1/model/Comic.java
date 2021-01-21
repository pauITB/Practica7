package cat.itb.firebase1.model;

public class Comic {
    private String idComic;
    private String nombre;
    private String editorial;
    private float nota;

    public Comic() {
    }

    public Comic(String nombre, String editorial, float nota) {
        this.nombre = nombre;
        this.editorial = editorial;
        this.nota = nota;
    }

    public Comic(String idComic, String nombre, String editorial, float nota) {
        this.idComic = idComic;
        this.nombre = nombre;
        this.editorial = editorial;
        this.nota = nota;
    }
//      GETTERS and SETTERS

    public String getIdComic() {
        return idComic;
    }

    public void setIdComic(String idComic) {
        this.idComic = idComic;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
}
