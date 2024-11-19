package main

import "fmt"

type Flyable interface {
	fly()
}
type Bird struct {
}

func (b Bird) fly() {
	fmt.Println("Bird fly")
}
func main() {
	var fly Flyable
	fly = Bird{}
	fly.fly()
}
