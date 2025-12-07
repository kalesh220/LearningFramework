package org.example;

import com.google.common.base.Objects;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        student std = new student(100, "kalesh");
        student std1 = new student(100, "kalesh");
        student std2 = new student(102, "teja");

        System.out.println("std hash code :" + std.hashcode());
        System.out.println("std1 hash code : "+ std1.hashcode());
        System.out.println("std2 hash code : "+ std2.hashcode());

        System.out.println("std and std comparison : "+ std.equals(std1));
        System.out.println("std and std2 comparison : "+ std.equals(std2));

    }
}
class student{
    public int id;
    public String name;
    public student(int id, String name){
        this.id = id;
        this.name = name;
    }
    public int hashcode(){
        return Objects.hashCode(id, name);
    }

    public boolean equals(Object obj){
        if(this==obj)
            return true;
        if(obj==null || getClass()!=obj.getClass())
            return false;
        student std = (student) obj;
        return id==std.id && Objects.equal(name, std.name);
    }
}

