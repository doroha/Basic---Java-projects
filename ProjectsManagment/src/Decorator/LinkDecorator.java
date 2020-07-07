package Decorator;

public class LinkDecorator extends AdvancedDesignDecorator{
    public LinkDecorator(Design design) {
        super(design);

        System.out.println("Link design was added");
    }
}
