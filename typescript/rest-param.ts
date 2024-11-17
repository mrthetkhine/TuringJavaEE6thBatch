function sum(n: number, ...m: number[]) {
    let total = 0;
    for (let i = 0; i < m.length; i++) {
      total += m[i] ;
    }
    return total;    
}

const a = sum(1, 2,4,2);
console.log(a);