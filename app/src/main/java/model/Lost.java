package model;

public class Lost {

    int id;
    String img, title, address, text, number, breed, gender, date, dateL;

    public Lost(int id, String img, String title, String address, String text, String number, String breed, String gender, String date, String dateL) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.address = address;
        this.text = text;
        this.number = number;
        this.breed = breed;
        this.gender = gender;
        this.date = date;
        this.dateL = dateL;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateL() {
        return dateL;
    }

    public void setDateL(String dateL) {
        this.dateL = dateL;
    }

}
