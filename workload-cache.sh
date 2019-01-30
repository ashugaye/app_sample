#!/bin/bash

for i in {1..1000}; do combined=""; for i in {1..30}; do token=$((1 + RANDOM % 10000)); combined="${combined}${combined:+,}$token"; done; curl -s http://store-spring-boot/stores/$combined; done