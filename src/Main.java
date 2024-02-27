
import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
//Album 0
        Album album = new Album("Album1","Anirudh");

        album.addSong("Chaleya",4.5);
        album.addSong("Badass",3.5);
        album.addSong("Naa Ready",5.0);
        albums.add(album);
//Album 1
        album = new Album("Album2","Karthik");

        album.addSong("Adigaa",4.5);
        album.addSong("Ram Sita Ram",3.5);
        album.addSong("Ava Enna",4.5);

        albums.add(album);
//We have used LL since we have to go to previous as well as next song
        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("Chaleya",playList_1);
        albums.get(0).addToPlayList("Badass",playList_1);
        albums.get(1).addToPlayList("Ram Sita Ram",playList_1);
        albums.get(1).addToPlayList("Adigaa",playList_1);
        albums.get(1).addToPlayList("Ava Enna",playList_1);


        play(playList_1);

    }

    private static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0){
            System.out.println("This playlist have no song");
        }else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){

                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;

                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }else {
                        System.out.println("Reached to the end of the list, no song is available");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                    }else {
                        System.out.println("It is the first song");
                        forward = false;
                    }
                    break;

                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("This is the first song of the list");
                        }
                    }else {
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("This is the list song of the list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() >0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious())
                                System.out.println("now playing "+listIterator.previous().toString());
                        }
                    }

            }
        }
    }

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - To quit\n"+
                "1 - Play next song\n"+
                "2 - Play previous song\n"+
                "3 - Replay the current song\n"+
                "4 - List of all songs \n"+
                "5 - Print all available options\n"+
                "6 - Delete current song");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("-----------------");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("-----------------");
    }

}