package SecondLab;

public class Snake extends Creature implements Wriggle {
    public Snake(){
        System.out.println("One more snake has been added!");
    }

    @Override
    public void tellAboutMyself() {
        super.tellAboutMyself();
        whoAmI();
        creep();
        wriggle();
    }

//    @Override
//    public void creep() {
//        System.out.println("I'm creeping snake --__--:>");
//    }

    @Override
    public void whoAmI() {
        System.out.println("I'm snake !");
    }

    @Override
    public void wriggle() {
        System.out.println("I'm wriggling snake  __/|_____/|_---:>");
    }
}
