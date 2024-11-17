function greet(message:string):void
{
    console.log('Greet ',message);
}
function hello(msg:string):void{
    console.log('Hello ',msg);
}

type Fun= (msg:string) => void;
let fun:Fun = greet;
fun('Hi');

fun = hello;
fun('Hello');

function add(a:number,b:number):number{
    return a+b;
}
function sub(a:number,b:number):number{
    return a-b;
}
type NumericFun = (a:number,b:number) => number;
let numericFun:NumericFun = add;

console.log('add ',numericFun(3,5));

numericFun = sub;
console.log('sub ',numericFun(3,5));