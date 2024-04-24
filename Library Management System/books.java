// Java Program to Illustrate books class
// To Do all the Operations related to Books such as
// add, check-in, check-out,Valid books,Update books

// Importing required classes
import java.util.Scanner;

// CLass
//Strategy Pattern
interface SearchBookStrategy{
	String[][] searchBook(String name,int count, ReadingMaterial[] theBooks);
}

class SearchByAuthorNameStrategy implements SearchBookStrategy{
	@Override
	public String[][] searchBook(String authorName,int count, ReadingMaterial[] theBooks){
		int flag = 0;
		//
		String[][] data = new String[count][6];
		for  (int i = 0; i < count; i++) {
			
			//
			// current book name
			String cAuthorName =  theBooks[i].getAuthorName();

			cAuthorName = cAuthorName.toLowerCase();
			authorName = authorName.toLowerCase();

			int index = cAuthorName.indexOf(authorName);
			while (index != -1) {
				String subStr = cAuthorName.substring(index, index + authorName.length());
				// 
				if (subStr.equals(authorName)) {
					data[i][0] = Integer.toString(theBooks[i].getSNo());
					data[i][1] = theBooks[i].getBookName();
					data[i][2] = theBooks[i].getAuthorName();
					data[i][3] = theBooks[i].getBooktype();
					data[i][4] = Integer.toString(theBooks[i].getBookQtyCopy());
					data[i][5] = Integer.toString(theBooks[i].getBookQty());

					flag++;
					break;
				}else{
					cAuthorName.substring(index+1);
					index = cAuthorName.indexOf(authorName);
				}
			}

		}
		//

		// Else no book matches for author
		if (flag == 0){
			System.out.println("No Books of " + authorName+ " Found.");
			data = null;
		}
			

		return data;
		
	}
}

class SearchByBookNameStrategy implements SearchBookStrategy{
	@Override
	public String[][] searchBook(String bookName, int count, ReadingMaterial[] theBooks){
		int flag = 0;
		//
		String[][] data = new String[count][6];
		for (int i = 0; i < count; i++) {
			// current book name
			String cBookName =  theBooks[i].getBookName();

			cBookName = cBookName.toLowerCase();
			bookName = bookName.toLowerCase();

			int index = cBookName.indexOf(bookName);

			while (index != -1) {
				String subStr = cBookName.substring(index, index + bookName.length());

				// 
				if (subStr.equals(bookName)) {
					data[i][0] = Integer.toString(theBooks[i].getSNo());
					data[i][1] = theBooks[i].getBookName();
					data[i][2] = theBooks[i].getAuthorName();
					data[i][3] = theBooks[i].getBooktype();
					data[i][4] = Integer.toString(theBooks[i].getBookQtyCopy());
					data[i][5] = Integer.toString(theBooks[i].getBookQty());

					flag++;
					break;
				} else {
					cBookName.substring(index+1);
					index = cBookName.indexOf(bookName);
				}
			}
		}

		// Else no book matches for author
		if (flag == 0)
		{
			System.out.println("No Books of " + bookName + " Found.");
			data = null;
		}
			

		return data;					
	}
}





public class books {

	// Class data members
	//Singleton Pattern
    private static books instance;

    // Class data members
    private ReadingMaterial[] theBooks = new ReadingMaterial[50];
    public int count;

    private Scanner input = new Scanner(System.in);

    private books() {}

    public static books getInstance() {
        if (instance == null) {
            instance = new books();
        }
        return instance;
    }


	// Method 1
	// To compare books
	public int compareBookObjects(ReadingMaterial b1, ReadingMaterial b2)
	{

		// If book name matches
		if (b1.getBookName().equalsIgnoreCase(b2.getBookName())) {

			// Printing book exists
			System.out.println(
				"Book of this Name Already Exists.");
			return 0;
		}

		// if book serial matches
		if (b1.getSNo() == b2.getSNo()) {
			// Print book exists
			System.out.println(
				"Book of this Serial No Already Exists.");

			return 0;
		}
		return 1;
	}

	// Method 2
	// To add book
	public void addBook(ReadingMaterial b)
	{

		for (int i = 0; i < count; i++) {

			if (this.compareBookObjects(b, this.theBooks[i])
				== 0)
				return;
		}

		if (count < 50) {
			theBooks[count] = b;
			count++;
		}
		else {
			System.out.println(
				"No Space to Add More Books.");
		}
	}

	// Method 3
	//To delete book
	public void deleteBook(ReadingMaterial b) {
		for (int i = 0; i < count; i++) {
			if (this.compareBookObjects(b, this.theBooks[i]) == 0) {
				for (int j = i; j < count - 1; j++) {
					this.theBooks[j] = this.theBooks[j + 1];
				}
				this.theBooks[count - 1] = null;
				count--;
				System.out.println("Book deleted successfully.");
				return;
			}
		}
		System.out.println("Book not found.");
	}
	
	
	// Method 4
	// To display all books
	public void showAllBooks()
	{
		String[][] data = new String[count][6];

		for  (int i = 0; i < count; i++) {
			data[i][0] = Integer.toString(theBooks[i].getSNo());
			data[i][1] = theBooks[i].getBookName();
			data[i][2] = theBooks[i].getAuthorName();
			data[i][3] = theBooks[i].getBooktype();
			data[i][4] = Integer.toString(theBooks[i].getBookQtyCopy());
			data[i][5] = Integer.toString(theBooks[i].getBookQty());
		}

		printTable(data);
	}

	// Method 5
	// To edit the book
	public void upgradeBookQty()
	{

		System.out.println(
			"\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
		System.out.println("Enter Serial No of Book");

		int sNo = input.nextInt();

		for (int i = 0; i < count; i++) {

			if (sNo == theBooks[i].getSNo()) {

				// Display message
				System.out.println(
					"Enter No of Books to be Added:");

				int addingQty = input.nextInt();
				theBooks[i].increaseBookQty(addingQty);
				theBooks[i].increaseBookQtyCopy(addingQty);
				return;
			}
		}
	}

	// Method 6
	// To create menu
	public void dispMenu()
	{

		// Displaying menu
		System.out.println(
			"----------------------------------------------------------------------------------------------------------");
		System.out.println("Press 0 to Exit Application.");
		System.out.println("Press 1 to Add new Book.");
		System.out.println("Press 2 to Upgrade Quantity of a Book.");
		System.out.println("Press 3 to Delete a Book.");
		System.out.println("Press 4 to Show All Books.");
		System.out.println("Press 5 to Register Student.");
		System.out.println("Press 6 to Show All Registered Students.");
		System.out.println("Press 7 to Check Out Book. ");
		System.out.println("Press 8 to Check In Book.");
		System.out.println("Press 9 to Search a Book.");
		System.out.println(
			"-------------------------------------------------------------------------------------------------------");
	}

	// Method 7
	// To search the library
	public int isAvailable(int sNo)
	{

		for (int i = 0; i < count; i++) {
			if (sNo == theBooks[i].getSNo()) {
				if (theBooks[i].getBookQtyCopy() > 0) {

					System.out.println(
						"Book is Available.");
					return i;
				}
				System.out.println("Book is Unavailable");
				return -1;
			}
		}

		System.out.println("No Book of Serial Number "
						+ " Available in Library.");
		return -1;
	}

	// Method 8
	// To remove the book from the library
	public ReadingMaterial checkOutBook()
	{

		System.out.println(
			"Enter Serial No of Book to be Checked Out.");
		int sNo = input.nextInt();

		int bookIndex = isAvailable(sNo);

		if (bookIndex != -1) {
			theBooks[bookIndex].decreaseBookQtyCopy(1);
			return theBooks[bookIndex];
		}
		return null;
	}

	// Method 9
	// To add the Book to the Library
	public void checkInBook(ReadingMaterial b)
	{
		for (int i = 0; i < count; i++) {
			if (b.equals(theBooks[i])) {
				theBooks[i].increaseBookQtyCopy(1);
				return;
			}
		}
	}

	//Method 10
	// To search books
	private SearchBookStrategy searchBookStrategy;

	public void setSearchBookStrategy(SearchBookStrategy searchBookStrategy){
		this.searchBookStrategy = searchBookStrategy;
	}

	public void find(){
		String name = input.nextLine();
		String data[][] = searchBookStrategy.searchBook(name, count, theBooks);
		printTable(data);

	}

	// Method 11
	// Print books Table
	public static void printTable(String[][] content) {
		// if content is null
		if (content == null){
			System.out.println("Not data in content.");
			return;
		}

        String[] header = {"S.No", "Name", "Author","Book Type", "Available Qty", "Total Qty"};
		String[][] data = new String[content.length + 1][];
		data[0] = header;
		for (int i = 0; i < content.length; i++) {
			data[i + 1] = content[i];
		}

		// Calculate column widths
        int[] columnWidths = new int[data[0].length];
        for (int i = 0; i < data[0].length; i++) {
            int maxWidth = 0;
            for (String[] row : data) {
				if (row[i] != null) {
					if (row[i].length() > maxWidth) {
					maxWidth = row[i].length();
					}
				}
                
            }
            columnWidths[i] = maxWidth + 2; // Add padding
        }
        
        // Print table
		for (String[] row : data) {
			boolean hasContent = false;
			for (int i = 0; i < row.length; i++) {
				if (row[i] != null) {
					System.out.printf("%-" + columnWidths[i] + "s", row[i]);
					hasContent = true;
				}
			}
			if (hasContent) {
				System.out.println();
			}
		}

    }


	
	
}

