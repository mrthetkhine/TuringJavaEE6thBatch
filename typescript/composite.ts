interface Leaf<T>{
    value:T
}
type Tree = Leaf<number> | Tree[]
