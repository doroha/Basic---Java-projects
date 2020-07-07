package Decorator;

public class UpMenuDecorator extends AdvancedDesignDecorator{
    public UpMenuDecorator(Design design) {
        super(design);

        System.out.println("Upper menu design was added");
    }
}
