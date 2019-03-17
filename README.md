# Quarkus Addok client

# Getting started
Install [Addok](https://github.com/etalab/addok-docker) backend.

1. Launch:

    ```console
    mvn compile quarkus:dev
    ```
2. Debug:

    ```console
    mvn compile quarkus:dev -Ddebug=true
    ```
    Attach a debugger to **localhost:5005**

3. Build native image(GraalVM required):
    ```console
    mvn package -Pnative
    ```
4. Build native image using Docker container:
    ```console
    mvn package -Pnative -Dnative-image.docker-build=true
    ```

More informations on [Quarkus](https://github.com/etalab/addok-docker) website.
