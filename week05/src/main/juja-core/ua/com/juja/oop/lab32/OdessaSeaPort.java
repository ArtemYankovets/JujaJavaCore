package ua.com.juja.oop.lab32;

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

class OdessaSeaPort {

    public static String sortSumPaymentAsc(AbstractShip[] arrayShips) {
        if ((arrayShips == null)||(arrayShips.length == 0)){
            return "";
        } else {
            String result = "";
            if (arrayShips.length > 1) {
                for (int i = 0; i < arrayShips.length; i++) {
                    for (int j = arrayShips.length - 1 ; j > i ; j--) {
                        if (arrayShips[j].calculatePayment() < arrayShips[j - 1].calculatePayment()){
                            AbstractShip tmp = arrayShips[j - 1];
                            arrayShips[j - 1] = arrayShips[j];
                            arrayShips[j] = tmp;
                        }
                    }
                    result += arrayShips[i].getName() + "=" + arrayShips[i].calculatePayment();
                }
            } else {
                result = arrayShips[0].getName() + "=" + arrayShips[0].calculatePayment();
            }
            return result;
        }
    }

}



