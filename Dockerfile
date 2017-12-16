FROM airhacks/glassfish
COPY ./target/fullstack-javaee.war ${DEPLOYMENT_DIR}
