function hello(){
    console.log('Hello ');
}
hello.description = "This function print hello";

function greet()
{
    console.log('Greet');
}
type DescribableFunction = {
    description: string;
    (): void;
};
let fun:DescribableFunction = hello;
hello();
console.log(fun.description);

//fun = greet;