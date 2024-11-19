class Human
{
    _age:number;
    constructor(age:number)
    {
        this._age = age;
    }
    get age()
    {
        console.log('Getter');
        return this._age;
    }
    set age(newValue)
    {
        if(newValue>0 && newValue<100)
        {
            this._age = newValue;
        }
    }
}
let h = new Human(20);
console.log('Age ',h.age);
h.age = 50;
console.log('Age ',h.age);

h.age = 300;
console.log('Age ',h.age);