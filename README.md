"# k8s" 

<link rel="stylesheet" type="text/css" href="styles.css">

## Steps to rebuild: 
#### From Parent Folder run `rebuild-docker.sh` to compile and upload binary to docker registry.
##### PS. Replace/pass your username
Run the command to build and upload latest images `.\rebuild-docker.sh`
<br/> Wait for script to compile and upload binaries

## Launch with Kubernetes
To launch with kubernetes, run command `kubectl apply -f manifest.yml`
<br/> Wait for pods to get to running state. Use command to verify state `kubectl get all -n=k8s-namespace`

### After launch, verify
Ports forwarding to expose internal services:
<br/>post-service: `kubectl port-forward service/posts-service -n k8s-namespace 8085:8080`
<br/>user-service: `kubectl port-forward service/users-service -n k8s-namespace 8086:8080`

<li> localhost:8085 -> post-service </li>
<li> localhost:8086 -> users-service </li>

<br/>

<figure>
 <img src="https://github.com/vivek807/k8s/blob/main/Docs/7.jpg?raw=true"/>
 <img src="https://github.com/vivek807/k8s/blob/main/Docs/8.jpg?raw=true"/>
 <img src="https://github.com/vivek807/k8s/blob/main/Docs/9.jpg?raw=true"/>
 <img src="https://github.com/vivek807/k8s/blob/main/Docs/10.jpg?raw=true"/>
 <img src="https://github.com/vivek807/k8s/blob/main/Docs/11.jpg?raw=true"/>
 <img src="https://github.com/vivek807/k8s/blob/main/Docs/12.jpg?raw=true"/>
 <img src="https://github.com/vivek807/k8s/blob/main/Docs/13.jpg?raw=true"/>
 <img src="https://github.com/vivek807/k8s/blob/main/Docs/14.jpg?raw=true"/>
 <img src="https://github.com/vivek807/k8s/blob/main/Docs/15.jpg?raw=true"/>
 <img src="https://github.com/vivek807/k8s/blob/main/Docs/16.jpg?raw=true"/>
</figure>

#### Stop pods
Run command `kubectl delete -f manifest.yml -n k8s-namespace`

## Install with Helm
Run the command `helm install users-posts-chart .\user-posts-chart\`

### After launch, verify
<li>helm ls -A </li>
<li>kubectl get all -n k8s-namespace</li>

<br/>

<figure>
<img src="https://github.com/vivek807/k8s/blob/main/Docs/helm1.jpg?raw=true"/>
<img src="https://github.com/vivek807/k8s/blob/main/Docs/helm2.jpg?raw=true"/>
<img src="https://github.com/vivek807/k8s/blob/main/Docs/helm4.jpg?raw=true"/>
</figure>

#### Delete charts
Run command `helm delete users-posts-chart`

## Using ingress

<br/>
<figure>
<img src="https://github.com/vivek807/k8s/blob/main/Docs/ingress1.jpg?raw=true"/>
<img src="https://github.com/vivek807/k8s/blob/main/Docs/ingress2.jpg?raw=true"/>
</figure>


## Launch with docker
To launch with docker, just run the command `docker compose up`

### After launch, verify 
<li> localhost:8080 -> post-service </li>
<li> localhost:8081 -> user-service </li>

<br/>

<figure>
<img src="https://github.com/vivek807/k8s/blob/main/Docs/1.jpg?raw=true"/>
<img src="https://github.com/vivek807/k8s/blob/main/Docs/2.jpg?raw=true"/>
<img src="https://github.com/vivek807/k8s/blob/main/Docs/3.jpg?raw=true"/>
<img src="https://github.com/vivek807/k8s/blob/main/Docs/4.jpg?raw=true"/>
<img src="https://github.com/vivek807/k8s/blob/main/Docs/5.jpg?raw=true"/>
<img src="https://github.com/vivek807/k8s/blob/main/Docs/6.jpg?raw=true"/>
</figure>
