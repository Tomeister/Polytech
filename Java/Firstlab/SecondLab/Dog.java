package SecondLab;

public class Dog extends Creature implements Creep {

    public Dog(){
        System.out.println("One more dog has been added!");
    }

    @Override
    public void tellAboutMyself() {
        super.tellAboutMyself();
        whoAmI();
        creep();
    }

    @Override
    public void whoAmI() {
        System.out.println("I'm dog!");
    }

//    @Override
//    public void creep() {
//        System.out.println("Creeping funny dog  ^^(:->)" );
//    }
}
