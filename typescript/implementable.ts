interface Flyable
{
    name:string;
    fly:()=>void;
}
class Bird implements Flyable
{
    name: string;
    constructor(name:string) {
        this.name = name;
    }
    fly(): void {
        console.log('Bird Flying');
    }
}
class Aeroplane implements Flyable
{
    name: string;
    constructor(name:string) {
        this.name = name;
    }
    fly(): void {
        console.log('Aeroplane Flying');
    }
}
let flyable:Flyable = new Aeroplane("Boing");
flyable.fly();

flyable = new Bird("Cockatoo");
flyable.fly();