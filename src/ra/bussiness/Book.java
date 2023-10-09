package ra.bussiness;

import java.util.Scanner;

public class Book {
    private static int nextId = 1;
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private int quantity;
    private boolean bookStatus;

    public Book() {
        this.bookId =  Book.nextId++;
    }

    public Book( String bookName, String author, String descriptions, double importPrice, double exportPrice, float interest,int quantity, boolean bookStatus) {
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.quantity = quantity;
        this.bookStatus = bookStatus;

    }
    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Book.nextId = nextId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập tên sách: ");
        while (true){
            this.bookName=scanner.nextLine();
            if (!bookName.isEmpty()){
                break;
            }else {
                System.out.println("Tên sách không được để trống");
            }
        }

        System.out.println("Nhập tên tác giả: ");

        while (true){
            this.author=scanner.nextLine();
            if (!author.isEmpty()){
                break;
            }else {
                System.out.println("Tác giả không được để trống");
            }
        }


        System.out.println("Nhập mô tả về sách: ");
        while (true){
            this.descriptions=scanner.nextLine();
            if (descriptions.length()>=10){
                break;
            }else {
                System.out.println("Mô tả ít nhất phải 10 ký tự");
            }
        }
        System.out.println("Nhập giá nhập: ");
        while (true){
            this.importPrice=scanner.nextInt();
            if (importPrice>0){
                break;
            }else {
                System.out.println("Giá nhập không đúng định dạng");
            }
        }

        System.out.println("Nhập giá xuất: ");
        while (true){
            this.exportPrice=scanner.nextInt();
            if (exportPrice>1.2*importPrice){
                break;
            }else {
                System.out.println("giá xuất (phải lớn hơn 1.2 lần giá nhập: ");
            }
        }
        this.interest= (float) (exportPrice-importPrice);

        System.out.println("Nhập số lượng sản phẩm: ");
        while (true){
            this.quantity=scanner.nextInt();
            if (quantity>0){
                break;
            }else {
                System.out.println("Số lượng không đúng định dạng");
            }
        }
        scanner.nextLine();

        System.out.println("Trạng thái true/false: ");
        this.bookStatus=scanner.nextBoolean();

    }

    public void displayData(){
        System.out.println("Mã sách:" +bookId);
        System.out.println("Tên sách: " + bookName);
        System.out.println("Tác giả: " + author);
        System.out.println("Mô tả: " + descriptions);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Lợi nhuận: " + interest);
        System.out.println("Số lượng sản phẩm: " + quantity);
        System.out.println("Trạng thái: " + bookStatus);
    }
}
