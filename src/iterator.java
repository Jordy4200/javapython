// Clase Personaje
class Personaje {
    private String nombre;
    private String habilidad;

    public Personaje(String nombre, String habilidad) {
        this.nombre = nombre;
        this.habilidad = habilidad;
    }

    @Override
    public String toString() {
        return nombre + " - Habilidad: " + habilidad;
    }
}

// Clase PersonajeIterator
class PersonajeIterator implements java.util.Iterator<Personaje> {
    private java.util.List<Personaje> personajes;
    private int index = 0;

    public PersonajeIterator(java.util.List<Personaje> personajes) {
        this.personajes = personajes;
    }

    @Override
    public boolean hasNext() {
        return index < personajes.size();
    }

    @Override
    public Personaje next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        return personajes.get(index++);
    }
}

// Clase EquipoAnime
class EquipoAnime implements java.lang.Iterable<Personaje> {
    private java.util.List<Personaje> personajes = new java.util.ArrayList<>();

    public void agregarPersonaje(Personaje personaje) {
        personajes.add(personaje);
    }

    @Override
    public java.util.Iterator<Personaje> iterator() {
        return new PersonajeIterator(personajes);
    }
}

// Pruebas
public class iterator {
    public static void main(String[] args) {
        // Creación del equipo de anime
        EquipoAnime equipo = new EquipoAnime();
        equipo.agregarPersonaje(new Personaje("Naruto Uzumaki", "Rasengan"));
        equipo.agregarPersonaje(new Personaje("Goku", "Kamehameha"));
        equipo.agregarPersonaje(new Personaje("Luffy", "Gomu Gomu no Pistol"));
        equipo.agregarPersonaje(new Personaje("Saitama", "Puño serio"));

        // Iterar sobre los personajes del equipo
        for (Personaje personaje : equipo) {
            System.out.println(personaje);
        }
    }
}
