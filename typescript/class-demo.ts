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
class Teacher extends Human
{
    subject: string;
    constructor(name: string, age: number, subject: string) {
        super(name, age);
        this.subject = subject;
        console.log('Teacher Constructor');
    }
    display(): void {
        super.display();
        console.log('Subject ',this.subject);
    }
}
let h1: Human = new Human("TK", 40);
//console.log('H1 ',h1);
h1.display();

let h2:Teacher= new Teacher("TK", 40, "Java");
console.log('H2 ',h2);
h2.display();