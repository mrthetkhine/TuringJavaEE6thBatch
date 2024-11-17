/*
interface Box {
    content:any
}

let box1: Box = {
    content:"Hello"
}

console.log(box1.content.toLowercase());
//console.log(box1.content.toFixed());
*/
interface Box<T> {
    content:T
}
let box1: Box<string> = {
    content:"Hello"
}   
console.log(box1.content.toLowerCase());
let box2:Box<number>={
    content:123
}
console.log(box2.content.toFixed());