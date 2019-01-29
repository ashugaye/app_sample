#!/usr/bin/env bash -x

usage() {
  echo "$_ [imageTag] [Chart1,Chart2,Chart3]"
  echo "imageTag: build image with 'imageTag'"
  echo "Charts: List of Helm charts separated with ','"
  echo "Example: $_ v6 'dao-spring-boot,store-spring-boot,workload-db,workload-cache'"
}
(($# == 2)) || { usage; exit 1; }
tag=$1
IFS=',' list=($2)
for item in "${list[@]}";do
    echo "$item processing..."
    az acr build --registry k0001 --image "${item}:${tag}" -f Dockerfile-${item}.maven .
    echo
done
