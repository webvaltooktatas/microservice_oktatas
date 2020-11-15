# Lépések
    Első lépés a Dockerfile létrehozása
    
  Majd amennyiben telepítésre került a Docker, futtassuk következő parancsot
    
    docker build -t demo_app .
  A docker feldolgozza és letölti a szükséges függőségeket, végrehajtja a leíróban definiált lépésekek majd elkészíti a
  képfájlt:
  
    ` ➜  megoldas docker build -t demo_app .
     Sending build context to Docker daemon  16.58MB
     Step 1/3 : FROM openjdk:8-jre-alpine
     8-jre-alpine: Pulling from library/openjdk
     e7c96db7181b: Pull complete
     f910a506b6cb: Pull complete
     b6abafe80f63: Pull complete
     Digest: sha256:f362b165b870ef129cbe730f29065ff37399c0aa8bcab3e44b51c302938c9193
     Status: Downloaded newer image for openjdk:8-jre-alpine
      ---> f7a292bbb70c
     Step 2/3 : COPY app.jar /app.jar
      ---> 6bed44ac2074
     Step 3/3 : CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=dev", "/app.jar"]
      ---> Running in ab11a8d835c1
     Removing intermediate container ab11a8d835c1
      ---> ccc3355680d5
     Successfully built ccc3355680d5
     Successfully tagged demo_app:latest
     ➜  megoldas `
     
    ➜  megoldas docker image ls
    REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
    demo_app            latest              ccc3355680d5        5 minutes ago       101MB
    ➜  megoldas
    
  Futtassuk a létrehozott konténert
  
    ➜  megoldas docker run -d -p 8081:8081 ccc3355680d5
    09486d2c39ea1cf705959126f32c0b31604f7327f97f704c5c7ece3cd6785352
    
    ➜  megoldas docker ps
    CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                    NAMES
    09486d2c39ea        ccc3355680d5        "/usr/bin/java -jar …"   24 seconds ago      Up 23 seconds       0.0.0.0:8081->8081/tcp   nervous_elion
    
 A böngészőt megnyitva, a http://localhost:8081-es porton az alkalmazásunk fog megjelenni.
 
 Leállítás
 
    ➜  megoldas docker stop nervous_elion
    nervous_elion