java -jar target/todolist-0.0.1-SNAPSHOT.jar (replaces mvn spring-boot:run)

Spring Boot is set up, controller messages are showing in development port

Tailwind CSS
- npm init -y
start new node.js project, node.js needs to be installed
- npm install tailwindcss postcss autoprefixer
Configure Tailwind:
at dir root:
    Create a tailwind.config.js file: - npx tailwindcss init
    Create a postcss.config.js file
Create a src/main/resources/static/css/tailwind.css file
Add a build script in package.json:
- npm run build:css
in index.html <link href="/css/main.css" rel="stylesheet">


MySQl
Add dependency to pom.xml

Apache
Catalina and Java env var path's set on system


We've created a Java project with spring boot, included the set up for tailwind css for styling, we've set up our mysql database and deployed through apache

Apache tomcat and maven installed.
war file executed instead of spring boot run as with jar above
java -jar target/todolist-0.0.1-SNAPSHOT.war

trying to set up hotswap
java -javaagent:"C:\Program Files\JetBrains\jdk-17\lib\hotswap\hotswap-agent.jar" -XX:HotswapAgent=fatjar -jar target/todolist-0.0.1-SNAPSHOT.war



Step-by-Step Plan
Define the Data Model
Set Up the Repository Layer
Create the Service Layer
Develop the Controller Layer
Create Views (HTML + Tailwind CSS)
Add Functionality for CRUD Operations
Testing the Application
Deploy the Application

adding Thymeleaf view resolver to map return name for HTML files

(https://medium.com/javarevisited/jdk-17-with-dcevm-and-hotswapagent-4fee7095617a)


3 days trying to get spring boot to run. Pressing F5 and allowing permissions fixed everything

LiveReload extension for chrome:
https://chromewebstore.google.com/detail/livereload/jnihajbhpnppcggbcgedagnkighmdlei
spring.devtools.restart.enabled=true
spring.devtools.livereload.enabled=true

Add start dependency to pom file: devtools

Add heroku's free db jawsdb: heroku addons:create jawsdb:kitefin -a {appname}