package edu.neu.csye6200BE;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBBasicConnection {
	private static CreateConnection cnct = new CreateConnection();
	private static Connection a = cnct.makeConnection();
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	
	public void addStudent(String studentName, int age, String fatherName, String motherName, String address, String phone, int teacherId ) {
		try {
			Statement statmentAddStudents = a.createStatement();
			statmentAddStudents.executeUpdate("INSERT INTO student(studentname,age,fathername,mothername,address,phone,teacherid) VALUES ('"+studentName+"',"+age+",'"+fatherName+"','"+motherName+"','"+address+"','"+phone+"',"+teacherId+");");
			LOGGER.log(Level.INFO, "New Student Added");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addTeacher(String teacherName, int credit, int sectionId, int catergory) {
		try {
			Statement statmentAddStudents = a.createStatement();
			statmentAddStudents.executeUpdate("INSERT INTO teacher(name,credit,sectionid,catergory) values ('"+teacherName+"',"+credit+","+sectionId+","+catergory+")");
			LOGGER.log(Level.INFO, "New Teacher Added");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<String[]> showStudentsList() {
		List<String[]> StudentRoster = new ArrayList<>();
		String[] tempStorage = new String[7];
		try {
			Statement statmentShowStudentList = a.createStatement();
			ResultSet resultStdAll = statmentShowStudentList.executeQuery("SELECT s.studentname,s.age,s.fathername,s.mothername,s.address,s.phone,t.teachername,s.doj FROM teacher t INNER JOIN student s ON t.teacherid = s.teacherid");
			while (resultStdAll.next()) {
			    String stdName = resultStdAll.getString("studentname");
			    int age = resultStdAll.getInt("age");
			    String fatherName = resultStdAll.getString("fathername");
			    String motherName = resultStdAll.getString("mothername");
			    String address = resultStdAll.getString("address");
			    String phone = resultStdAll.getString("phone");
			    String teacherName = resultStdAll.getString("teachername");
			    tempStorage[0] = stdName;
			    tempStorage[1] = String.valueOf(age);
			    tempStorage[2] = fatherName;
			    tempStorage[3] = motherName;
			    tempStorage[4] = address;
			    tempStorage[5] = phone;
			    tempStorage[6] = teacherName;
			    StudentRoster.add(tempStorage);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return StudentRoster;
	}
	
	public List<String[]> showTeachersList() {
		List<String[]> teacherList = new ArrayList<>();
		String[] tempStorageTeacher = new String[4];
		try {
			Statement statmentShowTeacherList = a.createStatement();
			ResultSet resultTeachAll = statmentShowTeacherList.executeQuery("SELECT t.teachername, t.credit, c.classname, t.catergory FROM teacher t INNER JOIN classroom c on t.sectionid = c.clsid");
			while (resultTeachAll.next()) {
			    String teachName = resultTeachAll.getString("teachername");
			    int credit = resultTeachAll.getInt("credit");
			    String sectionId = resultTeachAll.getString("classname");
			    int catergory = resultTeachAll.getInt("catergory");
			    tempStorageTeacher[0] = teachName;
			    tempStorageTeacher[1] = String.valueOf(credit);
			    tempStorageTeacher[2] = sectionId;
			    tempStorageTeacher[3] = String.valueOf(catergory);
			    teacherList.add(tempStorageTeacher); 
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return teacherList;
	}
	
//	public void showTeachersWithAnnualReview() {
//		Statement statementShowARTeacher;
//		try {
//			statementShowARTeacher = a.createStatement();
//			ResultSet resultTAR = statementShowARTeacher.executeQuery(null);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	public List<String[]> getVaccinationDetails(int studentId) {
		List<String[]> vaccinationDetails = new ArrayList<>();
		String[] tempStorage = new String[4];
		try {
			Statement statementVD = a.createStatement();
			ResultSet resultvdStudent = statementVD.executeQuery("SELECT v.vaccinationname, v.doseno, v.datetaken, t.studentname from immunizations v inner join student t on v.studentid = t.studentid where v.studentid="+studentId+";");
			while(resultvdStudent.next()) {
				String vaccinationname = resultvdStudent.getString("vaccinationname");
				String doseno = String.valueOf(resultvdStudent.getInt("doseno"));
				String dateTaken = String.valueOf(resultvdStudent.getDate("datetaken"));
				String studentName = resultvdStudent.getString("studentname");
				tempStorage[0] = studentName;
				tempStorage[1] = vaccinationname;
				tempStorage[2] = doseno;
				tempStorage[3] = dateTaken;
				vaccinationDetails.add(tempStorage);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		for (String[] t : vaccinationDetails) {
			System.out.println(Arrays.toString(t));
		}
		return vaccinationDetails;
	}
	
	public List<String[]> getvaccDetailsOfStudent(int studentId) {
		List<String[]> vaccinationDetails = new ArrayList<>();
		List<String> summa = new ArrayList<>();
		String[] tempStorage = new String[3];
		try {
			Statement statementVDStud = a.createStatement();
			ResultSet resultStudentVD = statementVDStud.executeQuery("SELECT vaccinationname, doseno, datetaken FROM immunizations where studentid ="+studentId);
			int i = 0;
			while(resultStudentVD.next()) {
				String vaccName = resultStudentVD.getString("vaccinationname");
				String doseNos = String.valueOf(resultStudentVD.getInt("doseno"));
				String dateTaken = String.valueOf(resultStudentVD.getDate("datetaken"));
//				System.out.println("itr "+i);
//				System.out.println(vaccName+" "+doseNos+" "+dateTaken);
				tempStorage[0] = vaccName;
				tempStorage[1] = doseNos;
				tempStorage[2] = dateTaken;
//				System.out.println(Arrays.toString(tempStorage));
				System.out.println("In iteration "+i+" - "+Arrays.toString(tempStorage));
				vaccinationDetails.add(i, tempStorage);
				i=i+1;
//				Arrays.fill(tempStorage, null);
				
//				vaccinationDetails.add(tempStorage);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vaccinationDetails;
	}
	
	public static void Demo() throws SQLException {
		System.out.println("----- Database connection class ------");
			DBBasicConnection dbc = new DBBasicConnection();
//			dbc.getVaccinationDetails(3);
			// returns ArrayList of students
//			List<String[]> abcd = dbc.showStudentsList();
//			// returns ArrayList of teachers 
//			List<String[]> defg = dbc.showTeachersList();
			// returns list of vaccine based on studentid
//			List<String[]> kiju = dbc.getVaccinationDetails(3);
//			dbc.addStudent("Ashwin", 3, "Bazz", "ash", "190 highland street", "1434567890", 1);
//			dbc.addTeacher("Ashwin", 8, 1, 2);
//			dbc.showStudentsList();
//			dbc.showTeachersList();
//			System.out.println(abcd.get(0).toString());
			
//			for (String[] a : abcd) {
//				System.out.println(Arrays.toString(a));
//			}
//			for (String[] b : defg) {
//				System.out.println(Arrays.toString(b));
//			}
//			System.out.println(Arrays.toString(defg.get(0)));
//			List<String[]> lkm = dbc.getVaccinationDetails(3);
//			System.out.println(Arrays.toString(lkm.get(0)));
//			System.out.println(Arrays.toString(lkm.get(1)));
//			for (String[] k : lkm) {
//				System.out.println(Arrays.toString(k));
//			}
//			int v = kiju.size();
//			for(int i = 0; i < v; i++) {
//				System.out.println(Arrays.toString(kiju.get(i)));
//			}
			List<String[]> pop = dbc.getvaccDetailsOfStudent(3);
			System.out.println(Arrays.toString(pop.get(0)));
			System.out.println(Arrays.toString(pop.get(1)));
//			dbc.getVaccinationDetails(3);
			
			a.close();
	}
}
