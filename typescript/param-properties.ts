class Params {
  constructor(
    public readonly x: number,
    protected y: number,
    private z: number
  ) {
    // No body necessary
  }
}
let p = new Params(1, 2, 3);
console.log('P ',p);