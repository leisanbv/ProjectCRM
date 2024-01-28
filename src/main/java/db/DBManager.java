package db;

import constants.Constants;
import entity.Discipline;
import entity.Mark;
import entity.Student;
import entity.Term;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    public static List<Student> getAllActiveStudents(){
        ArrayList<Student> students = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student where status = '1'");

            while(rs.next()){
                Student st = new Student();
                st.setId(rs.getInt("id"));
                st.setSurname(rs.getString("surname"));
                st.setName(rs.getString("name"));
                st.setGroup(rs.getString("groupe"));
                st.setDate(rs.getDate("date"));
                students.add(st);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }


    public static void createStudent(String surname, String name, String group, String date){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO `student` (`surname`, `name`, `groupe`, `date`) VALUES ('"+surname+"', '"+name+"', '"+group+"', '"+date+"');");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void deleteStudent(String id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `student` SET `status` = '0' WHERE (`id` = '"+id+"');");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static Student getStudentById(String id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student where status = '1' AND id = " + id);

            while(rs.next()){
                Student st = new Student();
                st.setId(rs.getInt("id"));
                st.setSurname(rs.getString("surname"));
                st.setName(rs.getString("name"));
                st.setGroup(rs.getString("groupe"));
                st.setDate(rs.getDate("date"));
                return st;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void modifyStudent(String id, String surname, String name, String group, String dateToDB) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `student` SET `surname` = '"+surname+"', `name` = '"+name+"', `groupe` = '"+group+"', `date` = '"+dateToDB+"' WHERE (`id` = '"+id+"');");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<Discipline> getAllActiveDisciplines(){
        ArrayList<Discipline> disciplines = new ArrayList<>();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM discipline where status = '1'");

            while (rs.next()){
                Discipline dc = new Discipline();
                dc.setId(rs.getInt("id"));
                dc.setDiscipline(rs.getString("discipline"));
                disciplines.add(dc);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return disciplines;
    }

    public static void createDiscipline(String nameOfDiscipline){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO `discipline` (`discipline`) VALUES ('"+nameOfDiscipline+"');");


        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteDiscipline(String id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `discipline` SET `status` = '0' WHERE (`id` = '"+id+"')");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static Discipline getDisciplineById(String id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM discipline where status = '1' AND id = " + id);

            while(rs.next()){
                Discipline dc = new Discipline();
                dc.setId(rs.getInt("id"));
                dc.setDiscipline(rs.getString("discipline"));
                return dc;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void modifyDiscipline(String id, String nameDc) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `discipline` SET `discipline` = '"+nameDc+"' WHERE (`id` = '"+id+"');");

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static Term getTermById(String id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM term where status = '1' AND id = " + id);

            while(rs.next()){
                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setName_of_term(rs.getString("name_of_term"));
                term.setDuration(rs.getString("duration"));
                return term;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static boolean canLogin(String login, String password, String role){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user_role as ur\n" +
                    "left join user as u on ur.id_user = u.id\n" +
                    "where ur.id_role = "+role+" and u.login = '"+login+"' and u.password = '"+password+"'");

            while(rs.next()){
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public static List<Term> getAllActiveTerms(){
        ArrayList<Term> terms = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM term where status = '1'");

            while(rs.next()){
                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setName_of_term(rs.getString("name_of_term"));
                terms.add(term);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return terms;
    }


    public static List<Mark> getMarksByStudentAndTerm(String idStudent, int idTerm){
        ArrayList<Mark> marks = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT d.id, d.discipline, m.mark FROM mark as m\n" +
                    "left join term_discipline as td on m.id_term_discipline = td.id\n" +
                    "left join discipline as d on td.id_discipline = d.id\n" +
                    "where m.id_student = "+idStudent+" and td.id_term = " + idTerm);

            while(rs.next()){
                Mark mark = new Mark();
                mark.setMark(rs.getInt("mark"));
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDiscipline(rs.getString("discipline"));
                mark.setDiscipline(discipline);

                marks.add(mark);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return marks;
    }
}