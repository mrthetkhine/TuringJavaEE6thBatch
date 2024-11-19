class Box<T>
{
    content:T;

    constructor(content:T)
    {
        this.content = content;
    }
}
let box:Box<string> = new Box<string>("Hello");
console.log(box.content.toLowerCase());

let box2:Box<number> = new Box<number>(123);
console.log(box2.content.toFixed());