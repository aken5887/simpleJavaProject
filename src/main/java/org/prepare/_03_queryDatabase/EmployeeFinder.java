package org.prepare._03_queryDatabase;

import com.sun.jna.platform.win32.COM.EnumMoniker;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class EmployeeFinder {
    final String PATH = "src/main/java/org/prepare/_03_queryDatabase";
    public static void main(String[] args) {
        EmployeeFinder finder = new EmployeeFinder();
        String[] properties = finder.getConnectionProperty();
        String query = finder.makeQuery();
        List<Employee> list = finder.getQueryResult(properties, query);
        finder.makeQueryResultAsText(list);
    }

    private void makeQueryResultAsText(List<Employee> list){
        File file = new File(PATH+"/query.txt");
        try(FileWriter writer = new FileWriter(file)){
            writer.write(new Employee().toStringHeadArr());
            if(!list.isEmpty()){
                for(Employee e:list){
                    writer.write(e.toString());
                }
            } else {
                writer.write("결과가 없습니다.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Employee> getQueryResult(String[] properties, String query) {
        List<Employee> result = new ArrayList<>();

        try{
            Class.forName("org.mariadb.jdbc.Driver");
            try(Connection conn = DriverManager.getConnection(properties[0], properties[1], properties[2]);
                PreparedStatement pst = conn.prepareStatement(query);
                ResultSet rs = pst.executeQuery();){
                while(rs.next()){
                    result.add(new Employee(rs));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public String makeQuery(){
        StringBuilder queryBuilder = new StringBuilder();
        // SELECT 문 추가
        queryBuilder.append("SELECT\n")
                .append("e.emp_no,\n")
                .append("e.first_name,\n")
                .append("e.last_name,\n")
                .append("e.gender,\n")
                .append("e.hire_date,\n")
                .append("d.dept_name,\n")
                .append("t.title,\n")
                .append("MAX(s.salary) OVER(PARTITION BY e.emp_no) AS max_salary\n");

        // FROM 절 추가
        queryBuilder.append("FROM\n")
                .append("employees e\n")
                .append("JOIN dept_emp de ON e.emp_no = de.emp_no\n")
                .append("JOIN departments d ON de.dept_no = d.dept_no\n")
                .append("JOIN titles t ON e.emp_no = t.emp_no\n")
                .append("JOIN salaries s ON e.emp_no = s.emp_no\n");

        // WHERE 절 추가
        queryBuilder.append("WHERE\n")
                .append("e.hire_date >= DATE_FORMAT('2000-01-01', '%y-%m-%d')\n");

        // GROUP BY 절 추가
        queryBuilder.append("GROUP BY e.emp_no;");

        return queryBuilder.toString();
    }

    private String[] getConnectionProperty(){

        String[] info = new String[3];
        try(FileReader fileReader = new FileReader(PATH+"/db.properties");
            BufferedReader bf = new BufferedReader(fileReader)){
            String line = "";
            int index = 0;
            while((line = bf.readLine()) != null){
                info[index++] = line.split(" ")[1];
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return info;
    }
}
