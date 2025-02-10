package commonDesignPatterns.LiskovSubstitution.invalid;

import commonDesignPatterns.LiskovSubstitution.invalid.exception.EngineNotFoundException;

public class Bicycle extends Vehicle{

    @Override
    public boolean startEngine(){
        throw new EngineNotFoundException("This vehicle doesn't have an engine");
    }
}
