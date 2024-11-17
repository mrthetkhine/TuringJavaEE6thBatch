interface Animal {
  name: string;
}

interface Bear extends Animal {
  honey: boolean;
}
let bear:Bear= {
    name:"Panda",
    honey:true
}