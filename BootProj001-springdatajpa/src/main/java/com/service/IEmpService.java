package com.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.entity.Employee;

public interface IEmpService {
	
	public Employee registerEmp(Employee emp);
	
	public  long fetchlongcount();
	
	public boolean checkempAvaliabity(Integer emp_id);
     
	public Iterable <Employee> showAllEmployees();

	 public Iterable<Employee> showAllByEmployeeIds(Iterable<Integer> ids);
	 
	 
	 public Iterable<Employee> saveAllByIds(Iterable<Employee> emp);
	 
	 public Optional<Employee> empFindBYId(Integer id);
	 
	 public String deleteBYID(Integer id);
	 
	 public String deleteEMPloyee(Employee epee);
	 
	 public Iterable<Employee> getEmployeeSortedBySalary(String...args);
	 
	 public Page<Employee> getEmployeesortedandInPages(int pgno, int pgsize, boolean ascOrder,String...args);
}
