class Circle
{
    private radius:number;

    constructor(radius:number)
    {
        this.radius = radius;
    }
    get area()
    {
        console.log('Getter');
        return  Math.PI* this.radius * this.radius ;
    }
}
let circle = new Circle(3);
console.log('Area ',circle.area);