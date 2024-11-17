function greet():string{
    console.log('greet');
    return 'Greet';
}
function hi():void{
    console.log('hi');
}
let fun:Function = greet;

console.log(fun());
fun  = hi;
console.log(fun());