interface TwoD
{
    x:number;
    y:number;
}
interface ThreeD extends TwoD
{
    z:number;
}
let pos:ThreeD = {
    x:10,
    y:20,
    z:30
};

interface Color {
    color:string;
}
interface Border {
    width:number;
}

interface BorderColor extends Color, Border {

}
type BorderedColor = Color & Border