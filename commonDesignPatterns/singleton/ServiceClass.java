package commonDesignPatterns.singleton;

public class ServiceClass {

    //this is the best way of creating a singleton class and it's called Bill-Pugh Initialization
    //This helps in lazy initialization because inner class is initialized only when the outer class in invoked,
    // and also, if multiple threads try to intialize the class,
    //since the inner class is thread-safe(JVM feature), only one instance will be created
    private ServiceClass(){
        System.out.println("The object is created!");
    };

    private static class ServiceClassHelper{
        private static final ServiceClass serviceClass = new ServiceClass();
    }

    public static ServiceClass getInstance(){
        return ServiceClassHelper.serviceClass;
    }
}
