
public class SpotifyDriver {
	public static void main(String[] args) {
		Song song1 = new Song("Bridge over Troubled Waters", "Simon & Garfunkel", 293);
		Song song2 = new Song("Life is a Highway", "Tom Cochrane", 4, 28);
		System.out.println(song1.toString());
		System.out.print(song2.getTitle() + "\t");
		System.out.print(song2.getArtist() + "\t");
		System.out.println(song2.getLength() + "\t");
		
		song2.setTitle("Be Alright");
		song2.setArtist("Dean Lewis");
		song2.setLength(200);
		
		System.out.println(song2.toString());
		
		Song song3 = new Song("Dear Winter", "AJR", 173);
		Song song4 = new Song("Fly Me To The Moon", "Frank Sinatra", 148);
		Song song5 = new Song("The Other Side", "Zac Efron and Hugh Jackman", 3, 34);
		Song song6 = new Song("SPACE IS COOL", "Markiplier and SCHMOYOHO", 3, 21);
		
		Playlist playlist1 = new Playlist();
		Playlist playlist2 = new Playlist("Religious Music");
		Playlist playlist3 = new Playlist("Spiritual Song", song1);
		Playlist playlist4 = new Playlist("Relationship music", song1, song2);
		Playlist playlist5 = new Playlist("My playlist", song1, song2, song3);

		System.out.println(playlist1.toString());
		System.out.println(playlist2.toString());
		System.out.println(playlist3.toString());
		System.out.println(playlist4.toString());
		System.out.println(playlist5.toString());
		
		System.out.println(playlist5.getPlaylistName());
		System.out.println(playlist5.getSong1());
		System.out.println(playlist5.getSong2());
		System.out.println(playlist5.getSong3());
		System.out.println(playlist5.getTotalLength());
		System.out.println();
		
		playlist1.setPlaylistName("Concurrent Music");
		playlist1.setSong1(song4);
		playlist1.setSong2(song5);
		playlist1.setSong3(song6);
		System.out.println(playlist1);
		
		Spotify spotify1 = new Spotify();
		Spotify spotify2 = new Spotify("Cori");
		Spotify spotify3 = new Spotify("Jayson", playlist1);
		Spotify spotify4 = new Spotify("Justin", playlist1, playlist2);
		Spotify spotify5 = new Spotify("Keith", playlist1, playlist2, playlist3);
		
		System.out.println(spotify1.toString());
		System.out.println(spotify2.toString());
		System.out.println(spotify3.toString());
		System.out.println(spotify4.toString());
		System.out.println(spotify5.toString());
		
		System.out.println(spotify5.getOwnerName());
		System.out.println(spotify5.getPlaylist1());
		System.out.println(spotify5.getPlaylist2());
		System.out.println(spotify5.getPlaylist3());
		System.out.println();
		
		spotify5.setPlaylist2(playlist4);
		spotify5.getPlaylist2().setSong3(new Song("Mister GlassMan", "Scotty Sire", 3, 41));
		
		System.out.println(spotify5.getPlaylist2());
		
		spotify5.getPlaylist3().setSong3(song3);
		
		spotify5.printFavorites();
		
		spotify5.getPlaylist3().markAsFavorite(2);
		
		spotify5.getPlaylist1().markAsFavorite(1);
		spotify5.getPlaylist2().markAsFavorite(2);
		spotify5.getPlaylist3().markAsFavorite(3);
		
		spotify5.printFavorites();
		
		spotify3.printFavorites();
		
		spotify2.printFavorites();
		
	}
}
