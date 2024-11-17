function display(message?:string)
{
    console.log('Display ',message);
}
display();
display('Hello');

interface Human{
    name:string;
    age?:number;
    
}
let h1:Human = {
    name:"TK",
    
}
console.log('h1 ',h1);