USERNAME="${1:-epamvivekdhiman}"
docker build -t $USERNAME/post-service:0.1 ./
docker login
docker push $USERNAME/post-service:0.1
