let arr = [1,2,3];
let result = arr.map(x=>x*2);
console.log('result ',result);

let result2 = arr.map(x=>[x,x*2])
             .flat();
console.log('result ',result2);

result2 = arr.flatMap(x=>[x,x*2])
            // .flat();
console.log('result ',result2);