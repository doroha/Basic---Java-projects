package Decorator;

public class LogoDecorator extends AdvancedDesignDecorator{
    public LogoDecorator(Design newDesign){
        super(newDesign);

        System.out.println("Logo design was added");
    }
}
