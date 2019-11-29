package ruins.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author defang.yan
 * @date 19-10-28 下午3:42
 */
public class RemoveExistList {

    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("张三","18"));
        studentList.add(new Student("赵四","18"));
        studentList.add(new Student("王二","18"));
        studentList.add(new Student("孙千","18"));
        studentList.add(new Student("张三","18"));
        studentList.add(new Student("王二","18"));
        studentList.add(new Student("严一","18"));

        System.out.println(studentList.size());
        ArrayList<Student> objects1 = new ArrayList<>();
        for (Student a :
                studentList)
        {
            boolean same = false;
            for (Student student : objects1) {
                if (student.equals(a)) {
                    same = true;
                }
            }
            if (!same) {
                objects1.add(a);
            }
        }
        System.out.println(objects1.size());
        HashMap<String,Student> set = new HashMap<>();
        for (Student student : studentList) {
            if (!set.containsKey(student.name + student.age)) {
                set.put(student.name + student.age,student);
            }
        }
        ArrayList<Student> students = new ArrayList<>(set.values());
        System.out.println(students.size());
    }

}
class Student{
    String name;
    String age;

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return name == ((Student)obj).name && age == ((Student)obj).age;
    }
}

