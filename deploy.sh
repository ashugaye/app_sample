#!/usr/bin/env bash +x

usage() {
  echo "$_ [del|install] [imageTag] [Chart1,Chart2,Chart3]"
  echo "imageTag: build image with 'imageTag'"
  echo "imageTag: build image with 'imageTag'"
  echo "Charts: List of Helm charts separated with ','"
  echo "Example: $_ del v6 'dao-spring-boot,store-spring-boot,workload-db,workload-cache'"
}
(($# == 3)) || { usage; exit 1; }
action=$1
tag=$2
IFS=',' list=($3)
for item in "${list[@]}";do
    echo "$item processing $1 ..."

    [[ "$action" == "del" ]] && helm del --purge ${item}
    [[ "$action" == "install" ]] && helm install --set image.tag=${tag} deployment/helm/${item} -n ${item}

    echo
done
