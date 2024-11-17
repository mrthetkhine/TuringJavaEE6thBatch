type OurNumber = number;

let a:OurNumber = 123;
let b:OurNumber = 123.123;

console.log("A ",a);

type Address = {
    city:string,
    street:string,
}
type Human = {
    name:string,
    age:number,
    address:Address
}

let h1:Human = {
    name:"TK",
    age:40,
    address: {
        city:"New York",
        street:"123 Main St"
    }
}
console.log('h1 ',h1);