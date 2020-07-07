package Decorator;

public class MusicDecorator extends AdvancedDesignDecorator{
    public MusicDecorator(Design design) {
        super(design);

        System.out.println("Music was added");
    }
}
