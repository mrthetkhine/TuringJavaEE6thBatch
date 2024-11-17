class Car
{
    constructor()
    {
        console.log('Car constructor'); 
    }
}
class Aeroplane
{
    constructor()
    {
        console.log('Aeroplane constructor'); 
    }
}
type SomeConstructor = {
    new (): object;
};
let con : SomeConstructor = Car;
let obj = new con();

console.log('Obj ',obj);

con = Aeroplane;
obj = new con();

console.log('Obj ',obj);