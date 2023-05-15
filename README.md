"# k8s" 

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


<ul>
<li> <img src="https://github.com/vivek807/k8s/blob/main/Docs/7.jpg?raw=true"/>
<li> <img src="https://github.com/vivek807/k8s/blob/main/Docs/8.jpg?raw=true"/>
<li> <img src="https://github.com/vivek807/k8s/blob/main/Docs/9.jpg?raw=true"/>
<li> <img src="https://github.com/vivek807/k8s/blob/main/Docs/10.jpg?raw=true"/>
<li> <img src="https://github.com/vivek807/k8s/blob/main/Docs/11.jpg?raw=true"/>
<li> <img src="https://github.com/vivek807/k8s/blob/main/Docs/12.jpg?raw=true"/>
</ul>

#### Stop pods
Run command `kubectl delete -f manifest.yml -n k8s-namespace`

## Launch with docker
To launch with docker, just run the command `docker compose up`

### After launch, verify 
<li> localhost:8080 -> post-service </li>
<li> localhost:8081 -> user-service </li>

<ul>
<li> <img src="https://github.com/vivek807/k8s/blob/main/Docs/1.jpg?raw=true"/>
<li> <img src="https://github.com/vivek807/k8s/blob/main/Docs/2.jpg?raw=true"/>
<li> <img src="https://github.com/vivek807/k8s/blob/main/Docs/3.jpg?raw=true"/>
<li> <img src="https://github.com/vivek807/k8s/blob/main/Docs/4.jpg?raw=true"/>
<li> <img src="https://github.com/vivek807/k8s/blob/main/Docs/5.jpg?raw=true"/>
<li> <img src="https://github.com/vivek807/k8s/blob/main/Docs/6.jpg?raw=true"/>
</ul>
