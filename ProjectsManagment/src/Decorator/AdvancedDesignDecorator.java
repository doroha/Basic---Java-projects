package Decorator;

public class AdvancedDesignDecorator implements Design{
    private Design design;

    public AdvancedDesignDecorator(Design design){
        this.design = design;
    }

    public void displayDesign(){
        design.displayDesign();
    }
}
