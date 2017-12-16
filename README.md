# Build
mvn clean package && docker build -t com.pedantic/fullstack-javaee .

# RUN

docker rm -f fullstack-javaee || true && docker run -d -p 8080:8080 -p 4848:4848 --name fullstack-javaee com.pedantic/fullstack-javaee 