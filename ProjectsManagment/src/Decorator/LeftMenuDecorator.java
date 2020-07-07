package Decorator;

public class LeftMenuDecorator extends AdvancedDesignDecorator{
    public LeftMenuDecorator(Design design) {
        super(design);

        System.out.println("Left menu design was added");
    }
}
