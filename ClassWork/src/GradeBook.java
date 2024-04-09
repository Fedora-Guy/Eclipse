import java.util.Scanner;

public class GradeBook {
	
	//STUFF HERE
	private int numberOfStudents;
	private int numberOfQuizzes;
	
	private int[][] grade; //numberOfStudent rows and numberOfQuizzes columns
	
	private double[] studentAverage;
	private double[] quizAverage;
	
	// Constructor (1 parameter)
	public GradeBook(int[][] a) {
		if(a.length == 0 || a[0].length == 0) {
			System.out.println("ERROR -- Empty grade records. Aborting");
			System.exit(0);
		}
		numberOfStudents = a.length;
		numberOfQuizzes = a[0].length;
		fillGrade(a);
		fillStudentAverage();
		fillQuizAverage();
		
	}
	
	//default constructor
	public GradeBook() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter # of students: ");
		numberOfStudents = s.nextInt();
		System.out.println("Enter # of quizzes: ");
		numberOfQuizzes = s.nextInt();
		
		//initializing grade to be an empty array of size Students Quizzes
		grade = new int[numberOfStudents][numberOfQuizzes];
		for(int studentNumber = 0; studentNumber < numberOfStudents; studentNumber++) {
			for(int quizNumber = 0; quizNumber < numberOfQuizzes; quizNumber++) {
				System.out.print("Enter a score for student number: " + studentNumber);
				System.out.println(" for quiz number " + quizNumber);
				grade[studentNumber][quizNumber] = s.nextInt();
			}
		}
		s.close();
		
	}
	
	private void fillGrade(int[][] a) {
		for(int studentNumber = 0; studentNumber < numberOfStudents; studentNumber++) {
			for(int quizNumber = 0; quizNumber < numberOfQuizzes; quizNumber++) {
				grade[studentNumber][quizNumber] = a[studentNumber][quizNumber];
			}
		}
	}
	
	private void fillStudentAverage() {
		studentAverage = new double[numberOfStudents];
		for(int studentNumber = 0; studentNumber < numberOfStudents; studentNumber++) {
			double sum = 0;
			for(int quizNumber = 0; quizNumber < numberOfQuizzes; quizNumber++) {
				
				sum += grade[studentNumber][quizNumber];
			}
			studentAverage[studentNumber] = sum / numberOfQuizzes;
		}
	}
	
	private void fillQuizAverage() {
		//array of avgs for the col values of a specific row
		quizAverage = new double[numberOfQuizzes];
		for(int quizNumber = 0; quizNumber < numberOfQuizzes; quizNumber++) {
			//process a single quiz
			double sum = 0;
			for(int studentNumber = 0; studentNumber < numberOfStudents; studentNumber++) {
				
				sum += grade[studentNumber][quizNumber];
			}
			quizAverage[quizNumber] = sum / numberOfStudents;
		}
	}
	
	public void display() {
		for(int studentNumber = 0; studentNumber < numberOfStudents; studentNumber++) {
			System.out.print("Student " + studentNumber + " Quizzes: ");
			for(int quizNumber = 0; quizNumber < numberOfQuizzes; quizNumber++) {
				System.out.print(grade[studentNumber][quizNumber] + " ");
			}
		}
	}

	
}
