function hello()
{
    console.log('Hello from node.js');
}
let fun = hello;
fun();

function execute(fn)
{
    console.log('Execute ');
    fn();
}
execute(hello);
function getFun()
{
    return hello;
}
getFun()();