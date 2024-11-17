package main

import (
	"errors"
	"fmt"
)

func div(a int, b int) (int, error) {
	if b == 0 {
		return 0, errors.New("division by zero")
	}
	return a / b, nil
}
func main() {
	result, err := div(10, 2)
	if err != nil {
		fmt.Println("Errors ", err.Error())
	} else {
		fmt.Println(result)
	}

}
