package main

import (
	"fmt"
	"net/http"
	"time"
)

func init() {

	http.HandleFunc("/hello", helloHandler)
}

func helloHandler(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintln(w, "Hello from the Go app")
}

func newMyAPI(w http.ResponseWriter, r *http.Request) {
	t := time.Now()

	fmt.Fprintln(w, t.Format("2006-01-02 15:04:05"))
}

func main() {

	http.HandleFunc("/", newMyAPI)

	fmt.Println("starting server at :8080")
	http.ListenAndServe(":8080", nil)
}
