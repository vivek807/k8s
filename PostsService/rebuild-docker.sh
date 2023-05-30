USERNAME="${1:-epamvivekdhiman}"
docker build -t $USERNAME/post-service:0.2 ./
docker login
docker push $USERNAME/post-service:0.2
