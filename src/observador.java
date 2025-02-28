// Clase abstracta para observadores
abstract class Observer {
    abstract void update(WatchDogsStock subject);
}

// Clase WatchDogsStock
class WatchDogsStock {
    private String name = "Watch Dogs";
    private boolean inStock = false;
    private java.util.List<Observer> observers = new java.util.ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
        notifyObservers();
    }

    public boolean isInStock() {
        return inStock;
    }

    public String getName() {
        return name;
    }
}

// Clase Gamer que implementa Observer
class Gamer extends Observer {
    private String name;

    public Gamer(String name) {
        this.name = name;
    }

    @Override
    void update(WatchDogsStock subject) {
        if (subject.isInStock()) {
            System.out.println(name + ", ¡buenas noticias! " + subject.getName() + " está en stock.");
        } else {
            System.out.println(name + ", lo sentimos. " + subject.getName() + " está agotado por el momento.");
        }
    }
}

// Pruebas
public class observador {
    public static void main(String[] args) {
        // Creación del stock del juego "Watch Dogs"
        WatchDogsStock watchDogsStock = new WatchDogsStock();

        // Creación de los gamers (observadores)
        Gamer gamer1 = new Gamer("Alex");
        Gamer gamer2 = new Gamer("Marta");
        Gamer gamer3 = new Gamer("Carlos");

        // Suscripción de los gamers al stock del juego
        watchDogsStock.addObserver(gamer1);
        watchDogsStock.addObserver(gamer2);
        watchDogsStock.addObserver(gamer3);

        // Cambios en el stock del juego
        System.out.println("--- Watch Dogs está agotado ---");
        watchDogsStock.setInStock(false);

        System.out.println("\n--- Watch Dogs está en stock ---");
        watchDogsStock.setInStock(true);

        System.out.println("\n--- Watch Dogs se agota de nuevo ---");
        watchDogsStock.setInStock(false);
    }
}
