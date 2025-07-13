Liste des dépendances Maven utilisées et liens de téléchargement JAR
1. Spring Boot Starter Web
GroupId: org.springframework.boot

ArtifactId: spring-boot-starter-web

Version: 3.0.5 (exemple)

Lien Maven Central:
https://search.maven.org/artifact/org.springframework.boot/spring-boot-starter-web/3.0.5/jar

2. Spring Boot Starter Data JPA
GroupId: org.springframework.boot

ArtifactId: spring-boot-starter-data-jpa

Version: 3.0.5

Lien Maven Central:
https://search.maven.org/artifact/org.springframework.boot/spring-boot-starter-data-jpa/3.0.5/jar

3. PostgreSQL JDBC Driver
GroupId: org.postgresql

ArtifactId: postgresql

Version: 42.5.1

Lien Maven Central:
https://search.maven.org/artifact/org.postgresql/postgresql/42.5.1/jar

4. Lombok
GroupId: org.projectlombok

ArtifactId: lombok

Version: 1.18.26

Lien Maven Central:
https://search.maven.org/artifact/org.projectlombok/lombok/1.18.26/jar

5. JSON Web Token (JWT) - JJWT
jjwt-api

GroupId: io.jsonwebtoken

ArtifactId: jjwt-api

Version: 0.11.5

Lien: https://search.maven.org/artifact/io.jsonwebtoken/jjwt-api/0.11.5/jar

jjwt-impl

GroupId: io.jsonwebtoken

ArtifactId: jjwt-impl

Version: 0.11.5

Lien: https://search.maven.org/artifact/io.jsonwebtoken/jjwt-impl/0.11.5/jar

jjwt-jackson

GroupId: io.jsonwebtoken

ArtifactId: jjwt-jackson

Version: 0.11.5

Lien: https://search.maven.org/artifact/io.jsonwebtoken/jjwt-jackson/0.11.5/jar

6. iText 7 PDF Core
GroupId: com.itextpdf

ArtifactId: itext7-core

Version: 7.2.5

Lien Maven Central:
https://search.maven.org/artifact/com.itextpdf/itext7-core/7.2.5/jar

Pour les ressources frontend manquantes
CSS : Tailwind CSS utilisé, tu peux télécharger Tailwind stable ici :
https://cdn.jsdelivr.net/npm/tailwindcss@3.3.2/dist/tailwind.min.css

Images : Je te conseille d’optimiser les images (jpeg/png compressés). Si tu veux, je peux te générer un ZIP avec toutes les images et fichiers statiques.

Tu peux exécuter ce script dans PostgreSQL via :

psql -U postgres -d hbr_db -f chemin_vers_script.sql