public class HourlySalaryEmployee extends StaffMember {
    private int hourWorked;
    private double rate = 10.50;

    public HourlySalaryEmployee(int id, String name, String address, int hourWorked, double rate){
        super(id, name, address);
        this.hourWorked = hourWorked;
        this.rate = rate;
    }

    public int getHourWorked() {
        return hourWorked;
    }

    public double getRate() {
        return rate;
    }

    public void setHourWorked(int hourWorked) {
        this.hourWorked = hourWorked;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public double pay() {
        return (rate * hourWorked);
    }

    @Override
    public String toString() {
        return "HourlySalaryEmployee{" +
                "hourWorked=" + hourWorked +
                ", rate=" + rate +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
