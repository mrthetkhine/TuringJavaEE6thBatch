class Foo {
    static #count = 0;
 
    get count() {
        return Foo.#count;
    }
 
    static {
        console.log("Static block 1")
    }
    static {
        console.log("Static block 2")
    }
}