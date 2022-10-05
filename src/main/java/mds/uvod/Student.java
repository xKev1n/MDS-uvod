package mds.uvod;

public class Student {
    private String surname, name;
    private int id, year;

    public Student(String surname, String name, int id, int year) {
        this.surname = surname;
        this.name = name;
        this.id = id;
        this.year = year;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", year=" + year +
                '}';
    }
}
