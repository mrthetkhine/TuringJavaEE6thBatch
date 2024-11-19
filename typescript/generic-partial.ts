class Box
{
    content:any = null;
}
let box:Box = new Box();
box.content = "Hello";
console.log(box.content.toLowerCase());

box.content = 3;
console.log(box.content.toLowerCase());