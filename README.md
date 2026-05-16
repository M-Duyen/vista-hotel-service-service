# service-service

Standalone Spring Boot module for the hotel service catalog.

## Scope
- CRUD service catalog
- Search by availability
- Search by service name
- Search by service category
- No ORM relation to booking domain

## Run
From this folder:

```powershell
$env:JAVA_HOME='C:\Program Files\Java\jdk-21'
$env:Path="$env:JAVA_HOME\bin;$env:Path"
.\mvnw.cmd test
.\mvnw.cmd spring-boot:run
```

If you want to use the existing MariaDB database, keep the datasource settings in `src/main/resources/application.properties`.

## Database setup

Create database `servicedb` before running the service:

```sql
CREATE DATABASE IF NOT EXISTS servicedb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

The app uses `jdbc:mariadb://localhost:3306/servicedb` and auto-seeds fake catalog data on startup when the table is empty.
You can disable seeding with:

```ini
app.seed.enabled=false
```

The module exposes the same catalog routes as the monolith:
- `GET /services`
- `GET /services/{id}`
- `POST /services`
- `DELETE /services/{id}`
- `GET /services/availability?availability=true|false`
- `GET /services/name?serviceName=...`
- `GET /services/category?serviceCategory=...`

