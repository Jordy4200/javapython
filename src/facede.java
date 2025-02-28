abstract class Dispositivo {
    abstract void encender();
    abstract void apagar();
}

class PCGamer extends Dispositivo {
    @Override
    void encender() {
        System.out.println("Encendiendo PC Gamer... ¡Listo para jugar!");
    }

    @Override
    void apagar() {
        System.out.println("Apagando PC Gamer... ¡Hasta la próxima partida!");
    }
}

class LucesRGB extends Dispositivo {
    @Override
    void encender() {
        System.out.println("Encendiendo luces RGB... ¡Ambiente gamer activado!");
    }

    @Override
    void apagar() {
        System.out.println("Apagando luces RGB... Ambiente relajado.");
    }
}

class PlayStation4 extends Dispositivo {
    @Override
    void encender() {
        System.out.println("Encendiendo PlayStation 4... ¡Hora de jugar!");
    }

    @Override
    void apagar() {
        System.out.println("Apagando PlayStation 4... Guardando partida.");
    }
}

class MonitorCurvo extends Dispositivo {
    @Override
    void encender() {
        System.out.println("Encendiendo monitor curvo... ¡Immersión total!");
    }

    @Override
    void apagar() {
        System.out.println("Apagando monitor curvo... Descanso para los ojos.");
    }
}

class SetupGamer {
    private PCGamer pcGamer;
    private LucesRGB lucesRGB;
    private PlayStation4 playStation4;
    private MonitorCurvo monitorCurvo;

    public SetupGamer() {
        this.pcGamer = new PCGamer();
        this.lucesRGB = new LucesRGB();
        this.playStation4 = new PlayStation4();
        this.monitorCurvo = new MonitorCurvo();
    }

    public void modoJuego() {
        System.out.println("Activando modo juego... ¡Prepárate para la acción!");
        pcGamer.encender();
        lucesRGB.encender();
        playStation4.apagar();
        monitorCurvo.encender();
    }

    public void modoDescanso() {
        System.out.println("Activando modo descanso... ¡Relájate un poco!");
        pcGamer.apagar();
        lucesRGB.apagar();
        playStation4.apagar();
        monitorCurvo.apagar();
    }
}

public class facede {
    public static void main(String[] args) {
        SetupGamer setup = new SetupGamer();
        setup.modoJuego();
        System.out.println("\n");
        setup.modoDescanso();
    }
}
