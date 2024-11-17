class Human
{
    name: string;
    age : number;
    constructor(name: string, age: number) {
        this.name = name;
        this.age = age;

        console.log('Human Constructor');
    }
    display(): void {
        console.log('Display ',this.name, ' Age ',this.age);
    }
}
let h1: Human = new Human("TK", 40);
//console.log('H1 ',h1);
h1.display();