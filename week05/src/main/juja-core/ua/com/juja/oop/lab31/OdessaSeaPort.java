package ua.com.juja.oop.lab31;

class Liner extends AbstractShip {

    private int passengers;
    public static final float DEFAULT_RENTAL = 1000;

    public Liner(String name, float length, float width, float displacement, int passengers) {
        super(name, length, width, displacement);
        this.passengers = passengers;
    }

    @Override
    public float calculatePayment() {
        return passengers * DEFAULT_RENTAL;
    }

    public float calculatePayment(float rentTax) {
        if (rentTax > 0) {
            return passengers * rentTax;
        } else {
            return calculatePayment();
        }
    }
}

class Tanker extends AbstractShip {
    private float volume;
    public static final float DEFAULT_RENTAL = 250;

    public Tanker(String name, float length, float width, float displacement, float volume) {
        super(name, length, width, displacement);
        this.volume = volume;
    }

    @Override
    public float calculatePayment() {
        return volume * DEFAULT_RENTAL;
    }

    public float calculatePayment(float rentTax) {
        if (rentTax > 0) {
            return volume * rentTax;
        } else {
            return calculatePayment();
        }
    }
}

class Cargo extends AbstractShip {
    private float tonnage;
    public static final float DEFAULT_RENTAL=550;

    public Cargo(String name, float length, float width, float displacement, float tonnage) {
        super(name, length, width, displacement);
        this.tonnage = tonnage;
    }

    @Override
    public float calculatePayment() {
        return tonnage * DEFAULT_RENTAL;
    }

    public float calculatePayment(float rentTax) {
        if (rentTax > 0) {
            return tonnage * rentTax;
        } else {
            return calculatePayment();
        }
    }
}

abstract class AbstractShip {
    private String name;
    private float length;
    private float width;
    private float displacement;

    public AbstractShip(String name, float length, float width, float displacement) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.displacement = displacement;
    }

    public abstract float calculatePayment();

    public String toPrint() {
        return "Name=" + name +
                "Length=" + length +
                "Width=" + width +
                "Displacement=" + displacement;
    }

    public String getName() {
        return name;
    }
}
interface SeaPortQueue {
    public final static int LENGTH_QUEUE_SHIP = 3;
    public int addShipToEndQueue(AbstractShip ship);
    public int removeShipFromBeginQueue();
    public String printQueueShip();
}

class OdessaSeaPort implements SeaPortQueue {
    private static final int NO_SHIP_IN_ARRAY = -1;
    private int indexShipInPort = NO_SHIP_IN_ARRAY;
    private AbstractShip[] arrayShip = new AbstractShip[LENGTH_QUEUE_SHIP];

    public int addShipToEndQueue(AbstractShip ship) {
        if (indexShipInPort + 1 < LENGTH_QUEUE_SHIP) {
            indexShipInPort++;
            arrayShip[indexShipInPort] = ship;
            return indexShipInPort;
        } else {
            return -1; //Queue is full
        }
    }

    public int removeShipFromBeginQueue() {
        if (arrayShip[0] == null) {
            return -1; //Queue is empty
        } else {
            if (arrayShip[1] == null){
                arrayShip[0] = null;
                indexShipInPort--;
                return 1;
            } else{
                System.arraycopy(arrayShip, 1, arrayShip, 0, indexShipInPort);
                arrayShip[indexShipInPort] = null;
                indexShipInPort--;
                return 1;
            }
        }
    }

    public String printQueueShip() {
        if (arrayShip[0] != null) {
            String result = "";
            for (int i = 0; i < LENGTH_QUEUE_SHIP; i++) {
                if (arrayShip[i] != null) {
                    result += "{" + arrayShip[i].toPrint() + "};";
                }
            }
            return result;
        } else {
            return "QueueEmpty";
        }
    }
}
