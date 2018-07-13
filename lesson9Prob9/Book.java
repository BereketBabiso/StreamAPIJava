package lesson9Prob9;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Book {
	private List<BookCopy> copies = new ArrayList<BookCopy>();
	private String title;
	public Book(String title, int numCopies) {
		if(numCopies < 1) throw new IllegalArgumentException(
				"NumCopies must be positive");
		this.title= title;
		for(int i = 0; i < numCopies; ++i) {
			addCopy();
		}
	}
	public List<BookCopy> getCopies() {
		return copies;
	}
	public void addCopy() {
		BookCopy copy = new BookCopy(this, copies.size() + 1, true);
		copies.add(copy);
	}
	
	public boolean isAvailable() {
		return copies.stream().map(b->b.isAvailable()).reduce((b1,b2)->b1||b2).get();
	}
	
	public static void main(String[] args) {
		Book book = new Book("test",3);
		List<BookCopy> copies = book.getCopies();
		copies.forEach(c->c.changeAvailability());
		
		System.out.println(book.isAvailable());
	}
}
