package SecondLab;

public interface Creep {
    default public void creep(){
        System.out.println("I can creep!!");
    }
    public void whoAmI();
}
