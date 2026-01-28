import java.util.ArrayList;

public class Playlist {
	private String name;
	private ArrayList<Song> songs;
	
	public Playlist(String name) {
		this.name = name;
		
		this.songs = new ArrayList<Song>();
	}
	//Q1
	public boolean addSong(Song song) {
		for (int i = 0; i < songs.size(); i++) {
			Song s = songs.get(i);
			
			if (s.getTitle().equals(song.getTitle())) {
				System.out.println(song.getTitle() + " already in the playlist.");
				return false;
			}
		}
		songs.add(song);
		return true;
	}
	//Q2
	public boolean addSongAtIndex(Song song, int index) {
		if (index < 0 || index > songs.size()) {
			System.out.println("Invalid Index");
			return false;
		}
		for (int i = 0; i < songs.size(); i++) {
			Song s = songs.get(i);
			
			if (s.getTitle().equals(song.getTitle())) {
				System.out.print(song.getTitle() + " already in the playlist.");
				return false;
			}
		}
		
		songs.add(index, song);
		return true;
	}
	//Q3
	public boolean removeSongByIndex(int index) {
		if (index < 0 || index >= songs.size()) {
			System.out.println("Invalid Index");
			return false;
		}
		songs.remove(index);
		return true;
	}
	//Q4
	public Song removeSongByTitle(String title) {
		for (int i = 0; i < songs.size(); i++) {
			Song s = songs.get(i);
			
			if (s.getTitle().equals(title)) {
				songs.remove(i);
				return s;
			}
		}
		System.out.println("Not found.");
		return null;
	}
	//Q5
	public double getPlaylistDuration() {
		int totalSeconds = 0;
		for (int i = 0; i < songs.size(); i++) {
	        Song s = songs.get(i);
	        totalSeconds += s.getDurationSec();
	    }
		
		int minutes = totalSeconds / 60;
	    int remainingSeconds = totalSeconds % 60;
	    
	    return minutes + (remainingSeconds / 100.0);
	}
	//Q6
	public void showPlaylist() {
		System.out.println(this.name);
		
		for (int i = 0; i < songs.size(); i++) {
	        Song s = songs.get(i);
	        System.out.println("[" + i + "] " + s.toString());
		}
	}
	//Q7
	public ArrayList<Song> getTooLongSongs (double minute){
		ArrayList<Song> result = new ArrayList<Song>();
		for (int i = 0; i < songs.size(); i++) {
	        Song s = songs.get(i);
	        
	        if (s.getDuration() > minute) {
	            result.add(s);
	        }
	    }
		return result;
	}
}
