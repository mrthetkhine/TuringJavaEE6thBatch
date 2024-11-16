
type Position = {
    x:number,
    y:number,
    z?:number
}
function display(pos:Position){
    console.log('X ',pos.x);
    console.log('Y ',pos.y);
    console.log('Z ',pos.z);
}

display({
    x:100,
    y:300,
    z:400,
})