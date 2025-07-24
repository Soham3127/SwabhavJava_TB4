package GetterSetter;

public class LibraryBookTracker {
	private String title;
	private String author;
	private boolean issued;
	public LibraryBookTracker() {
		
		
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isIssued() {
		return issued;
	}
	public void setIssued(boolean issued) {
		this.issued = issued;
	}
	
	
	public String getStatus() {
		return issued? "Issued": "Available";
		
	}
	
	
	public String toString() {
		return "LibraryBookTracker [title=" + title + ",\n author=" + author +  + getStatus ]";
	}
	
	
	

}
