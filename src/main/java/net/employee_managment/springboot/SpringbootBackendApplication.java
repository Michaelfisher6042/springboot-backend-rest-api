package net.employee_managment.springboot;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableSwagger2
@Aspect
public class SpringbootBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootBackendApplication.class, args);
//		Employee e = new Employee(1L,new GeneralDetails("A","WORKER","A@B"),new Spouse("C","man","C@E"));
//		System.out.println(e.toString());
	}
	@Around("execution(* net.employee_managment.springboot.service.EmployeeService*.*(..))")
	public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object retVal = joinPoint.proceed();
		stopWatch.stop();
		System.out.println(" execution time: " + stopWatch.getTotalTimeMillis() + " ms");
		return retVal;
	}

}
