Tutoriel d'installation complet du logiciel HBR (Backend + Frontend)
Prérequis
Java JDK 17+ installé (compatible Spring Boot 3.x)

Maven 3.6+ installé

PostgreSQL 14+ installé et en service

Un navigateur web moderne (Chrome, Firefox)

Serveur Apache ou Nginx si tu veux déployer le frontend via un serveur web

Étape 1 : Installer Java JDK 17+
Vérifie si Java est installé :

bash
Copier
Modifier
java -version
Si pas installé, télécharge-le ici :

Adoptium Temurin JDK 17 LTS

Installe-le selon ton OS et configure la variable d’environnement JAVA_HOME.

Étape 2 : Installer Maven
Vérifie la version :

bash
Copier
Modifier
mvn -version
Sinon télécharge et installe Maven 3.6+ depuis :

https://maven.apache.org/download.cgi

Ajoute mvn au PATH.

Étape 3 : Installer PostgreSQL
Télécharge et installe PostgreSQL stable (14 ou 15) :

https://www.postgresql.org/download/

Configure PostgreSQL :

Crée un utilisateur postgres avec un mot de passe fort

Crée une base de données hbr_db

sql
Copier
Modifier
CREATE DATABASE hbr_db;
CREATE USER postgres WITH PASSWORD 'admin';
GRANT ALL PRIVILEGES ON DATABASE hbr_db TO postgres;
Étape 4 : Configurer le projet Backend
4.1 Récupère le code source backend (ZIP ou git clone)
4.2 Ouvre le fichier src/main/resources/application.properties et adapte :
properties
Copier
Modifier
spring.datasource.url=jdbc:postgresql://localhost:5432/hbr_db
spring.datasource.username=postgres
spring.datasource.password=admin

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Limites upload fichiers (photos, documents)
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
Étape 5 : Vérifier le fichier pom.xml
Utilise ces versions stables minimales :

xml
Copier
Modifier
<properties>
    <java.version>17</java.version>
    <spring.boot.version>3.0.5</spring.boot.version>
</properties>

<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <version>${spring.boot.version}</version>
    </dependency>

    <!-- Spring Boot Starter Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
        <version>${spring.boot.version}</version>
    </dependency>

    <!-- PostgreSQL Driver -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.5.1</version>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.26</version>
        <scope>provided</scope>
    </dependency>

    <!-- JWT (optionnel) -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-api</artifactId>
        <version>0.11.5</version>
    </dependency>

    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-impl</artifactId>
        <version>0.11.5</version>
        <scope>runtime</scope>
    </dependency>

    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-jackson</artifactId>
        <version>0.11.5</version>
        <scope>runtime</scope>
    </dependency>

    <!-- IText PDF -->
    <dependency>
        <groupId>com.itextpdf</groupId>
        <artifactId>itext7-core</artifactId>
        <version>7.2.5</version>
    </dependency>
</dependencies>
Étape 6 : Lancer le backend
Depuis la racine du projet backend, lance :

bash
Copier
Modifier
./mvnw clean package
./mvnw spring-boot:run
Ou

bash
Copier
Modifier
mvn clean package
mvn spring-boot:run
Si tout va bien tu dois voir :

scss
Copier
Modifier
Started Application in XX seconds
Tomcat started on port(s): 8080
Étape 7 : Tester le backend
Ouvre un navigateur ou Postman et teste :

http://localhost:8080/api/clients

http://localhost:8080/api/auth/login (POST)

http://localhost:8080/api/impression/facture/1 (PDF facture)

Étape 8 : Installer et configurer le frontend
8.1 Copier les fichiers frontend (HTML, JS, CSS) dans un dossier
Exemple :

css
Copier
Modifier
/var/www/html/hbr
8.2 Si Apache/Nginx installé, configure un virtual host vers ce dossier.
Exemple Apache :

apache
Copier
Modifier
<VirtualHost *:80>
    ServerName hbr.local
    DocumentRoot /var/www/html/hbr
    <Directory /var/www/html/hbr>
        Options Indexes FollowSymLinks
        AllowOverride None
        Require all granted
    </Directory>
</VirtualHost>
N'oublie pas d'ajouter dans /etc/hosts :

lua
Copier
Modifier
127.0.0.1 hbr.local
Étape 9 : Tester le frontend
Ouvre dans le navigateur http://localhost/hbr ou http://hbr.local

Connecte-toi avec un utilisateur existant

Teste CRUD clients, produits, réservations, factures...

Teste upload d’image, impression PDF, recherche, pagination

Conseils pour éviter les blocages
Évite les add-apt-repository ou PPA sous Linux, utilise les dépôts officiels ou manuels

Télécharge et installe manuellement les JDK/Maven/PostgreSQL si besoin

Vérifie bien les variables d’environnement (JAVA_HOME, PATH)

Si Maven bloque sur certains plugins, exécute avec -U pour forcer la mise à jour :

bash
Copier
Modifier
mvn clean install -U
Utilise la version stable et recommandée de PostgreSQL (évite beta ou RC)

Pour les fichiers statiques frontend, un simple serveur Apache ou même python -m http.server local peut suffire pour tester