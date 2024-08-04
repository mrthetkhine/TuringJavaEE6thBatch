class Engine
{
    void start()
    {
        System.out.println("Engine start");
    }
}
class DieselEngine extends Engine
{
    void start()
    {
        System.out.println("DieselEngine start");
    }
}
class GasEngine extends Engine
{
    void start()
    {
        System.out.println("GasEngine start");
    }
}
public class Car
{
    Engine engine;
    public Car(Engine engine)
    {
        this.engine = engine;
    }

    public void start()
    {
        System.out.println("Car start");
        this.engine.start();
    }
}