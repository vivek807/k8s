USERNAME="${1:-epamvivekdhiman}"
docker build -t $USERNAME/user-service:0.1 ./
docker login
docker push $USERNAME/user-service:0.1
