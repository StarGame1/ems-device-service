# README

This microservice manages devices and their assignment to users.

## Startup

- Local (Maven):
  - Build and run: mvnw spring-boot:run
- In Docker:
  - Build the JAR: mvnw -DskipTests package
  - Build and start with Docker Compose docker-compose up --build

## Main APIs

Base endpoint: /api/devices

- GET /api/devices

  - Description: Get all devices.

- GET /api/devices/{id}

  - Description: Get a device by ID.

- GET /api/devices/user/{id}

  - Description: Get all devices assigned to a specific user.

- POST /api/devices

  - Description: Create a new device.
  - Body (JSON):
    - `name`: string (required)
    - `maxConsumption`: double (required)
    - `userId`: long (optional)

- PUT /api/devices/{deviceId}/assign/{userId}

  - Description: Assign a device to a user.

- PUT /api/devices/{deviceId}/unassign
  - Description: Unassign a device from a user.

## Internal notes

- Relevant entities:
  - `Device` with fields `id`, `name`, `maxConsumption`, `userId`.
  - `UserSnapshot` with fields `id`, `username`, `role`.
- Controller: `DeviceController` exposes the device management endpoints.
- Service: `DeviceService` contains device CRUD and assignment logic.

## DTO examples

- Device :

```json
{
  "id": 1,
  "name": "Smart Thermostat",
  "maxConsumption": 500.0,
  "userId": 1
}
```

- UserSnapshot :

```json
{
  "id": 1,
  "username": "alice",
  "role": "CLIENT"
}
```

## Database and Docker

- The project uses PostgreSQL
- Default application port: 8083

## Quick test

1. Start the database with Docker Compose :
   docker-compose up -d postgres-device-db
2. Build and run locally with Maven:
   mvnw spring-boot:run
3. Test endpoints with curl or Postman:
   - Get all devices: GET http://localhost:8083/api/devices
   - Create device: POST http://localhost:8083/api/devices
