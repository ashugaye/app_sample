# app_sample
Go application for testing purposes

## ToC
* Deploy AKS - automate it
* Deploy Registry - one per project


##Steps:
az aks get-credentials --resource-group cloud-shell-storage-westeurope --name k1000
kubectl create clusterrolebinding kubernetes-dashboard -n kube-system --clusterrole=cluster-admin --serviceaccount=kube-system:kubernetes-dashboard

### Build local
```bash
docker build -t apps_sample:1.0.0 .
docker run -p 8080:8080 -it apps_sample:1.0.0
```

### Clean local
```bash
alias docker-clean=' \
  docker container prune -f ; \
  docker image prune -f ; \
  docker network prune -f ; \
  docker volume prune -f '

dclean() {
    docker rm -v $(docker ps --filter status=exited -q 2>/dev/null) 2>/dev/null
    docker rmi $(docker images --filter dangling=true -q 2>/dev/null) 2>/dev/null
}
```
### ACR
```bash


az acr repository list --name k0001 --output table
# Result
# ----------
# app_sample
az acr repository show-tags --name k0001 --repository app_sample --output table
# Result
# --------
# 1.0.0

# Build 
az acr login --name k0001
az acr build --registry k0001 --image app_sample:1.0.0 .
az acr list
az acr build --registry k0001 --image app_sample:{{.Run.ID}} .
```
