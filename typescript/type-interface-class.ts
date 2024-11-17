interface Human{
    name:string;
    age:number;

    display:()=>void
}
let h1: Human = {
    name:"TK",
    age:40,
    display: function(){
        console.log('Display ',this.name, ' Age ',this.age);
    }
}
let h2:Human = {
    name:"Jhon Wick",
    age:50,
    display: function(){
        console.log('Display ',this.name, ' Age ',this.age);
    }
}

class Person implements Human
{
    name: string;
    age: number;

    constructor (name: string, age: number) {
        this.name = name;
        this.age = age;
    }
    display(): void {
        console.log('Display ',this.name, ' Age ',this.age);
    }
}
let p1:Person = new Person("TK",40);
let p2:Person = new Person("Jhon Wick",50);

p1.display();
p2.display();