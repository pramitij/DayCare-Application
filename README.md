Full Stack Application - Daycare Hub
> Designed a Java Application for Daycare System. The primary aim wasn’t just to craft a solution for daycare management but to gain hands-on experience with full-stack development. We applied the Factory design pattern for the registration system, MVC design pattern for reminder system, and JavaMail API to send email notifications.

## Features

- **Parent-Teacher Communication:** A secure and private channel for updates, sharing milestones, and scheduling meetings.
- **Attendance Tracking:** Effortless check-in and check-out for children, with real-time updates sent to parents.
- **Event Calendar:** Comprehensive scheduling tool for planning and notifying about upcoming events, activities, and closures.
- **Photo and Video Sharing:** A dedicated space for teachers to share moments from the day, allowing parents to feel connected to their child's daily experiences.
- **Health and Safety Updates:** Immediate notifications regarding health checks, meal times, and incident reports.

## Technical Overview
The application is built on a robust stack that ensures reliability, scalability, and security:

- Frontend: React Native for a responsive, cross-platform user experience.
- Backend: Node.js with Express for efficient server management and API handling.
- Database: MongoDB for flexible, document-oriented data storage.
- Authentication: Integrated OAuth for secure login processes.
- Cloud Storage: AWS S3 for storing and retrieving media files securely.

## Setup and Installation
Getting "BrightStart Daycare Hub" up and running is straightforward. Here are the steps to follow:

1. Clone the Repository

    ``` sh
    git clone https://github.com/YourGitHub/BrightStart-Daycare-Hub.git

2. Install Dependencies: Navigate to the project directory and install the required packages


    ``` sh
    npm install

3. Configure Environment Variables: Set up your `.env` file with the necessary API keys and database URLs as detailed in the `.env.example` file.

4. Run the Application: To start the server:
    ``` sh
   npm start

5. To launch the React Native app:
    ``` sh
    npm run android // For Android
    npm run ios // For iOS

