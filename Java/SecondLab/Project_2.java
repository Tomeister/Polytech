package SecondLab;

public class Project_2 {
    public static void main(String[] args) {

        if ( args.length!=1) {
            System.out.println("Incorrect amount of args");
            System.exit(1);
        }

        int length = 0;
        try {
            length = Integer.parseInt(args[0]);
            if (length<1){
                System.out.println("length can not be negative!");
                System.exit(1);
            }
        }
        catch (NumberFormatException nfe){
            System.out.println("Incorrect args type input");
            System.exit(1);
        }
        Creature[] creaturesArray = new Creature[length];
        if (length < 2) {
            System.out.println("not enought length to see all the species diversity");
        }


        for (int i = 0; i < length-length%2 ; i=i+2) {
            Dog dog_1 = new Dog();
            Snake snake_1 = new Snake();
            creaturesArray[i] = dog_1;
            creaturesArray[i+1] = snake_1;
        }
        if ( length%2==1) {
            Dog dog_1 = new Dog();
            creaturesArray[length - 1] = dog_1;
        }

        System.out.println("");

        for ( Creature creat : creaturesArray){
            creat.tellAboutMyself();
        }

    }
}
