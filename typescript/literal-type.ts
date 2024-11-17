//state =loading, finished
type Loading = "loading";
let loading:Loading = "loading";
//loading = "another";

type Status = "loading" | "finished";
let state:Status = "loading";
state = "finished";
//state = "another";

let data;
console.log("Data is ", data);

function liveDangerously(x?: number | null) {
    // No error
    console.log(x!.toFixed());
}
liveDangerously(122);