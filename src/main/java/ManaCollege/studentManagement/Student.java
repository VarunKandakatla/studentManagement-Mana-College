package ManaCollege.studentManagement;

public class Student {
    private String name;
    private String branch;
    private int admNo;

    public Student(String name, String branch, int admNo) {
        this.name = name;
        this.branch = branch;
        this.admNo = admNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getAdmNo() {
        return admNo;
    }

    public void setAdmNo(int admNo) {
        this.admNo = admNo;
    }
}
