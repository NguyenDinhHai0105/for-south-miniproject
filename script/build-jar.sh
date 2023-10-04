cd ..
#echo "I am in forsouth"

#mvn clean install -Dmaven.test.skip=true

#build
eval $(minikube docker-env)

#forsouth
docker build -t docker30041999/forsouth:latest .