// Clase abstracta para dispositivos gamer
abstract class Dispositivo {
    abstract void encender();
    abstract void apagar();
    abstract void setVolume(int volumen);
    abstract int getVolume();
}

// Dispositivo: PC Gamer
class PCGamer extends Dispositivo {
    private boolean encendido = false;
    private int volumen = 0;

    @Override
    void encender() {
        encendido = true;
        System.out.println("PC Gamer encendida... ¡Listo para jugar!");
    }

    @Override
    void apagar() {
        encendido = false;
        System.out.println("PC Gamer apagada... ¡Hasta la próxima partida!");
    }

    @Override
    void setVolume(int volumen) {
        this.volumen = volumen;
        System.out.println("Volumen de los altavoces del PC: " + volumen);
    }

    @Override
    int getVolume() {
        return volumen;
    }
}

// Dispositivo: Consola (PlayStation 5)
class Consola extends Dispositivo {
    private boolean encendido = false;
    private int volumen = 0;

    @Override
    void encender() {
        encendido = true;
        System.out.println("Consola encendida... ¡Hora de jugar!");
    }

    @Override
    void apagar() {
        encendido = false;
        System.out.println("Consola apagada... Guardando partida.");
    }

    @Override
    void setVolume(int volumen) {
        this.volumen = volumen;
        System.out.println("Volumen de la consola: " + volumen);
    }

    @Override
    int getVolume() {
        return volumen;
    }
}

// Dispositivo: Auriculares Gamer
class AuricularesGamer extends Dispositivo {
    private boolean encendido = false;
    private int volumen = 0;

    @Override
    void encender() {
        encendido = true;
        System.out.println("Auriculares gamer encendidos... ¡Sonido envolvente activado!");
    }

    @Override
    void apagar() {
        encendido = false;
        System.out.println("Auriculares gamer apagados... Silencio.");
    }

    @Override
    void setVolume(int volumen) {
        this.volumen = volumen;
        System.out.println("Volumen de los auriculares: " + volumen);
    }

    @Override
    int getVolume() {
        return volumen;
    }
}

// Control Remoto Básico
class ControlRemoto {
    protected Dispositivo dispositivo;

    public ControlRemoto(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    void encender() {
        dispositivo.encender();
    }

    void apagar() {
        dispositivo.apagar();
    }
}

// Control Remoto Avanzado (con control de volumen)
class ControlRemotoAvanzado extends ControlRemoto {

    public ControlRemotoAvanzado(Dispositivo dispositivo) {
        super(dispositivo);
    }

    void subirVolumen() {
        dispositivo.setVolume(dispositivo.getVolume() + 1);
    }

    void bajarVolumen() {
        dispositivo.setVolume(dispositivo.getVolume() - 1);
    }
}

// Pruebas
public class bridge {
    public static void main(String[] args) {
        // Crear dispositivos gamer
        PCGamer pcGamer = new PCGamer();
        Consola consola = new Consola();
        AuricularesGamer auriculares = new AuricularesGamer();

        // Probar el control remoto básico
        System.out.println("=== Control Remoto Básico ===");
        ControlRemoto controlRemotoBasico = new ControlRemoto(pcGamer);
        controlRemotoBasico.encender();
        controlRemotoBasico.apagar();

        // Probar el control remoto avanzado
        System.out.println("\n=== Control Remoto Avanzado ===");
        ControlRemotoAvanzado controlRemotoAvanzado = new ControlRemotoAvanzado(auriculares);
        controlRemotoAvanzado.encender();
        controlRemotoAvanzado.subirVolumen();
        controlRemotoAvanzado.subirVolumen();
        controlRemotoAvanzado.bajarVolumen();
        controlRemotoAvanzado.apagar();

        // Usar la consola
        System.out.println("\n=== Usando la Consola ===");
        ControlRemoto controlRemotoConsola = new ControlRemoto(consola);
        controlRemotoConsola.encender();
        controlRemotoConsola.apagar();
    }
}
