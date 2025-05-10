
public class frameworkdemo {

}
/*   **Advanced Selenium Automation Framework - Company-Level Implementation**

---

# **1. Introduction**
This document details the implementation of an advanced Selenium automation framework incorporating:
- Data-Driven Testing (Apache POI for Excel)
- API Validation (Rest Assured)
- Parallel Execution (TestNG.xml)
- Extent Reports (Detailed HTML Reporting)
- Dockerized Selenium Grid (Cross-Browser Execution)
- Jenkins & Git Integration (CI/CD)

---

# **2. Project Dependencies (Maven - pom.xml)**
```xml
<dependencies>
    <!-- Selenium Java -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.10.0</version>
    </dependency>

    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.6.1</version>
        <scope>test</scope>
    </dependency>

    <!-- Apache POI for Excel -->
    <dependency>
        <groupId>org.apache.poi</groupId>
        <artifactId>poi-ooxml</artifactId>
        <version>5.2.3</version>
    </dependency>

    <!-- RestAssured for API Testing -->
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.4.0</version>
    </dependency>

    <!-- Extent Reports -->
    <dependency>
        <groupId>com.aventstack</groupId>
        <artifactId>extentreports</artifactId>
        <version>5.0.9</version>
    </dependency>
</dependencies>
```

---

# **3. Data-Driven Testing with Apache POI**

## **Excel File (TestData.xlsx)**
| First Name | Last Name | Employee ID |
|------------|------------|------------|
| John       | Doe       | 1001       |
| Alice      | Smith     | 1002       |
| Bob        | Williams  | 1003       |

### **Excel Reader Utility**
```java
package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    private static final String FILE_PATH = "path/to/TestData.xlsx";

    public static Object[][] getEmployeeData(String sheetName) {
        Object[][] data = null;
        try (FileInputStream file = new FileInputStream(FILE_PATH);
             Workbook workbook = new XSSFWorkbook(file)) {
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getLastCellNum();
            data = new Object[rowCount - 1][colCount];
            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    data[i - 1][j] = cell.toString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
```

---

# **4. API Validation using Rest Assured**
```java
package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiValidation {
    private static final String BASE_URL = "https://api.orangehrm.com/";

    public static void verifyEmployeeExists(String employeeId) {
        RestAssured.baseURI = BASE_URL;
        Response response = given()
                .header("Authorization", "Bearer YOUR_ACCESS_TOKEN")
                .when()
                .get("employees/" + employeeId)
                .then()
                .statusCode(200)
                .body("data.id", equalTo(employeeId))
                .extract().response();
        System.out.println("API Validation Response: " + response.asPrettyString());
    }
}
```

---

# **5. Parallel Execution in TestNG.xml**
```xml
<suite name="HRMS Test Suite" parallel="tests" thread-count="2">
    <test name="Chrome Tests">
        <parameter name="browser" value="chrome"/>
        <classes>
            <class name="tests.AddEmployeeTest"/>
        </classes>
    </test>
    <test name="Firefox Tests">
        <parameter name="browser" value="firefox"/>
        <classes>
            <class name="tests.AddEmployeeTest"/>
        </classes>
    </test>
</suite>
```

---

# **6. Dockerized Selenium Grid**
```yaml
version: "3"
services:
  selenium-hub:
    image: selenium/hub:4.1.0
    container_name: selenium-hub
    ports:
      - "4444:4444"

  chrome-node:
    image: selenium/node-chrome:4.1.0
    container_name: chrome-node
    depends_on:
      - selenium-hub
    environment:
      - SE_EVENT_BUS_HOST=selenium-hub
      - SE_EVENT_BUS_PUBLISH_PORT=4442
      - SE_EVENT_BUS_SUBSCRIBE_PORT=4443

  firefox-node:
    image: selenium/node-firefox:4.1.0
    container_name: firefox-node
    depends_on:
      - selenium-hub
    environment:
      - SE_EVENT_BUS_HOST=selenium-hub
      - SE_EVENT_BUS_PUBLISH_PORT=4442
      - SE_EVENT_BUS_SUBSCRIBE_PORT=4443
```

---

# **7. CI/CD Integration (Jenkins & GitHub)**
### **Jenkins Setup**
1. Install `Maven` & `Git` in Jenkins (`Manage Jenkins` → `Global Tool Configuration`).
2. Create a new **Freestyle Project** in Jenkins.
3. In **Source Code Management**, select `Git` and provide the repository URL.
4. In the **Build** section, add the command:
   ```sh
   mvn clean test
   ```
5. Save and **Run the Job**.
6. Install **TestNG Results Plugin** for report visualization.

---

# **8. Summary**

| **Feature**         | **Technology Used** |
|---------------------|--------------------|
| **Test Execution**  | TestNG Parallel Execution |
| **Data-Driven**     | Apache POI (Excel) |
| **API Validation**  | Rest Assured |
| **Reports**        | Extent Reports |
| **CI/CD**          | Jenkins & Git |
| **Cross-Browser**  | Selenium Grid with Docker |

---

🚀 **This framework is now scalable, automated, and CI/CD integrated!**  


*/




