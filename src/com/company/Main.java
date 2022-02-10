package com.company;

import com.test.TestClass;
import exe.TestClassExe;

interface Fly {
    // только про поведение
    String fly();
}

class UFO implements Fly {

    @Override
    public String fly() {
        return "UFO flying";
    }
}
// предок родитель super класс для студента
class Pupil implements Fly {
    // состояние данные = поля класса = члена
    private int avgMark; // успеваемость от 0 до 12
    private int level;
    //public int test;

    // поведение методы работы с данными (метод это функция внутри класса (у объекта класса = инстанс)

    public Pupil() {
        System.out.printf("constuctor by default Pupil"); // логируем
    }

    public Pupil(int avgMark, int level) {
        System.out.printf("constuctor with two params Pupil");

        this.setAvgMark(avgMark);
        this.setLevel(level);
    }

    public int getAvgMark() {
        return this.avgMark;
    }

    public void setAvgMark(int avgMark) {
        if (avgMark < 1 || avgMark > 12) {
            System.out.println("invalid avg mark");
            return;
        }
        this.avgMark = avgMark;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override // переопределить
    public String toString() {
        return "Pupil{" +
                "avgMark=" + avgMark +
                ", level=" + level +
                '}';
    }

    private int getRandomNumber() {
        return 42;
    }

    @Override
    public String fly() {
        return "pupil flying";
    }
}

// наследник
class Student extends Pupil {
    String name;

    public Student(String name) {
        super(1, 10); // вызов констуктора родителя
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}

/*
ООП
* абстракция - выделение важных для нашей программы свойств и методов некой сущности
* наследование - очень спорно его польза и // композиция , DI
* инкапсуляция - объединение в одной сущности и состояния и поведения. в джава в т.ч. сокрытие данных
* полиморфизм - разное поведение для вызова одного метода.
* */
public class Main {

    public static void main(String[] args) {
        Pupil tim = new Pupil(11, 8); // создали экзмепляр класса  = объект = инстанс
        //Pupil ann = new Pupil(); // создали экзмепляр класса  = объект = инстанс

        Student john = new Student("John");

        Pupil pupilOrStudent;

        if (2 > 3) {
            pupilOrStudent = tim;
        } else {
            pupilOrStudent = john;
        }
        System.out.println();
        System.out.println(pupilOrStudent);

        UFO ufo = new UFO();

        Fly ufoOrPupil;

        if (1 < 2) {
            ufoOrPupil = ufo;
        } else {
            ufoOrPupil = tim;
        }

        ufoOrPupil.fly();


    }
}
