// Java Program to Illustrate Application CLass
// To Create The Menu For the Program

// Importing required classes
import java.util.Scanner;

// Class
public class Library {

	// Main driver method
	public static void main(String[] args) {
		// Creating object of Scanner class
		// to take input from user
		Scanner input = new Scanner(System.in);

		// Displaying menu
		System.out.println(
				"********************Welcome to the Library!********************");
		System.out.println(
				"				 Select From The Following Options:			 ");
		System.out.println(
				"**********************************************************************");

		// Creating object of book class
		books ob = books.getInstance();
		// Creating object of students class
		students obStudent = new students();

		int choice;
		int searchChoice;

		// Creating menu
		// using do-while loop
		do {
			ob.dispMenu();
			choice = input.nextInt();

			// Switch case
			switch (choice) {

				// Case
				case 1:
					System.out.println(" Press 1 to add a book.");
					System.out.println(" Press 2 to add a magazine.");
					searchChoice = input.nextInt();
					switch (searchChoice) {
						case 1:
							System.out.println(
									" Press 1 to add a book that is an illustrated edition.");
							System.out.println(
									" Press 2 to add a book that is an education edition.");
							System.out.println(
									" Press 3 to add a normal book.");
							searchChoice = input.nextInt();

							// Nested switch
							switch (searchChoice) {
								case 1:
									ReadingMaterial a = new IllustratedEdition(new book());
									ob.addBook(a);
									break;

								case 2:
									ReadingMaterial b = new EducationalEdition(new book());
									ob.addBook(b);
									break;

								case 3:
									ReadingMaterial c = new book();
									ob.addBook(c);
									break;
							}
							break;
						case 2:
							ReadingMaterial c = new magazine();
							ob.addBook(c);
							break;

					}

					break;

				// Case
				case 2:
					ob.upgradeBookQty();
					break;

				// Case
				case 3:
					ReadingMaterial c = new book();
					ob.deleteBook(c);
					break;

				// Case
				case 4:
					ob.showAllBooks();
					break;

				// Case
				case 5:
					student s = new student();
					obStudent.addStudent(s);
					break;

				// Case
				case 6:
					obStudent.showAllStudents();
					break;

				// Case
				case 7:
					obStudent.checkOutBook(ob);
					break;

				// Case
				case 8:
					obStudent.checkInBook(ob);
					break;

				// Case
				case 9:
					System.out.println(
							" Press 1 to search a book by the author name.");
					System.out.println(
							" Press 2 to search a book by the book name.");

					searchChoice = input.nextInt();
					switch (searchChoice) {
						case 1:
							System.out.println("Enter Author Name:");
							ob.setSearchBookStrategy(new SearchByAuthorNameStrategy());
							ob.find();
							break;
						case 2:
							System.out.println("Enter Book Name:");
							ob.setSearchBookStrategy(new SearchByBookNameStrategy());
							ob.find();
							break;
					}
					break;

				// Default case that will execute for sure
				// if above cases does not match
				default:

					// Print statement
					System.out.println("ENTER BETWEEN 0 TO 8.");
			}

		}

		// Checking condition at last where we are
		// checking case entered value is not zero
		while (choice != 0);
	}
}

