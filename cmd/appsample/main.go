package main

import (
	"errors"
	"fmt"
	"net"
	"net/http"
	"time"
)

func init() {

	http.HandleFunc("/hello", helloHandler)
}

func helloHandler(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintln(w, "Hello from the Go app on the AKS")
}

func externalIP() (string, error) {
	ifaces, err := net.Interfaces()
	if err != nil {
		return "", err
	}
	for _, iface := range ifaces {
		if iface.Flags&net.FlagUp == 0 {
			continue // interface down
		}
		if iface.Flags&net.FlagLoopback != 0 {
			continue // loopback interface
		}
		addrs, err := iface.Addrs()
		if err != nil {
			return "", err
		}
		for _, addr := range addrs {
			var ip net.IP
			switch v := addr.(type) {
			case *net.IPNet:
				ip = v.IP
			case *net.IPAddr:
				ip = v.IP
			}
			if ip == nil || ip.IsLoopback() {
				continue
			}
			ip = ip.To4()
			if ip == nil {
				continue // not an ipv4 address
			}
			return ip.String(), nil
		}
	}
	return "", errors.New("are you connected to the network?")
}

func newMyAPI(w http.ResponseWriter, r *http.Request) {
	t := time.Now()
	ip, err := externalIP()
	if err != nil {
		fmt.Println(err)
	}
	fmt.Fprintln(w, t.Format("2006-01-02 15:04:05"))
	fmt.Fprintln(w, ip)
}

func main() {

	http.HandleFunc("/", newMyAPI)

	fmt.Println("starting server at :8080")
	http.ListenAndServe(":8080", nil)
}
