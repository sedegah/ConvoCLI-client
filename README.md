ConvoCLI client

Build a fat jar:
  mvn package

Usage:
  java -jar target/convocli-client-0.1.0.jar signup --server http://localhost:8080 --username alice --password secret
  java -jar target/convocli-client-0.1.0.jar login  --server http://localhost:8080 --username alice --password secret
  java -jar target/convocli-client-0.1.0.jar send --to bob --message "Hello Bob!"
  java -jar target/convocli-client-0.1.0.jar inbox --with bob
