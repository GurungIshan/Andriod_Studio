package np.edu.kathford.sqllite.models;

public class Student {
    private int id;
    private String fullname;

    private String address;
    private String mobileNumber;

//    private Student(){
//
//    }

    public Student(int id, String fullname, String mobileNumber, String address) {
        this.id = id;
        this.fullname = fullname;
        this.mobileNumber = mobileNumber;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
