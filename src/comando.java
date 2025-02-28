// Clase abstracta para comandos
abstract class Command {
    abstract void execute();
    abstract void undo();
}

// Clase PC
class PC {
    void turnOn() {
        System.out.println("PC encendida");
    }

    void turnOff() {
        System.out.println("PC apagada");
    }

    void openGame() {
        System.out.println("Juego abierto");
    }

    void closeGame() {
        System.out.println("Juego cerrado");
    }

    void startStream() {
        System.out.println("Transmisión iniciada");
    }

    void stopStream() {
        System.out.println("Transmisión detenida");
    }
}

// Comando para encender la PC
class TurnOnCommand extends Command {
    private PC pc;

    TurnOnCommand(PC pc) {
        this.pc = pc;
    }

    @Override
    void execute() {
        pc.turnOn();
    }

    @Override
    void undo() {
        pc.turnOff();
    }
}

// Comando para apagar la PC
class TurnOffCommand extends Command {
    private PC pc;

    TurnOffCommand(PC pc) {
        this.pc = pc;
    }

    @Override
    void execute() {
        pc.turnOff();
    }

    @Override
    void undo() {
        pc.turnOn();
    }
}

// Comando para abrir un juego
class OpenGameCommand extends Command {
    private PC pc;

    OpenGameCommand(PC pc) {
        this.pc = pc;
    }

    @Override
    void execute() {
        pc.openGame();
    }

    @Override
    void undo() {
        pc.closeGame();
    }
}

// Comando para iniciar una transmisión
class StartStreamCommand extends Command {
    private PC pc;

    StartStreamCommand(PC pc) {
        this.pc = pc;
    }

    @Override
    void execute() {
        pc.startStream();
    }

    @Override
    void undo() {
        pc.stopStream();
    }
}

// Control remoto
class RemoteControl {
    private java.util.List<Command> commands = new java.util.ArrayList<>();

    void addCommand(Command command) {
        System.out.println("Comando agregado: " + command.getClass().getSimpleName());
        commands.add(command);
    }

    void executeCommands() {
        System.out.println("Ejecutando comandos");
        for (Command command : commands) {
            command.execute();
        }
    }

    void undoCommands() {
        if (!commands.isEmpty()) {
            System.out.println("Deshaciendo último comando");
            commands.remove(commands.size() - 1).undo();
        }
    }

    void undoAllCommands() {
        System.out.println("Deshaciendo todos los comandos");
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
        commands.clear();
    }
}

// Pruebas
public class comando {
    public static void main(String[] args) {
        // Creación de la PC y el control remoto
        PC pc = new PC();
        RemoteControl remoteControl = new RemoteControl();

        // Agregar comandos
        remoteControl.addCommand(new TurnOnCommand(pc));
        remoteControl.addCommand(new OpenGameCommand(pc));
        remoteControl.addCommand(new StartStreamCommand(pc));

        // Ejecutar comandos
        remoteControl.executeCommands();

        // Deshacer último comando
        remoteControl.undoCommands();

        // Deshacer todos los comandos
        remoteControl.undoAllCommands();
    }
}
