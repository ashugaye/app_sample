#!/bin/bash

for i in {1..10000}; do curl -s http://store-spring-boot/stores/$((1 + RANDOM % 10000)) > /dev/null; done