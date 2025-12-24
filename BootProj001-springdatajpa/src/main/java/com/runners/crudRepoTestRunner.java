package com.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.entity.Employee;
import com.service.empMgmtService;

@Component
public class crudRepoTestRunner implements CommandLineRunner {

    @Autowired
    private empMgmtService empservice;

    @Override
    public void run(String... args) throws Exception {

        // SavingEmp
    	
  	
        Employee emp = new Employee();
        emp.setEmpname("Sakic");
        emp.setDesgniation("dataeng");
        emp.setIncome(782376.00);

        Employee savedEmp = empservice.registerEmp(emp);
        System.out.println("Saved Employee: " + savedEmp);
       
        
      // GET GENERATED ID 
        Integer id = savedEmp.getEmp_id();
        System.out.println("Generated ID:" + id);

        //  count
       // System.out.println("Employee Count:" + empservice.fetchlongcount());

        //  CHECK ID EXIST ornot
        // System.out.println("Is ID available:" + empservice.checkempAvaliabity(id));

     /*    // showall
        System.out.println("---- All Employees ----");
        empservice.showAllEmployees().forEach(System.out::println);
     */
        
        // find all by id
      
       /*
        List<Integer> ids = List.of(1, 2, 52);
        System.out.println("---- Employees By IDs ----");
        empservice.showAllByEmployeeIds(ids).forEach(System.out::println);
       */
        
        
        
        //  SAVE ALL
        
        /*
        List<Employee> empList = List.of(
                new Employee(null, "prasad12", "ARCH", 1245.00),
                new Employee(null, "crisworth", "football", 3456.00)
        );

        empservice.saveAllByIds(empList)
                  .forEach(e -> System.out.println("Saved: " + e));
        
        */
        

        //  FIND BY ID 
      /*  Optional<Employee> opt = empservice.empFindBYId(id);

        if (opt.isPresent()) {
            System.out.println("EMP FOUND");
            System.out.println(opt.get());
        } else {
            System.out.println("INVALID ID :: " + id);
        }
       */
        
        //deletebyID
    /*  System.out.println("EMPDEleted" +empservice.deleteBYID(1));
      
      Employee em = new Employee();
      em.setEmp_id(2);
      em.setDesgniation("hr");
      em.setEmpname("amara");
      em.setIncome(45656.00);
      System.out.println(((empMgmtService) empservice).deleteEMPloyee(em));
     */ 
      
      
        Iterable<Employee> emit = empservice.getEmployeeSortedBySalary("income","empname");
           
        emit.forEach(System.out::println);
         
        
        
        Page<Employee> page = empservice.getEmployeesortedandInPages(1, 40, true, "income");
        
        page.getContent().forEach(System.out::println);
      
    }

}
