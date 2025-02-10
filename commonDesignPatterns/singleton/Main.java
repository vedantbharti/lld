package commonDesignPatterns.singleton;

public class Main {

    public static void main(String[] args) {

        //Bill-Pugh initialization
        //lazy and eager initialization are simple to implement and you should be good with it

        //can't be used to initialize the class since the constructor is private, helps in creating only one instance
//        ServiceClass serviceClass = new ServiceClass();

        //the text in constructor is printed only once no matter how many times you call getInstance, hence singleton
        ServiceClass serviceClass = ServiceClass.getInstance();
        ServiceClass serviceClass1 = ServiceClass.getInstance();
        ServiceClass serviceClass2 = ServiceClass.getInstance();
    }
}
