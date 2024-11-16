//Circle/Rectangle
//Shape->Circle/Rectangle
type Circle= {
    radius: number
}
type Rectangle = {
    width: number,
    height: number
}
type Shape = Circle | Rectangle

let shape:Shape = {
    radius:100
};
shape = {
    width:100,
    height:200
}
//status loading/finished
type Status = "loading" | "finished"
let s: Status = "loading"
s = "finished"
//s = "Another"

type ID = number | string

let id:ID = 123;

id = "I1233";
console.log(id.toLowerCase());