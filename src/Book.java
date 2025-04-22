class Book{
    int id;
    String isbn;
    String title;
    boolean isCheckedOut;
    String checkedOutTo;
    Book(int id, String isbn, String title){
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }
    void checkout(String name) {
        this.checkedOutTo = name;
        this.isCheckedOut = true;
    }
    void checkIn(){
        this.checkedOutTo = ""; //clear
        this.isCheckedOut = false;
    }
}
