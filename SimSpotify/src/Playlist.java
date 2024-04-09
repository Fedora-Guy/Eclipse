// Changed to mark a song as favorite as per the bonus hw assignment
// Also added a return SongMethod

public class Playlist {
	private String playlistName;
	private Song song1;
	private Song song2;
	private Song song3;
	private int favorite;
	
	
	public Playlist () {
		playlistName = "untitled";
		song1 = null;
		song2 = null;
		song3 = null;
		favorite = 0;
	}
	
	public Playlist (String argPlaylistName) {
		playlistName = argPlaylistName;
		song1 = null;
		song2 = null;
		song3 = null;
		favorite = 0;
	}
	
	public Playlist (String argPlaylistName, Song argSong1) {
		playlistName = argPlaylistName;
		song1 = argSong1;
		song2 = null;
		song3 = null;
		favorite = 0;
	}
	
	public Playlist (String argPlaylistName, Song argSong1, Song argSong2) {
		playlistName = argPlaylistName;
		song1 = argSong1;
		song2 = argSong2;
		song3 = null;
		favorite = 0;
	}
	
	public Playlist (String argPlaylistName, Song argSong1, Song argSong2, Song argSong3) {
		playlistName = argPlaylistName;
		song1 = argSong1;
		song2 = argSong2;
		song3 = argSong3;
		favorite = 0;
	}
	
	public String toString() {
		String displayString = "Playlist: " + playlistName;
		if(song1 != null) {
			displayString += "\nSong 1: " + song1.toString();
		}
		if(song2 != null) {
			displayString += "\nSong 2: " + song2.toString();
		}
		if(song3 != null) {
			displayString += "\nSong 3: " + song3.toString();
		}
		
		displayString += "\nTotal Length: ";
		if(getTotalLength() / 60 >= 0) {
			displayString += getTotalLength() / 60 + ":";
		}
		if(getTotalLength() % 60 < 10) {
			displayString += "0" + getTotalLength() % 60;
		} else {
			displayString += getTotalLength() % 60;
		}
		
		return displayString + "\n";
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String argPlaylistName) {
		playlistName = argPlaylistName;
	}

	public Song getSong1() {
		return song1;
	}

	public void setSong1(Song argSong1) {
		song1 = argSong1;
	}

	public Song getSong2() {
		return song2;
	}

	public void setSong2(Song argSong2) {
		song2 = argSong2;
	}

	public Song getSong3() {
		return song3;
	}

	public void setSong3(Song argSong3) {
		song3 = argSong3;
	}
	
	public int getTotalLength() {
		int totalLength = 0;
		if(song1 != null) {
			totalLength += song1.getLength();
		}
		if(song2 != null) {
			totalLength += song2.getLength();
		}
		if(song3 != null) {
			totalLength += song3.getLength();
		}
		
		return totalLength;
	}
	
	public void markAsFavorite(int n) {
		if(favorite != n) {
			if(n == 1 && song1 != null) {
				favorite = n;
			} else if(n == 2 && song2 != null) {
				favorite = n;
			} else if(n == 3 && song3 != null) {
				favorite = n;
			} else {
				favorite = 0;
				System.out.println("There is no song \"" + n + "\" to mark as favorite.");
				System.out.println();
			}
		}
		
	}
	
	public int getFavorite() {
		return favorite;
	}
	
	// Use markAsFavorite method instead
	/*
	public void setFavorite(int argFavorite) {
		favorite = argFavorite;
	} 
	*/
	
	public Song returnSong() {
		int n = favorite;
		if(n == 1 && song1 != null) {
			return song1;
		} else if (n == 2 && song2 != null) {
			return song2;
		} else if (n == 3 && song3 != null) {
			return song3;
		} else {
			return null;
		}
		
	}
	
}
