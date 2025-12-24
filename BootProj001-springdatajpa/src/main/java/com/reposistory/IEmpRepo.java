package com.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Employee;

public interface IEmpRepo extends JpaRepository<Employee, Integer> {

}
