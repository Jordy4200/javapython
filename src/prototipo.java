// Clase abstracta para personajes
abstract class Character implements Cloneable {
    protected String name;
    protected String power;

    public Character(String name, String power) {
        this.name = name;
        this.power = power;
    }

    public Character clone() {
        try {
            return (Character) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + name + " - Poder: " + power;
    }
}

// Clase Hero
class Hero extends Character {
    public String specialAbility;

    public Hero(String name, String power, String specialAbility) {
        super(name, power);
        this.specialAbility = specialAbility;
    }

    @Override
    public String toString() {
        return super.toString() + " - Habilidad especial: " + specialAbility;
    }
}

// Clase Villain
class Villain extends Character {
    public String evilPlan;

    public Villain(String name, String power, String evilPlan) {
        super(name, power);
        this.evilPlan = evilPlan;
    }

    @Override
    public String toString() {
        return super.toString() + " - Plan malvado: " + evilPlan;
    }
}

// Pruebas
public class prototipo {
    public static void main(String[] args) {
        // Prototipos de personajes
        Hero heroPrototype = new Hero("Goku", "Super Saiyajin", "Kamehameha");
        Villain villainPrototype = new Villain("Freezer", "Manipulación de energía", "Destruir planetas");

        // Clonación de personajes
        Hero hero1 = (Hero) heroPrototype.clone();
        hero1.name = "Vegeta";
        hero1.specialAbility = "Final Flash";

        Hero hero2 = (Hero) heroPrototype.clone();
        hero2.name = "Gohan";
        hero2.power = "Super Saiyajin 2";

        Villain villain1 = (Villain) villainPrototype.clone();
        villain1.name = "Cell";
        villain1.evilPlan = "Absorber a los androides";

        Villain villain2 = (Villain) villainPrototype.clone();
        villain2.name = "Majin Boo";
        villain2.power = "Regeneración";

        // Mostrar personajes
        System.out.println(hero1);
        System.out.println(hero2);
        System.out.println(villain1);
        System.out.println(villain2);
    }
}
