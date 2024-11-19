const someClass = class<Type> {
  content: Type;
  constructor(value: Type) {
    this.content = value;
  }
};
 
const m = new someClass("Hello, world");
console.log('M ',m);

class Data
{

}
const MyData =Data;
let obj = new MyData();
console.log('Obj ',obj);