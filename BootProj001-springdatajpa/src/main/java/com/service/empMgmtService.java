package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.entity.Employee;
import com.reposistory.IEmpRepo;

@Service("empService")
public class empMgmtService implements IEmpService {

    @Autowired
    private IEmpRepo emprep;

    @Override
    public Employee registerEmp(Employee emp) {

        System.out.println("Before Save, empId = " + emp.getEmp_id());

        Employee saved = emprep.save(emp);

        return saved;
    }

	@Override
	public long fetchlongcount() {
		// TODO Auto-generated method stub
		return emprep.count();
	}

	@Override
	public boolean checkempAvaliabity(Integer emp_id) {
		// TODO Auto-generated method stub
		return emprep.existsById(emp_id);
	}

	@Override
	public Iterable<Employee> showAllEmployees() {
		// TODO Auto-generated method stub
		return emprep.findAll();
	}

	@Override
	public Iterable<Employee> showAllByEmployeeIds(Iterable<Integer>ids) {
		// TODO Auto-generated method stub
		return emprep.findAllById(ids);
	}

	@Override
	public Iterable<Employee> saveAllByIds(Iterable<Employee> emp) {
		// TODO Auto-generated method stub
		return emprep.saveAll(emp);
	}

	@Override
	public Optional<Employee> empFindBYId(Integer id) {
		// TODO Auto-generated method stub
		return emprep.findById(id);
	}

	@Override
	public String deleteBYID(Integer id) {
		// TODO Auto-generated method stub
		Optional<Employee> opemp= emprep.findById(id);
		 
		if(opemp.isPresent())
		{
			emprep.deleteById(id);
			return id+"empisdeleted";
		}
		else
		{
			return id+"Empnotfoundfordeletion";
		}
	}

	@Override
	public String deleteEMPloyee(Employee epee) {
		// TODO Auto-generated method stub
		Optional<Employee>opm = emprep.findById(epee.getEmp_id());
		
		
		if(opm.isEmpty())
		{
			return epee.getEmp_id()+"empisnotfound";
		}
		else
		{
			emprep.delete(opm.get());
			return epee.getEmp_id()+"EMpfoundanddeleted";
		}
	}

	@Override
	public Iterable<Employee> getEmployeeSortedBySalary(String...args) {
		// TODO Auto-generated method stub
		Sort s2t = Sort.by(Sort.DEFAULT_DIRECTION.DESC,args);
		Iterable<Employee> ito = emprep.findAll(s2t);
		return ito;
		
	}

	@Override
	public Page<Employee> getEmployeesortedandInPages(int pgno, int pgsize, boolean ascOrder, String... args) {
		// TODO Auto-generated method stub
		Sort srt = Sort.by(ascOrder?Direction.ASC:Direction.DESC,args);
		
		Pageable pa = PageRequest.of(pgno, pgsize,srt);
		
		Page<Employee> pg = emprep.findAll(pa);
		 return pg;
		
		
	}

	

	

}
