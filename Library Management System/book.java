import java.util.Scanner;

//Factory Pattern
interface ReadingMaterial {
  
    void setSNo();
    void setBookName();
	void setAuthorName();
    void setBooktype();
    void setBookQty();
    void setBookQtyCopy();
    void decreaseBookQtyCopy(int deletingQty);
    void increaseBookQtyCopy(int addingQty);
    void increaseBookQty(int addingQty);

    int getSNo();
	String getBookName();
	String getAuthorName();
    String getBooktype();
    int getBookQty();
    int getBookQtyCopy();
}

class book implements ReadingMaterial{
    private int sNo;
	private String bookName;
	private String authorName;
    private String bookType;
    private int bookQty;
    private int bookQtyCopy;

    public book(){
        setSNo();
        setAuthorName();
        setBookName();
        setBooktype();
        setBookQty();
        setBookQtyCopy();
    }

    // Creating object of Scanner class to
	// read input from users
	Scanner input = new Scanner(System.in);

    @Override
    public void setSNo(){
        System.out.println("Enter Serial No of Book:");
		this.sNo = input.nextInt();
		input.nextLine();
    }

    @Override
	public void setBookName(){
        System.out.println("Enter Book Name:");
		this.bookName = input.nextLine();
    }

    @Override
	public void setAuthorName(){
        System.out.println("Enter Author Name:");
		this.authorName = input.nextLine();
    }

    @Override
    public void setBooktype(){
        this.bookType = "Book";
    }


    @Override
    public void setBookQty(){
        System.out.println("Enter Book Quantity:");
		this.bookQty = input.nextInt();
		input.nextLine();
    }

    @Override
    public void setBookQtyCopy(){
        this.bookQtyCopy = this.bookQty;
    }

    @Override
    public void decreaseBookQtyCopy(int deletingQty) {
        this.bookQtyCopy -= deletingQty;
    }

    @Override
    public void increaseBookQtyCopy(int addingQty) {
        this.bookQtyCopy += addingQty;
    }

    @Override
    public void increaseBookQty(int addingQty) {
        this.bookQty += addingQty;
    }
    



    @Override
    public int getSNo(){
        return sNo;
    }

    @Override
	public String getBookName(){
        return bookName;
    }

    @Override
	public String getAuthorName(){
        return authorName;
    }

    @Override
    public String getBooktype(){
        return bookType;
    }

    @Override
    public int getBookQty(){
        return bookQty;
    }

    @Override
    public int getBookQtyCopy(){
        return bookQtyCopy;
    }

}

class magazine implements ReadingMaterial{
    private int sNo;
	private String bookName;
	private String authorName;
    private String bookType;
    private int bookQty;
    private int bookQtyCopy;

    public magazine(){
        setSNo();
        setAuthorName();
        setBookName();
        setBooktype();
        setBookQty();
        setBookQtyCopy();
    }

    // Creating object of Scanner class to
	// read input from users
	Scanner input = new Scanner(System.in);

    @Override
    public void setSNo(){
        System.out.println("Enter Serial No of Book:");
		this.sNo = input.nextInt();
		input.nextLine();
    }

    @Override
	public void setBookName(){
        System.out.println("Enter Book Name:");
		this.bookName = input.nextLine();
    }

    @Override
	public void setAuthorName(){
        System.out.println("Enter Author Name:");
		this.authorName = input.nextLine();
    }

    @Override
    public void setBooktype(){
        this.bookType = "Magazine";
    }


    @Override
    public void setBookQty(){
        System.out.println("Enter Book Quantity:");
		this.bookQty = input.nextInt();
		input.nextLine();
    }

    @Override
    public void setBookQtyCopy(){
        this.bookQtyCopy = this.bookQty;
    }

    @Override
    public void decreaseBookQtyCopy(int deletingQty) {
        this.bookQtyCopy -= deletingQty;
    }

    @Override
    public void increaseBookQtyCopy(int addingQty) {
        this.bookQtyCopy += addingQty;
    }

    @Override
    public void increaseBookQty(int addingQty) {
        this.bookQty += addingQty;
    }
    



    @Override
    public int getSNo(){
        return sNo;
    }

    @Override
	public String getBookName(){
        return bookName;
    }

    @Override
	public String getAuthorName(){
        return authorName;
    }

    @Override
    public String getBooktype(){
        return bookType;
    }

    @Override
    public int getBookQty(){
        return bookQty;
    }

    @Override
    public int getBookQtyCopy(){
        return bookQtyCopy;
    }

}

//Decorator Pattern
abstract class bookDecorator implements ReadingMaterial{
    protected final ReadingMaterial decoratedBook;

    public bookDecorator(ReadingMaterial c) {
        this.decoratedBook = c;
    }

    @Override
    public int getSNo(){
        return decoratedBook.getSNo();
    }

    @Override
	public String getAuthorName(){
        return decoratedBook.getAuthorName();
    }

    @Override
    public int getBookQty(){
        return decoratedBook.getBookQty();
    }

    @Override
    public int getBookQtyCopy(){ 
        return decoratedBook.getBookQtyCopy();
    }

    @Override
	public String getBookName(){
        return decoratedBook.getBookName();
    }

    @Override
    public String getBooktype(){
        return decoratedBook.getBooktype();
    }

    @Override
    public void setSNo(){
        
    }

    @Override
	public void setBookName(){

    }

    @Override
	public void setAuthorName(){

    }

    @Override
    public void setBooktype(){

    }


    @Override
    public void setBookQty(){
      
    }

    @Override
    public void setBookQtyCopy(){
      
    }

    @Override
    public void decreaseBookQtyCopy(int deletingQty) {
        
    }

    @Override
    public void increaseBookQtyCopy(int addingQty) {
       
    }

    @Override
    public void increaseBookQty(int addingQty) {
       
    }

}

class IllustratedEdition extends bookDecorator{
    public IllustratedEdition(ReadingMaterial c) {
        super(c);
    }

    @Override
	public String getBookName(){
        return super.getBookName()+"(Illustrated)";
    }
    
}

class EducationalEdition extends bookDecorator{
    public EducationalEdition(ReadingMaterial c) {
        super(c);
    }
    @Override
	public String getBookName(){
        return super.getBookName()+"(Educational)";
    }

    
}


