package com.algo.java.practice;
import java.io.*;
import java.util.*;
//
//class Person{
//    static int age = 0;
//    void goOut(){
//        System.out.println("안에서 밖으로 나간다.");
//    }
//}
//class Parent extends Person{
//    int age = 1;
//    void goOut(){
//        System.out.println("출근..");
//    }
//}
//class Child extends Parent{
//    int age = 2;
//    void goOut(){
//        System.out.println("놀러가자!");
//    }
//}
interface dsa extends MusicInfo{

}
public class example {
//    static final int[] test = {1, 2, 3, 4, 5, 6, 7,8,9,10};
//
//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            test[i]++;
//            System.out.print(test[i]+" ");
//        }
//    }
public static void main(String[] args) {
    try{
        String fileName = "UserInfo1.ser";
        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        ObjectOutputStream out = new ObjectOutputStream(bos);

        Album album1 = new Album(0,"LILAC",10,23142144,"1234-5678");
        Album album2 = new Album(1,"능소화",3,42378438,"1234-5679");
        MusicInfo m1 = new MusicInfo("coin",3,"IU","dlwlrma",album1);
        MusicInfo m2 = new MusicInfo("능소화",1,"안예은","56yenyen56",album2);
        List list = new ArrayList();
        list.add(m1);
        list.add(m2);

        out.writeObject(m1);
        out.writeObject(m2);
        out.writeObject(list);
        out.close();
        System.out.println("직렬화 끝!");
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);

        ObjectInputStream in = new ObjectInputStream(bis);

        MusicInfo result0 = (MusicInfo)in.readObject();
        MusicInfo result1 = (MusicInfo)in.readObject();
        List resultList = (ArrayList)in.readObject();
        System.out.println(result0.toString());
        System.out.println(result1.toString());
        System.out.println(resultList.toString());
        in.close();
    }catch (IOException | ClassNotFoundException e){
        e.printStackTrace();
    }
}
}
class MusicInfo implements Serializable{
    private String title;
    private int trackNum;
    private String artist;
    transient private String copyRight;
    private Album album;
    public MusicInfo(String title, int trackNum, String artist, String copyRight, Album album) {
        this.title = title;
        this.trackNum = trackNum;
        this.artist = artist;
        this.copyRight = copyRight;
        this.album = album;
    }
    //...getter/setter

    @Override
    public String toString() {
        return "MusicInfo{" +
                "title='" + title + '\'' +
                ", trackNum=" + trackNum +
                ", artist='" + artist + '\'' +
                ", copyRight='" + copyRight + '\'' +
                ", album=" + album +
                '}';
    }
}
class Album implements Serializable{
    private int albumId;
    private String albumName;
    private int numOfTracks;
    transient private int registrationNumber;
    private String ISBN;

    public Album(int albumId, String albumName, int numOfTracks, int registrationNumber, String ISBN) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.numOfTracks = numOfTracks;
        this.registrationNumber = registrationNumber;
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", albumName='" + albumName + '\'' +
                ", numOfTracks=" + numOfTracks +
                ", registrationNumber=" + registrationNumber +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
    //...getter/setter
}
//    public static void main(String[] args) {
//        Child child = new Child();
//        Parent parent = new Parent();
//        Person person = new Child();
//        Parent parent1 = new Child();
//        Child child1 = new Person();
//        System.out.println(person.age);
//        System.out.println(parent.age);
//        System.out.println(child.age);
//        child.goOut();
//        parent.goOut();
//        parent1.goOut();
//        person.goOut();
//        child1.goOut();
//    }
//}
