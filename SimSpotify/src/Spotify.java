
public class Spotify {
	private Playlist playlist1;
	private Playlist playlist2;
	private Playlist playlist3;
	private String ownerName;
	
	public Spotify() {
		ownerName = "Unknown";
		playlist1 = null;
		playlist2 = null;
		playlist3 = null;
	}
	
	public Spotify (String argOwnerName) {
		ownerName = argOwnerName;
		playlist1 = null;
		playlist2 = null;
		playlist3 = null;
	}
	
	public Spotify (String argOwnerName, Playlist argPlaylist1) {
		ownerName = argOwnerName;
		playlist1 = argPlaylist1;
		playlist2 = null;
		playlist3 = null;
	}
	
	public Spotify (String argOwnerName, Playlist argPlaylist1, Playlist argPlaylist2) {
		ownerName = argOwnerName;
		playlist1 = argPlaylist1;
		playlist2 = argPlaylist2;
		playlist3 = null;
	}
	
	public Spotify (String argOwnerName, Playlist argPlaylist1, Playlist argPlaylist2, Playlist argPlaylist3) {
		ownerName = argOwnerName;
		playlist1 = argPlaylist1;
		playlist2 = argPlaylist2;
		playlist3 = argPlaylist3;
	}
	
	public String toString() {
		String displayString = "Account Owner: " + ownerName;
		if(playlist1 != null) {
			displayString += "\nPlaylist 1:\n" + playlist1.toString();
		}
		if(playlist2 != null) {
			displayString += "\nPlaylist 2:\n" + playlist2.toString();
		}
		if(playlist3 != null) {
			displayString += "\nPlaylist 3:\n" + playlist3.toString();
		}
		
		
		return displayString + "\n";
	}

	public Playlist getPlaylist1() {
		return playlist1;
	}

	public void setPlaylist1(Playlist argPlaylist1) {
		playlist1 = argPlaylist1;
	}

	public Playlist getPlaylist2() {
		return playlist2;
	}

	public void setPlaylist2(Playlist argPlaylist2) {
		playlist2 = argPlaylist2;
	}

	public Playlist getPlaylist3() {
		return playlist3;
	}

	public void setPlaylist3(Playlist argPlaylist3) {
		playlist3 = argPlaylist3;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String argOwnerName) {
		ownerName = argOwnerName;
	}
	
	public void printFavorites() {
		if(playlist1 != null || playlist2 != null || playlist3 != null) {
			if(playlist1.returnSong() == null && playlist2.returnSong() 
					== null && playlist3.returnSong() == null) {
				System.out.println(ownerName + " has no favorite songs.");
			} else {
				System.out.println(ownerName + "'s favorite song in");
			}
			if(playlist1 != null && playlist1.returnSong() != null) {
				System.out.println("Playlist 1 is " + playlist1.returnSong() + ".");
			}
			if (playlist2 != null && playlist2.returnSong() != null) {
				System.out.println("Playlist 2 is " + playlist2.returnSong() + ".");
			} 
			if (playlist3 != null && playlist3.returnSong() != null) {
				System.out.println("Playlist 3 is " + playlist3.returnSong() + ".");
			}
		} else {
			System.out.println(ownerName + " has no playlists on this account.");
		}
		System.out.println();
	}
	
	
}
