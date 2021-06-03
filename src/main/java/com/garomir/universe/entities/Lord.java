package com.garomir.universe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "lords")
public class Lord implements Comparable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    @OneToMany(
            mappedBy = "lord",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Planet> planets;

    public Lord() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(Set<Planet> planets) {
        this.planets = planets;
    }

    @Override
    public int compareTo(Object o) {
        Lord tmp = (Lord) o;
        if(this.age < tmp.age)
        {
            /* текущее меньше полученного */
            return -1;
        }
        else if(this.age > tmp.age)
        {
            /* текущее больше полученного */
            return 1;
        }
        /* текущее равно полученному */
        return 0;
    }
}
