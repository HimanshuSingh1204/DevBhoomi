# Explore Uttarakhand

A production-ready travel platform for exploring Uttarakhand, built with Spring Boot and React.

## Features

- User authentication with JWT
- Places management with categories
- Video sharing and social features (likes, comments)
- Reviews and ratings
- Budget planner
- Travel packages
- Google Maps integration for route planning
- Admin dashboard
- Cloudinary for media uploads

## Tech Stack

### Backend
- Spring Boot 3.1.0
- Spring Security + JWT
- MySQL + JPA/Hibernate
- Cloudinary for media uploads
- Google Maps API
- Swagger for API docs

### Frontend
- React 18 + Vite
- Tailwind CSS
- Redux Toolkit
- React Router
- Google Maps React

## Setup Instructions

### Prerequisites
- Java 17
- Maven
- Node.js
- MySQL

### Backend Setup
1. Clone the repository
2. Navigate to `backend` directory
3. Copy `.env.example` to `.env` and fill in your values
4. Update `application.properties` with your database and API credentials
5. Run `mvn spring-boot:run`

### Frontend Setup
1. Navigate to `frontend` directory
2. Copy `.env.example` to `.env` and fill in your values
3. Run `npm install`
4. Run `npm run dev`

### Database
- Create a MySQL database named `explore_uttarakhand`
- Tables will be auto-created via JPA

## API Documentation

Available at `http://localhost:8080/swagger-ui.html` (if Swagger is added)

## Sample Data

To populate sample places, you can add them via admin panel or directly in DB.

Example places:
- Nainital (Hill Station, 29.3919, 79.4542)
- Mussoorie (Hill Station, 30.4598, 78.0644)
- Rishikesh (Spiritual, 30.0869, 78.2676)

## Environment Variables

### Backend
- `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`
- `JWT_SECRET`
- `CLOUDINARY_CLOUD_NAME`, `CLOUDINARY_API_KEY`, `CLOUDINARY_API_SECRET`
- `GOOGLE_MAPS_API_KEY`

### Frontend
- `REACT_APP_API_BASE_URL` (for production)
- Google Maps API key in component

## Deployment

### Database Setup
1. Create a MySQL database on Railway or PlanetScale
2. Note the connection details (URL, username, password)

### Backend Deployment (Render)
1. Go to [Render](https://render.com)
2. Connect your GitHub repository
3. Create a new Web Service
4. Select Java runtime
5. Set build command: `mvn clean package -DskipTests`
6. Set start command: `java -jar target/explore-uttarakhand-0.0.1-SNAPSHOT.jar`
7. Add environment variables:
   - `DB_URL`: Your database URL
   - `DB_USERNAME`: Database username
   - `DB_PASSWORD`: Database password
   - `JWT_SECRET`: Random secret string
   - `CLOUDINARY_CLOUD_NAME`, `CLOUDINARY_API_KEY`, `CLOUDINARY_API_SECRET`
   - `GOOGLE_MAPS_API_KEY`

### Frontend Deployment (Vercel)
1. Go to [Vercel](https://vercel.com)
2. Connect your GitHub repository
3. Select the `frontend` directory
4. Deploy
5. Update `api.js` base URL to your backend URL

### Alternative: Docker Deployment
- Backend has Dockerfile for containerized deployment
- Use Docker Hub or any container registry