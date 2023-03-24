package com.example.jsonreader;

class JsonData {
    private String name;
    private int age;

    public JsonData(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter und Setter Methoden

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

    @Override
    public String toString() {
        return "JsonData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
