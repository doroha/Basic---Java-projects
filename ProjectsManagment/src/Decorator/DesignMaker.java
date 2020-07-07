package Decorator;

public class DesignMaker {

    public static void main(String[] args){
        Design newDesign = new MusicDecorator(new LogoDecorator(new BasicDesign()));
    }
}
