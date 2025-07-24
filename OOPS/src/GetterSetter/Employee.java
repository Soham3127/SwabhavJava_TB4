package GetterSetter;

class Employee {
    private String name;
    private double salary;
    private double bonus;

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBonus(double bonus) {
        if (bonus <= 0.2 * salary) {
            this.bonus = bonus;
        } else {
            System.out.println("Bonus too high! Setting bonus to 0.");
            this.bonus = 0;
        }
    }

    public void showSalary() {
        System.out.println("Base Salary: ₹" + salary);
    }

    public void showFinalSalary() {
        System.out.println("Final Salary (with bonus): ₹" + (salary + bonus));
    }
}