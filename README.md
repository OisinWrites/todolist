java -jar target/todolist-0.0.1-SNAPSHOT.jar (replaces mvn spring-boot:run)

Spring Boot is set up, controller messages are showing in development port

Tailwind CSS
- npm init -y
start new node.js project, node.js needs to be installed
- npm install tailwindcss postcss autoprefixer
Configure Tailwind:
Create a tailwind.config.js file: - npx tailwindcss init
Create a postcss.config.js file
Create a src/main/resources/static/css/tailwind.css file
Add a build script in package.json:
- npm run build:css
in index.html <link href="/css/main.css" rel="stylesheet">
