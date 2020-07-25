/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composicion1;
class Pagina {

    //ATRIBUTOS DE INSTANCIA
    private String contenido;
    private int numero;

    //CONSTRUCTOR DE PARAMETROS
    public Pagina(String contenido, int numero) {
        this.contenido = contenido;
        this.numero = numero;
    }

    //METODOS DE INSTANCIA
    public String getContenido() {
        return this.contenido;
    }

    public void setContenido(String nuevo_contenido) {
        this.contenido = nuevo_contenido;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int nuevo_numero) {
        this.numero = nuevo_numero;
    }


}

class Libro {

    //ATRIBUTOS
    private String titulo;
    private  long isbn;
    private String autor;
    private int anioPublicacion;

    //ATRIBUTOS REPRESENTANDO LA RELCION DE COMPOSICION
    private Pagina[] paginas;
    private int numeroPaginas;

    //CONSTRUCTOR
    public Libro(String titulo, long isbn, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;

        //RESERVAMOS UN ESPACION DE MEMORIA PARA EL OBJETO"array"
        this.paginas = new Pagina[999];
        //RESERVAMOS ESPACIO EN MEMORIA PARA LAS Paginas
        for (int i = 0; i < 999; i++) {
            this.paginas[i] = new Pagina("", 0);
        }
        this.numeroPaginas = 0;
    }

    //METODOS DE INSTACIA
    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getIsbn() {
        return this.isbn;
    }

    public void setIsbn(long nuevo_isbn) {
        this.isbn = nuevo_isbn;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String nuevo_autor) {
        this.autor = nuevo_autor;
    }

    public int getAnioPublicacion() {
        return this.anioPublicacion;
    }

    public void setAnioPublicacion(int nuevo_anioPublicacion) {
        this.anioPublicacion = nuevo_anioPublicacion;
    }

    //METODOS PARA TRABAJR CON LA CLASE COMPOSISICON
    public int getNumeroPaginas() {
        return this.numeroPaginas;
    }
    public int setNumeroPginas(){
        return this.numeroPaginas;
    }

    public void AnadirPagina(Pagina nueva_Pagina) {
        if (this.numeroPaginas < 999) {
            this.paginas[this.numeroPaginas] = nueva_Pagina;
            this.numeroPaginas++;
        }
    }

    public Pagina getPaginaNumero(int numero_Pagina) {
        for (int i = 0; i < this.numeroPaginas; i++) {
            if (this.paginas[i].getNumero() == numero_Pagina) {
                return this.paginas[i];
            }
        }
        return null;
    }


}

/**
 *
 * @author cliente
 */
public class Composicion1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                System.out.println("            UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE-LATACUNGA");
        System.out.println("Nombre: Enríquez Israel");
        System.out.println("Curso: Programación ¨B¨");
        System.out.println("NRC: 7450");
        System.out.println("Tema: ¿AGREGACIÓN/COMPOSICIÓN?");

        // DECLARACION Y DEFINICION DE OBJETOS
        Libro Controles_Instrumentos = new Libro("Arranque y apagado del motor", 1234345296, "Chevrolet", 2020);
        Pagina pagina1 = new Pagina("Asegurese de que todos los interruptores esten en a posicion descativada", 4);
        Pagina pagina2 = new Pagina("Gire el interrupro de arranque a posiscion ON verificque luces y combustible normal", 5);

        //PASAMOS AL OBJETO libro LOS OBJETOS DEL TIPO Pagina
        Controles_Instrumentos.AnadirPagina(pagina1);
        Controles_Instrumentos.AnadirPagina(pagina2);
         System.out.println(""+Controles_Instrumentos.getAutor()+
                            " "+Controles_Instrumentos.getTitulo()+
                            " "+Controles_Instrumentos.getAnioPublicacion()+
                            " "+Controles_Instrumentos.getIsbn());
        System.out.println("datos de composicion: " + pagina1.getContenido()+" "+pagina1.getNumero());
        System.out.println("datos de composicion: " + pagina2.getContenido()+" "+pagina2.getNumero());

    }
}
