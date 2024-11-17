interface StringArray {
  [index: number]: string;
}
let arr:StringArray = ['apple','orange',"banana"];
console.log('Arr ',arr[0]); 

interface Mapper{
    [key:string]:string
}
let obj:Mapper = {
    name:"TK",
    age:"40"
};
console.log('Obj ',obj["name"]);