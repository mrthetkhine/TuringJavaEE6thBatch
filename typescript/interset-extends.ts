interface TwoD
{
    x: number;
    y: number;
}
interface ThreeD extends TwoD
{
    z: number;
}
interface Color
{
    color: string;
}
interface Border
{
    width:number;
}
type BorderedColor = Border & Color;
let b:BorderedColor = {
    color:"Red",
    width:10
}