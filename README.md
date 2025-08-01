# Golf Club API

## Supported Search API Endpoints

### Members

- **Search by Name**
  - `GET /members/search?name=John`
- **Search by Membership Type:**
  - `GET /members/search?type=Regular`
  - `GET /members/search?type=Premium`
- **Search by Phone Number:**
  - `GET /members/search?phone=555-1234`
- **Search Members in Tournaments by Start Date:**
  - `GET /members/by-tournament?startDate=2024-08-01`

### Tournaments

- **Search by Start Date:**
  - `GET /tournaments/search?startDate=2024-08-01`
- **Search by Location:**
  - `GET /tournaments/search?location=Golf Club`
- **Get All Members in a Tournament:**
  - `GET /tournaments/{id}/members`

## How to Run Project in Docker

1. **Build the project JAR:**  
   -in your project folder:
   ```bash
   mvn clean package
