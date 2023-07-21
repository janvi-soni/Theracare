package com.example.mittihub;

public class Modalclassjo {
    String group,description,members;
    public Modalclassjo()
    {

    }
    public Modalclassjo(String group, String description, String members)
    {
        this.group=group;
        this.description=description;
        this.members=members;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }


    public String getgroup() {
        return group;
    }

    public void setgroup(String group) {
        this.group=group;
    }


}


