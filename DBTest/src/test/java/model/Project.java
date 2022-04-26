package model;

import model.dbquery.ProjectTable;
import utils.TestData;

public class Project {

    private Integer id;
    private String name;

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project isCurrentProjectNameExist() {
        if (id != null)
            return this;
        return null;
    }

    public static Project setAndGetProject(){
        ProjectTable.add(new Project(TestData.CURRENT_PROJECT_NAME));
        return ProjectTable.get(TestData.CURRENT_PROJECT_NAME);
    }
}
