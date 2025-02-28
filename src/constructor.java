// Clase PC
class PC {
    public String processor;
    public String graphicsCard;
    public String ram;
    public String storage;

    public PC() {
        this.processor = null;
        this.graphicsCard = null;
        this.ram = null;
        this.storage = null;
    }

    @Override
    public String toString() {
        return "PC Gamer con:\n- Procesador: " + processor + "\n- Tarjeta gráfica: " + graphicsCard + "\n- RAM: " + ram + "\n- Almacenamiento: " + storage;
    }
}

// Clase PCBuilder
class PCBuilder {
    private PC pc;

    public PCBuilder() {
        this.pc = new PC();
    }

    public PCBuilder buildProcessor(String processor) {
        pc.processor = processor;
        return this;
    }

    public PCBuilder buildGraphicsCard(String graphicsCard) {
        pc.graphicsCard = graphicsCard;
        return this;
    }

    public PCBuilder buildRam(String ram) {
        pc.ram = ram;
        return this;
    }

    public PCBuilder buildStorage(String storage) {
        pc.storage = storage;
        return this;
    }

    public PC getPC() {
        return this.pc;
    }
}

// Pruebas
public class constructor {
    public static void main(String[] args) {
        // Construyendo una PC Gamer
        PCBuilder builder = new PCBuilder();
        PC pc = builder.buildProcessor("Intel Core i9-13900K")
                       .buildGraphicsCard("NVIDIA RTX 4090")
                       .buildRam("32GB DDR5")
                       .buildStorage("2TB NVMe SSD")
                       .getPC();

        System.out.println(pc);
    }
}
