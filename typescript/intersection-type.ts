type Color = {
    color:string
}
type Border = {
    width:number
}
type BorderColor = Color & Border;

let bc:BorderColor = {
    color:"Red",
    width:10
}