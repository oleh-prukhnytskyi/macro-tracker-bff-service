# BFF Service (Backend for Frontend)

[**← Back to Main Architecture**](https://github.com/oleh-prukhnytskyi/macro-tracker)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Reactive](https://img.shields.io/badge/reactive-%23326ce5.svg?style=for-the-badge&logo=reactivex&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

---

[![License](https://img.shields.io/badge/license-Apache%202.0-blue?style=for-the-badge)](LICENSE)
[![Swagger](https://img.shields.io/badge/Swagger-API_Docs-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)](https://macrotracker.uk/webjars/swagger-ui/index.html?urls.primaryName=bff-service)
[![Docker Hub](https://img.shields.io/badge/Docker%20Hub-Image-blue?style=for-the-badge&logo=docker)](https://hub.docker.com/repository/docker/olehprukhnytskyi/macro-tracker-bff-service/general)

**Aggregator service optimized for frontend performance.**

Implements the **Backend for Frontend (BFF)** pattern to orchestrate calls between downstream microservices and provide a unified, aggregated response to the client.

## :zap: Service Specifics

* **Reactive & Non-Blocking**: Built on **Spring WebFlux** and **Project Reactor** (Netty) to handle high concurrency with minimal resource usage.
* **Data Aggregation**: Parallelizes HTTP requests to downstream services (User Service, Intake Service) using `Mono.zip` to reduce overall latency.
* **Reduced Round-Trips**: Combines multiple data sources (e.g., User Goals + Daily Intakes) into a single `DashboardDto` response, preventing "over-fetching" and "under-fetching" on the client side.
* **Error Propagation**: Gracefully handles upstream service failures, wrapping them into standardized exceptions.

---

## :electric_plug: API & Communication

* **Public API**: Exposes endpoints for the Dashboard and aggregated data views.
* **Upstream Services**:
    * **User Service**: Fetches user profile and nutrition goals.
    * **Intake Service**: Fetches daily food intake records.

---

## :hammer_and_wrench: Tech Details

| Component         | Implementation                              |
|:------------------|:--------------------------------------------|
| **Framework**     | Spring Boot 3 (WebFlux)                     |
| **HTTP Client**   | Reactive `WebClient`                        |
| **Async Logic**   | Project Reactor (`Mono`, `Flux`)            |
| **API Docs**      | SpringDoc OpenAPI (Swagger)                 |
| **Serialization** | Jackson (Custom `BigDecimal` serialization) |

---

## :gear: Environment Variables

Required variables for `local` or `k8s` deployment:

| Variable              | Purpose                                                                  |
|:----------------------|:-------------------------------------------------------------------------|
| **Upstream Services** |                                                                          |
| `USER_SERVICE_URL`    | Base URL of the **User Service** (e.g., `http://user-service:8080`).     |
| `INTAKE_SERVICE_URL`  | Base URL of the **Intake Service** (e.g., `http://intake-service:8080`). |
| **Infrastructure**    |                                                                          |
| `MACRO_TRACKER_URL`   | Public URL of the application (used for Swagger UI configuration).       |

---

## :whale: Quick Start

```bash
# Pull from Docker Hub
docker pull olehprukhnytskyi/macro-tracker-bff-service:latest

# Run (Ensure your .env file contains all required variables)
docker run -p 8080:8080 --env-file .env olehprukhnytskyi/macro-tracker-bff-service:latest
```

---

## :balance_scale: License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.