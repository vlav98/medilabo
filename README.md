Medilabo Solutions Project
---
### Context

The medilabo solutions application aims to revolutionize the early detection and prevention of type 2 diabetes. 
By leveraging cutting-edge technology and advanced algorithms, we will provide healthcare providers with a powerful tool to accurately assess patient risk and implement timely interventions.

#### Key Features 

- **Comprehensive Patient Data Management**: Our application will securely store and manage patient information, including medical history, vital signs, and risk factors.
- **Advanced Risk Assessment**: Utilizing sophisticated algorithms and machine learning techniques, we will develop a robust diabetes risk assessment model that can accurately predict a patient's likelihood of developing type 2 diabetes.
- **Personalized Recommendations**: Based on the risk assessment, our application will provide tailored recommendations to patients, including lifestyle changes, dietary adjustments, and medication options.
- **Integration with Existing Systems**: Our application will seamlessly integrate with existing healthcare systems, ensuring a smooth workflow for healthcare providers.

#### Technical Approach:

- **Microservices Architecture**: We will employ a microservices architecture to enhance scalability, maintainability, and flexibility.
- **Cloud-Based Deployment**: The application will be deployed on a cloud platform, ensuring high availability and easy scalability.
- **Modern Technologies**: We will leverage modern technologies such as Spring Boot, Spring Cloud, and Docker to build a robust and efficient application.

#### Benefits for Healthcare Providers:

- **Early Detection**: Our application will enable early detection of type 2 diabetes, allowing for timely interventions and improved patient outcomes.
- **Improved Patient Management**: By providing personalized recommendations, our application will help healthcare providers manage patient care more effectively.
- **Enhanced Efficiency**: Our cloud-based solution will streamline workflows and reduce administrative burdens.

### Microservices

- Patients
- Notes
- Risk Report
- Front-End

### Run the app

#### Set KEYCLOAK ADMIN PASSWORD

To set the KEYCLOAK ADMIN PASSWORD you have to put : `export KEYCLOAK_ADMIN_PASSWORD=admin`

To set the IP Address : `export IPADDRESS=$(ipconfig getifaddr en0)`

To start the app, you can use : `docker compose up --build -d`

To stop the app, you can use: `docker compose down`

### Credentials


### Green Code

Green code is a software development approach that focuses on minimizing the environmental impact of computer applications throughout their lifecycle. It involves writing code in a way that reduces energy consumption, optimizes resource usage, and limits the impact on the environment.

#### Key aspects of green code:

- **Resource optimization**: Writing concise and efficient code to reduce unnecessary calculations and memory usage, choosing optimized algorithms, and minimizing database or external service calls.
- **Energy impact**: Selecting energy-efficient programming languages, frameworks, and infrastructure, optimizing server configuration, and using renewable energy sources for data centers.
- **Carbon footprint reduction**: Choosing eco-responsible hosting providers, developing long-lasting and maintainable software, and reducing the energy consumption of user devices.
