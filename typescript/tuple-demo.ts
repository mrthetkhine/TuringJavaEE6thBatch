function div(a:number,b:number):[number,any]{
    if(b==0){
        return [0,new Error('Division by zero')];
    }
    return [a/b,null];
}

let [result,err] = div(10,2);
if(err){
    console.log(err.message);
}else{
    console.log(result);
}

type Triple = [number, string,boolean];
let p:Triple = [1,'Hello',false];
console.log('P ',p[1].toUpperCase());