class TipoEnemigo {
    private String nombre;
    private String textura;
    private String sonido;

    public TipoEnemigo(String nombre, String textura, String sonido) {
        this.nombre = nombre;
        this.textura = textura;
        this.sonido = sonido;
    }

    public void mostrar(int x, int y) {
        System.out.println("Mostrando " + nombre + " en la posición (" + x + ", " + y + ") con textura " + textura + " y sonido " + sonido);
    }
}

class FabricaEnemigos {
    private static java.util.Map<String, TipoEnemigo> tipos = new java.util.HashMap<>();

    public static TipoEnemigo obtenerTipo(String nombre, String textura, String sonido) {
        if (!tipos.containsKey(nombre)) {
            System.out.println("Creando nuevo tipo de enemigo: " + nombre);
            tipos.put(nombre, new TipoEnemigo(nombre, textura, sonido));
        }
        return tipos.get(nombre);
    }
}

class Enemigo {
    private TipoEnemigo tipo;
    private int x, y;

    public Enemigo(TipoEnemigo tipo, int x, int y) {
        this.tipo = tipo;
        this.x = x;
        this.y = y;
    }

    public void dibujar() {
        tipo.mostrar(x, y);
    }
}

public class flyweight {
    public static void main(String[] args) {
        TipoEnemigo tipoGuts = FabricaEnemigos.obtenerTipo("Guts", "guts.png", "guts.mp3");
        TipoEnemigo tipoGriffith = FabricaEnemigos.obtenerTipo("Griffith", "griffith.png", "griffith.mp3");
        TipoEnemigo tipoZodd = FabricaEnemigos.obtenerTipo("Zodd", "zodd.png", "zodd.mp3");

        Enemigo[] enemigos = {
            new Enemigo(tipoGuts, 10, 20),
            new Enemigo(tipoGriffith, 30, 40),
            new Enemigo(tipoZodd, 50, 60),
            new Enemigo(tipoGuts, 70, 80),
            new Enemigo(tipoGriffith, 90, 100),
            new Enemigo(tipoZodd, 110, 120)
        };

        for (Enemigo enemigo : enemigos) {
            enemigo.dibujar();
        }
    }
}
