package com.pojo;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonArrayPojoObject 
{
	@Test
	public void createEmployeeJsonArrayObjet() throws JsonProcessingException
	{
		//create first employee
		Employee emp1=new Employee();
		
		emp1.setFirstName("Taanu");
		emp1.setLastName("Manish");
		emp1.setGender("Female");
		emp1.setAge(23);
		emp1.setSalary(50000);
		
		//create second employee
		 Employee emp2=new Employee();
		 
		 emp2.setFirstName("Taanya");
		 emp2.setLastName("Mansih");
		 emp2.setGender("Female");
		 emp2.setAge(23);
		 emp2.setSalary(600000);
		 
		 
		//create third employee
		 Employee emp3=new Employee();
		 
		 emp3.setFirstName("Thrishank");
		 emp3.setLastName("Mansih");
		 emp3.setGender("Female");
		 emp3.setAge(23);
		 emp3.setSalary(7800000);
		 
		 //create list of employe
		 
		 List<Employee> listOfEmp=new ArrayList<Employee>();
		 
		 listOfEmp.add(emp1);
		 listOfEmp.add(emp2);
		 listOfEmp.add(emp3);
		 
		 //convert employee class object to json array paylod(Serializaton=>class object to Json object)
		 
		 ObjectMapper objectmapper=new ObjectMapper();
		 
		 String jsonArraypayload=objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(listOfEmp);
		 
		 System.out.println("Employee class object to json array object");
		 System.out.println(jsonArraypayload);
		 
		 //create HTTp request
		 RequestSpecification reqRes=RestAssured.given();
		 
		 //specify the URI
		// reqRes.baseUri("https://reqres.in/api/users");//201
		 reqRes.baseUri("https://httpbin.org/post");//200
		 
		 reqRes.contentType(ContentType.JSON);
		 reqRes.body(jsonArraypayload);
		 
		 Response response =reqRes.post();
		 
		 System.out.println("*****************************ResponseBody*****************");
		 
		 response.prettyPrint();
		 
		 Assert.assertEquals(response.getStatusCode(), 200,"Status code is not matching ");
		 
		 
		 //Covert Json Array payload to clas object(employee array object)
	}
}
