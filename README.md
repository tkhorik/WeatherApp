# WeatherApp - Spring MVC Weather Application

This is a web-based weather application developed using Spring MVC, integrated with the [OpenWeatherMap API](https://openweathermap.org/api) to fetch and display real-time weather data. The app allows users to check current weather conditions, forecasts, and other meteorological details for locations worldwide by leveraging the API's robust dataset.

## Features

- Retrieve real-time weather information based on user input (e.g., city name or coordinates).
- Display key weather metrics such as temperature, humidity, wind speed, and conditions.
- Clean and responsive UI built with Spring MVC and modern web technologies.
- Seamless integration with the OpenWeatherMap API for accurate and up-to-date data.

## Tech Stack

- **Backend**: Spring MVC (Java)
- **API**: OpenWeatherMap API
- **Frontend**: HTML, CSS, JavaScript (optional: add specific frameworks like Bootstrap or Thymeleaf if used)
- **Build Tool**: Maven (or Gradle, depending on your setup)

## Prerequisites

- Java 11+ installed
- OpenWeatherMap API key (sign up at [https://openweathermap.org/api](https://openweathermap.org/api) to obtain one)
- Maven (or Gradle) for dependency management

## Setup Instructions

1. Clone the repository: `git clone https://github.com/tkhorik/WeatherApp.git`
2. Add your OpenWeatherMap API key in the configuration file (e.g., `application.properties`).
3. Run `mvn install` to build the project.
4. Start the application using your IDE or `mvn spring-boot:run`.
5. Access the app at `http://localhost:8080`.

## Contributing

Feel free to submit issues or pull requests to enhance functionality, improve the UI, or fix bugs!

## License

This project is licensed under the [MIT License](LICENSE).
