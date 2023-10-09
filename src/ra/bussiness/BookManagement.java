package ra.bussiness;

import java.util.Arrays;
import java.util.Scanner;

public class BookManagement {
    private static final int MAX_BOOKS = 100;
    private static Book[] books = new Book[MAX_BOOKS];
    private static int bookIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách
                    2. Hiển thị thông tin tất cả sách trong thư viện
                    3. Sắp xếp sách theo lợi nhuận tăng dần
                    4. Xóa sách theo mã sách
                    5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả
                    6. Thay đổi thông tin sách theo mã sách
                    7. Thoát
                    """);
            int choise = scanner.nextInt();
            scanner.nextLine();
            switch (choise) {
                case 1:
                    //Thêm mới
                    addBook(scanner);
                    break;
                case 2:
                    //Hiển thị thông tin sách
                    displayBooks();
                    break;
                case 3:
                    //Sắp xếp sách theo lợi nhuận tăng dần
                    sortBooks(scanner);
                    break;
                case 4:
                    //Xóa sách theo mã sách
                    deleteBook(scanner);
                    break;
                case 5:
                    //Tìm kiếm
                    seachBook(scanner);
                    break;
                case 6:
                    //Thay đổi thông tin sách
                    modifyBook(scanner);
                    break;
                case 7:
                    //thoat
                    System.out.println("Kết thúc");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        }
    }

    private static void modifyBook(Scanner scanner) {
        System.out.println("Nhập mã sách cần thay đổi");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < bookIndex; i++) {
            if (books[i].getBookId() == bookId) {
                System.out.println("Nhập thông tin sách mới");
                books[i].inputData();
                System.out.println("Thay đổi thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy");
    }

    //     Nhập chuỗi tìm kiếm từ bàn phím, thực hiện tìm và in ra những sách có tên hoặc
//    mô tả phù hợp
    private static void seachBook(Scanner scanner) {
        System.out.println("Nhập chuỗi từ khóa cần tìm kiếm");
        String keyword = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < bookIndex; i++) {
            Book book = books[i];
            if (book.getBookName().toLowerCase().contains(keyword) || book.getDescriptions().toLowerCase().contains(keyword)) {
                book.displayData();
                System.out.println("------------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("k tim thay sach phu hop voi tu khoa " + keyword);
        }
    }

    //    Nhập mã sách cần xóa từ bàn phím, thực hiện xóa sách trong danh sách.
    private static void deleteBook(Scanner scanner) {
        System.out.println("Nhập mã sách cần xóa: ");
        int idDelete = scanner.nextInt();
        for (int i = 0; i < bookIndex; i++) {
            if (books[i].getBookId() == idDelete) {
                for (int j = i; j < bookIndex; j++) {
                    books[j] = books[j + 1];
                }
                bookIndex--;
                System.out.println("Xóa thành công");
                return;
            }
        }
        System.out.println("không tìm thấy mã sách : " + idDelete);
    }

    //    Sử dụng thuật toán sắp xếp để sắp xếp sách đang lưu trữ theo lợi nhuận tăng.
    private static void sortBooks(Scanner scanner) {
        Arrays.sort(books, 0, bookIndex, (b1, b2) ->
                Float.compare(b1.getInterest(), b2.getInterest()));
        System.out.println("Sắp xếp lợi nhuận thành công");
    }

    //    Hiển thị tất cả sách đang lưu trữ .
    private static void displayBooks() {
        for (int i = 0; i < bookIndex; i++) {
            books[i].displayData();
        }
    }

//        Nhập số sách (n) cần nhập thông tin từ bàn phím và thực hiện nhập thông tin cho
//        n cuốn sách đó , yêu cầu validate dữ liệu.(danh sách tối đa là 100 phần tử)
    private static void addBook(Scanner scanner) {
        System.out.println("Nhập số lượng cần thêm mới");
        int numBooksToAdd = scanner.nextInt();
        scanner.nextLine();
        if (numBooksToAdd > 0 && (bookIndex + numBooksToAdd) <= MAX_BOOKS) {
            for (int i = 0; i < numBooksToAdd; i++) {
                System.out.println("nhập thông tin cho cuốn " + (i + 1) + ":");
                Book book = new Book();
                book.inputData();
                books[bookIndex++] = book;
            }
            System.out.println("Thêm sách mới thành công");
        } else {
            System.out.println("Số lượng sách không hợp lệ");
        }
    }

}
