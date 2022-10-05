package mds.uvod;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentsWork {
    private List<Student> students = new ArrayList<Student>();
    {
        students.add(new Student("Fiala","Marek",211477,1998));
        students.add(new Student("Nanko","Matej",220823,1999));
        students.add(new Student("Viktora","David",226415,2000));
        students.add(new Student("Suchý","Daniel",227061,2000));
        students.add(new Student("Turčanová","Klára",227248,2000));
        students.add(new Student("Wagner","Filip",230351,2001));
        students.add(new Student("Čeleš","Peter",230540,2000));
        students.add(new Student("Texl","Filip",230688,2000));
        students.add(new Student("Čížek","Šimon",230792,1999));
        students.add(new Student("Děcký","Martin",230800,2000));
        students.add(new Student("Šťastná","Ariela",231151,2000));
        students.add(new Student("Klimková","Natálie",231242,2000));
        students.add(new Student("Kociská","Vanesa",231244,2001));
        students.add(new Student("Miková","Timea",231256,2001));
        students.add(new Student("Sabota","Dominik",231274,2000));
        students.add(new Student("Schiller","Vojtěch",231279,2000));
        students.add(new Student("Stejskal","Michal",231282,2000));
        students.add(new Student("Szüč","Martin",231284,2001));
        students.add(new Student("Šíma","Jindřich",231287,2001));
        students.add(new Student("Šrámek","Michal",231288,2001));
        students.add(new Student("Tománek","Stanislav",231293,2000));
        students.add(new Student("Veľký","Roman",231298,2000));
        students.add(new Student("Zeman","David",231304,2001));
        students.add(new Student("Žigrai","Martin",231307,2001));
        students.add(new Student("Kohout","David",195823,1996));
        students.add(new Student("Číka","Petr",10,1982));
        students.add(new Student("Masaryk","Tomáš",123456,1850));
    }

    @GetMapping("student")
    public String funkce1(@RequestParam(defaultValue = "Vojtěch") String name,
                        @RequestParam(defaultValue = "231279") int id)
    {
        return String.format("Student: <b>%s</b> ID: <b>%d</b>", name, id);
    }

    @GetMapping("students")
    public String funkce2(@RequestParam(defaultValue = "-1", name = "vutid") int id)
    {
        if (id == -1) {
            String html = "";
            for (Student student : students)
            {
                html += "Student: <b>" + student.getName() + " " +student.getSurname() +"</b> ID: <b>" + student.getId() + "</b>"+" Year: "+student.getYear()+"<br>";
            }
            return html;
        }
        Optional<Student> result = students.stream().filter(item -> item.getId() == id).findFirst();
        if (result.isEmpty())
        {
            return "Student neexistuje!";
        }
        else
        {
            return "Student: <b>" + result.get().getName() + " " +result.get().getSurname() +"</b> ID: <b>" + result.get().getId() + "</b>"+" Year: "+result.get().getYear()+"<br>";

        }
    }
}
