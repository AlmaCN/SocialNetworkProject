package it.develhope.team4.Entities;

public class User {
        private int id;
        private String name;
        private String surname;
        private String email;
        private String nickname;

        public User(){

        };
        public User(int id, String name, String surname, String email, String nickname){
            this.name = name;
            this.surname = surname;
            this.email = email;
            this.id = id;
        }
        public User(String email, String nickname){
            this.email = email;
            this.nickname = nickname;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }


