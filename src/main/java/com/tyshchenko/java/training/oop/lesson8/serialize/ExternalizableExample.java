package com.tyshchenko.java.training.oop.lesson8.serialize;

import com.tyshchenko.java.training.oop.util.Constants;

import java.io.*;

/**
 * @author Alexander Tyshchenko.
 */
public class ExternalizableExample {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User userWrite = new User(1, "Alexander", "email@gmail.com");

        try (FileOutputStream fos = new FileOutputStream(Constants.FILE_PATH_LESSON_8 + "/user.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(userWrite);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


        User userRead;
        try (FileInputStream fis = new FileInputStream(Constants.FILE_PATH_LESSON_8 + "/user.dat");
             ObjectInputStream ois = new ObjectInputStream(fis))
        {
            userRead = (User) ois.readObject();
        }

        System.out.println("username: " + userRead.getUsername());
    }


    private static class User implements Externalizable {

        private int id;
        private String username;
        private String email;

        public User(int id, String username, String email) {
            this.id = id;
            this.username = username;
            this.email = email;
        }

        public User(){

        }

        public int getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(id);
            out.writeObject(username);
            out.writeObject(email);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            id = in.readInt();
            username = (String) in.readObject();
            email = (String) in.readObject();
        }

    }


}
