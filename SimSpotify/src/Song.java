
public class Song {
	private String title = "";
	private String artist = "";
	private int length = 0;
	
	public Song (String argTitle, String argArtist, int argLength) {
		title = argTitle;
		artist = argArtist;
		length = argLength;
	}
	
	public Song (String argTitle, String argArtist, int argMinute, int argSecond) {
		title = argTitle;
		artist = argArtist;
		length = (argMinute * 60) + argSecond;
	}
	
	public String toString() {
		String displayString = title + "\t" + artist + "\t" + length;
		return displayString;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String argTitle) {
		title = argTitle;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String argArtist) {
		artist = argArtist;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int argLength) {
		length = argLength;
	}
	
	
}
