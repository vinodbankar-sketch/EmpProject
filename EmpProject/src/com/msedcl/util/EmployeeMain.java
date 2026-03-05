package com.msedcl.util;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.msedcl.util.Employee;

public class EmployeeMain {

	
	public static void main(String[] args) {
	Employee emp1 = new Employee(1,"Swapnil Jadhav", 75000, "ERP");
	Employee emp2 = new Employee(2,"Pratibha Nannaware", 80000, "IT");
	Employee emp3 = new Employee(3,"Rajshri Deshmukh", 35000, "IT");
	Employee emp4 = new Employee(4,"Sneha Nalawade", 35000, "IT");
	Employee emp5 = new Employee(5,"Rajendra Bhoyar", 50000, "IT");
	List<Employee> employeeList= Arrays.asList(emp1, emp2, emp3, emp4, emp5);
	
	//printEmpWithSalarygreaterthan50kPredicate()
	System.out.println("-------------List of Emp with salary > 50k--------------------");
	//printEmpWithSalarygreaterthan50kPredicate(employeeList, (emp) -> emp.);
	printEmpWithSalarygreaterthan50kPredicate(employeeList, (p) -> p.getSalary()>50000);
	

	System.out.println("-------------List of Emp From IT dept--------------------");
	//printEmpWithSalarygreaterthan50kPredicate(employeeList, (emp) -> emp.);
	printEmpWithDeptPredicate(employeeList, (p) -> p.getDepartment().equals("IT"));
	
	
	System.out.println("-------------Print  Emp from Consumer--------------------");
	printConditionallyConsumer(employeeList, (p) ->true, (p) -> System.out.println(p.toString()));
	
	
	System.out.println("-------------printTotalWithSalarygreaterthan50kPredicate--------------------");
	printTotalWithSalarygreaterthan50kPredicate(employeeList, (p) -> p.getSalary()>50000);
	
	
	}
	
	//printConditionallyConsumer(people, (p) -> p.getLastName().startsWith("N"), (p) -> System.out.println(p.getLastName()));
	
	
	
	public static void printEmpWithSalarygreaterthan50kPredicate(List<Employee> employeeList, Predicate<Employee> predicate)
	{
		for(Employee emp : employeeList)
		{
			if (predicate.test(emp))
			{
				System.out.println(emp);
			}
		}
		
	}
	
	public static void printTotalWithSalarygreaterthan50kPredicate(List<Employee> employeeList, Predicate<Employee> predicate)
	{
		int total_salary=0;
		for(Employee emp : employeeList)
		{
			if (predicate.test(emp))
			{
				total_salary= total_salary+emp.getSalary();
				//System.out.println(emp);
			}
		}
		System.out.println(total_salary);
		
	}
	
	public static void printEmpWithDeptPredicate(List<Employee> employeeList, Predicate<Employee> predicate)
	{
		for(Employee emp : employeeList)
		{
			if (predicate.test(emp))
			{
				System.out.println(emp);
			}
		}
		
	}
	
	public static void printConditionallyConsumer(List<Employee> employeeList, Predicate<Employee> predicate,Consumer<Employee> consumer)
	{
		for(Employee person : employeeList)
		{
			if (predicate.test(person))
			{
				consumer.accept(person);
			}
		}
		
	}

}
