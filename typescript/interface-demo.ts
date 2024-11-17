interface Human
{
    name:string;
    age:number;
}
interface Address
{
    city:string;
    street:string
}
interface Human{
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