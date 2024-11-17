/*
function getFirst(arr:any[]):any
{
    return arr[0];
}*/

function getFirst<T>(arr:T[]):T{
    return arr[0];
}
console.log('First ',getFirst<number>([1,2,3,4,5]));
console.log('First ',getFirst<string>(['apple','orange']));
