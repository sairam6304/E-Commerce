# Product Microservice

The **Product Microservice** is responsible for managing product-related operations such as creating, updating, retrieving, and deleting product information in a distributed system. It exposes RESTful APIs and can be integrated into a larger microservices architecture (e.g., for e-commerce platforms).

## Features

- CRUD operations for products
- Product search/filtering
- RESTful API design
- Database integration
- Error handling and validation

## Tech Stack

- **Language:  *  Java 
- **Framework: *Spring Boot
- **Database: MySQL 
- **API Docs:** Swagger
- **Containerization:** Docker
- **Authentication:** JWT / OAuth2 

## Getting Started

### Prerequisites

  Java ≥ 21 
- (MySQL) running locally 
- Docker 

### Installation

1. **Clone the repository:**
    ```bash
    git clone https://github.com/your-org/product-microservice.git
    cd product-microservice
    ```

2. **Install dependencies:**
    ```bash
    npm install
    # or
    pip install -r requirements.txt
    ```

3. **Configure environment variables:**  
   Copy ` .env.example` to `.env` and set appropriate values for database connection, ports, etc.

4. **Run the service:**
    ```bash
    npm start
    # or
    python app.py
    ```

### API Endpoints

| Method | Endpoint             | Description           |
|--------|---------------------|-----------------------|
| GET    | `/products`         | Get all products      |
| GET    | `/products/{id}`    | Get product by ID     |
| POST   | `/products`         | Create a new product  |
| PUT    | `/products/{id}`    | Update product by ID  |
| DELETE | `/products/{id}`    | Delete product by ID  |

*Refer to the [API documentation](./docs/api.yaml) for detailed request and response formats.*

### Example Product Object

```json
{
  "id": "abc123",
  "name": "Sample Product",
  "description": "A short description.",
  "price": 19.99,
  "stock": 100,
  "category": "Electronics"
}
```

## Running with Docker

```bash
docker build -t product-microservice.
docker run -p 3000:3000 --env-file .env product-microservice
```

## Testing

```bash
npm test
# or
pytest
```

## Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change.

## License

[MIT](LICENSE)

---

*For questions or support, please contact [your-email@example.com](mailto:your-email@example.com).*
