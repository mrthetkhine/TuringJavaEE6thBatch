interface Address {
    city: string;
    street: string;
}
interface Person {
  name: string;
  age: number;
  readonly address:Address;
}
 
function greet(person: Person) {
  return "Hello " + person.name;
}
let obj:Person = {
    name:"TK",
    age:40,
    address: {
        city:"New York",
        street:"123 Main St"
    }
}
/*
obj.address = {
    city:"New York",
    street:"123 Main St"
}*/
obj.address.city = "Yangon";
console.log(greet(obj));