import java.util.Collection;

public class A {
    Collection col;

    public Object clone(){
        A clone = new A();
        clone.col = (Collection) clone.col;
        return clone;
    }
}
