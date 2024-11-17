type Position = {
    x:number,
    y:number,
    
}
function showPos({x,y}:Position){
    console.log('X ',x);
    console.log('Y ',y);
}
showPos({
    x:10,
    y:20
})