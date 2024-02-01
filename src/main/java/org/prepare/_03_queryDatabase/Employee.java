package org.prepare._03_queryDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {
    private String empNO;
    private String firstName;
    private String lastName;
    private String gender;
    private String hireDate;
    private String deptName;
    private String title;
    private String maxSalary;

    private String[] headArr
            = new String[]{"emp_no", "first_name", "last_name", "gender", "hire_date", "dept_name", "title","max_salary"};

    /**
     * ResultSet을 입력받아 Employee 객체를 생성
     * @param rs
     * @throws SQLException
     */
    public Employee(ResultSet rs) throws SQLException {
        this.empNO = rs.getString(this.headArr[0]);
        this.firstName = rs.getString(this.headArr[1]);
        this.lastName = rs.getString(this.headArr[2]);
        this.gender = rs.getString(this.headArr[3]);
        this.hireDate = rs.getString(this.headArr[4]);
        this.deptName = rs.getString(this.headArr[5]);
        this.title = rs.getString(this.headArr[6]);
        this.maxSalary = rs.getString(this.headArr[7]);
    }

    public Employee() {}

    public String toStringHeadArr(){
        StringBuilder sb = new StringBuilder();
        for(String s:this.headArr){
            sb.append(s).append(" ");
        }
        sb.append("\n");
        return sb.toString();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.empNO).append(" ");
        sb.append(this.firstName).append(" ");
        sb.append(this.lastName).append(" ");
        sb.append(this.gender).append(" ");
        sb.append(this.hireDate).append(" ");
        sb.append(this.deptName).append(" ");
        sb.append(this.title).append(" ");
        sb.append(this.maxSalary).append(" \n");
        return sb.toString();
    }
}
