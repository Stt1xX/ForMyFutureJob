package org.example;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlRootElement(name = "cat")
public class Cat
{
    public String name;
    public int age;
    public int weight;

    public Cat(String name, int age, int weight)
    {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Cat(){

    }

    @Override
    public String toString() {
        return "Котейку зовут: " + this.name + "\nКотейка весит: " + this.weight
                + "\nКотейка прожил уже " + age + " лет";
    }
}
