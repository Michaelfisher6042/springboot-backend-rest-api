package net.employee_managment.springboot.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.employee_managment.springboot.controller.EmployeeController;
import net.employee_managment.springboot.model.Address;
import net.employee_managment.springboot.model.Employee;
import net.employee_managment.springboot.model.GeneralDetails;
import net.employee_managment.springboot.model.Spouse;
import net.employee_managment.springboot.service.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class)
public class Tester {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeService employeeService;
    @MockBean
    private AddressService addressService;
    @MockBean
    private ChildService childService;
    @MockBean
    private GeneralDetailsService generalDetailsService;
    @MockBean
    private SpouseService spouseService;

    private List<Employee> employeeList;
    private Employee employee;
    private String serviceUri;

    @Autowired
    private ObjectMapper mapper;
    private String jsonEmployeeList;
    private String jsonEmployee;


    @Before
    public void setup() throws JsonProcessingException {
        employee = new Employee(10L,
                new GeneralDetails(2L,"BBB","CEO","A@B"),
                new Spouse(1L,"AA","FEMALE"),
                null,
                null);


        employeeList = Arrays.asList( new Employee(10L,
                new GeneralDetails(2L,"BBB","CEO","A@B"),
                new Spouse(1L,"AA","FEMALE"),
                null,
                null));



        serviceUri = "/api/employees/";
        jsonEmployeeList = mapper.writeValueAsString(employeeList);
        jsonEmployee = mapper.writeValueAsString(employeeList);
    }

    @Test
    public void getAllEmployees() throws Exception {
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employeeList);

        mockMvc.perform(get(serviceUri))
                .andExpect(content().json(jsonEmployeeList))
                .andExpect(status().isOk());

        Mockito.verify(employeeService).getAllEmployees();
    }

    @Test
    public void getEmployeeById() throws Exception {
        //employee = Arrays.asList(employee);
        //Assert.assertEquals(employee.toString(), jsonEmployee.toString());
        Mockito.when(employeeService.getEmployeeById(10L)).thenReturn(new Employee(10L));

        mockMvc.perform(get(serviceUri + "10", 10L))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Mockito.verify(employeeService).getEmployeeById(10L);
    }

    @Test
    public void createEmployee() throws Exception {
        List<Address>addresses = new ArrayList<>();
        addresses.add(new Address("aaaa"));
        Employee employee = new Employee(10L,
                new GeneralDetails(2L,"BBB","CEO","A@B"),
                new Spouse(1L,"AA","FEMALE"),
                addresses,
                null);
            // studentService.addCourse to respond back with mockCourse
        jsonEmployee = mapper.writeValueAsString(employee);
        Mockito.when(employeeService.saveEmployee(employee)).thenReturn(employee);

            // Send course as body to /students/Student1/courses
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                    .post(serviceUri)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(jsonEmployee)
                    .contentType(MediaType.APPLICATION_JSON);
        System.out.println(requestBuilder);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

    }

    @Test
    public void updateEmployee() throws Exception {

        List<Address>addresses = new ArrayList<>();
        addresses.add(new Address("aaaa"));
        Employee employee = new Employee(10L,
                new GeneralDetails(2L,"BBB","CEO","A@B"),
                new Spouse(1L,"AA","FEMALE"),
                addresses,
                null);
        Mockito.when(employeeService.getEmployeeById(employee.getId())).thenReturn(employee);
        Mockito.when(employeeService.saveEmployee(employee)).thenReturn(employee);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(employee));

        mockMvc.perform(mockRequest)
                .andExpect(status().isCreated());
    }
    

    @Test
    public void deleteEmployee() throws Exception {
        mockMvc.perform(delete(serviceUri + "10", 10L))
                .andExpect(status().isNoContent());
        Mockito.verify(employeeService).deleteEmployee(10L);
    }
    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}