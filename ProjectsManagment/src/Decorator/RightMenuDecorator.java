package Decorator;

public class RightMenuDecorator extends AdvancedDesignDecorator{
    public RightMenuDecorator(Design design) {
        super(design);

        System.out.println("Right menu design was added");
    }
}
