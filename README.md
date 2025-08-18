2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Access the application at:
   ```
   http://localhost:8080
   ```

## API Endpoints
### 1. **Generate Receipt**
   - **URL**: `/getReceipt/print`
   - **Method**: `POST`
   - **Request Body**:
     ```json
     [
       "item1",
       "item2"
     ]
     ```
   - **Response**:
     ```json
     {
       "items": [
         {
           "name": "item1",
           "price": 10.00,
           "tax": 1.00
         }
       ],
       "total": 11.00
     }
     ```

## Configuration
Update the `application.properties` or `application.yml` file for custom configurations:
