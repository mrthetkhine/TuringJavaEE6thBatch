function greet(message:string){
    console.log('Greet ',message);
}
greet("123");

function add(a:number,b:number):number{
    return a+b;
}
let result = add(3,5);
console.log('Result ',result);

const names = ["Alice", "Bob", "Eve"];

names.forEach((name) => {
    console.log(name.toUpperCase());
});