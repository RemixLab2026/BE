# Spring Boot Skeleton / Template for Any Project

This is a Spring Boot project skeleton containing only the minimal configurations.  
No business logic is included, making it suitable as a starting point for new projects.

---

## 1. Configuration Overview

- **JPA**: Spring Data JPA
    - `spring.jpa.hibernate.ddl-auto = none`
    - `spring.jpa.open-in-view = false`
    - Default batch fetch size and other basic settings included
- **JSON**: Jackson
    - Configurations for safe serialization of lazy-loaded entities
- **QueryDSL**: Type-safe query framework for JPA
  - Used for complex and dynamic JPA queries
  - Custom repositories implemented using `JPAQueryFactory`
  - Explicit fetch strategies applied for `open-in-view = false`
  - Q classes are generated under `src/main/generated`
- **YML-based Settings**: Profiles, groups, and logging
    - `spring.profiles.group` used for environment grouping
    - `decorator.datasource.exclude-beans` applied for multi-datasource control
- **Logging**: Fine-grained logging level configuration per package
- **Excluded Integrations**: Spring Cloud, Feign, Redis (can be added later if needed)
- **Monitoring**: Micrometer-based metrics for application performance
Can be integrated with Prometheus, Grafana, or other monitoring tools
Collects metrics such as JVM memory, request counts, response times, etc.
---

## 2. Progress / Changelog

| Date       | Description |
|------------|-------------|
| 2026-01-24 | Initial skeleton setup with YML configurations |
| 2026-01-27 | Add BaseEntity with common audit fields |
| 2026-01-28 | Add Swagger,Querydsl Configuration and Common Enum Serialization and Conversion Support |
| 2026-01-29 | Add JPA Converter for enum and boolean types |
| 2026-01-30 | Add base enum and interface for API success/failure messages |
| 2026-01-31 | Add CustomException with ExceptionHandler , Common ApiResult Response |


---

## 3. Getting Started (Optional)

1. Clone the project:
```bash
git clone https://github.com/KangWooJu/SpringDefaultSettings
