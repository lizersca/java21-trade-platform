# java21-trade-platform
A high-concurrency, event-driven trading platform built with Java 21 and Kafka to demonstrate modern distributed systems, virtual threads, resilience patterns, and production-grade observability.

## Features

* Java 21 Virtual Threads
* Event-Driven Architecture
* Apache Kafka
* Distributed Microservices
* OpenTelemetry Tracing
* Prometheus & Grafana Monitoring
* Retry Topics & Dead Letter Queues
* Testcontainers Integration Testing
* High-Concurrency Load Testing

## Architecture

```text
Client
  |
  v
Gateway
  |
  v
orders.raw
  |
  v
Validation
  |
  v
orders.validated
  |
  +-------> Risk
  |
  +-------> Fraud
              |
              v
          Decision
              |
              v
      orders.completed
              |
              v
         Persistence
```

## Tech Stack

* Java 21
* Spring Boot
* Apache Kafka
* PostgreSQL
* Docker Compose
* OpenTelemetry
* Prometheus
* Grafana
* Testcontainers

## Goals

This project explores:

* High-throughput event processing
* Kafka-based system design
* Modern Java concurrency
* Observability and tracing
* Fault tolerance and recovery
* Performance engineering

## Running Locally

```bash
mvn clean package
docker compose up
```

## Documentation

Additional architecture diagrams, ADRs, benchmarks, and design decisions are available in the `/docs` directory.
