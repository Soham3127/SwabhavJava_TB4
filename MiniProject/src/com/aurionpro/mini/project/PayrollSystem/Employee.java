package com.aurionpro.mini.project.PayrollSystem;

class Employee {
    private String employeeId;
    private String name;
    private String salaryString;
    private JobRole role;

    
    public Employee(String employeeId, String name, String salaryString, JobRole role) {
        this.employeeId = employeeId;
        this.name = name;
        this.salaryString = salaryString;
        this.role = role;
    }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSalaryString() { return salaryString; }
    public void setSalaryString(String salaryString) { this.salaryString = salaryString; }

    public JobRole getRole() { return role; }
    public void setRole(JobRole role) { this.role = role; }

    // Clean salary parsing without try-catch and without regex
    private double getSalaryValue() {
        if (salaryString == null || salaryString.isEmpty()) return 0.0;
        String clean = salaryString.trim();
        boolean hasDot = false;
        for (char c : clean.toCharArray()) {
            if (!Character.isDigit(c)) {
                if (c == '.' && !hasDot) {
                    hasDot = true;
                } else {
                    return 0.0;
                }
            }
        }
        return Double.parseDouble(clean);
    }

    public double calculateBonus() {
        double salary = getSalaryValue();
        switch (role) {
            case MANAGER:
                return salary * 0.20;
            case DEVELOPER:
            case DESIGNER:
                return salary * 0.15;
            default:
                return salary * 0.10;
        }
    }

    @Override
    public String toString() {
        return "ID: " + employeeId + ", Name: " + name + ", Role: " + role +
               "\nSalary: " + salaryString + ", Bonus: " + calculateBonus();
    }

    public void display() {
        System.out.println(toString());
        System.out.println("------------------------------------");
    }
}
