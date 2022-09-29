package net.braniumacademy.customanotations;

@JsonSerializable
@ClassPreamble(
        date = "2022/09/29",
        lastModify = "2022/09/29",
        lastModifyBy = "Branium Academy",
        reviewers = {"Than Trieu", "Branium"}
)
public class Employee {
    @JsonElement
    private String empId; // mã nhân viên
    @JsonElement
    private String firstName; // tên
    @JsonElement
    private String lastName; // họ
    @JsonElement
    private String email; // email
    @JsonElement
    private float salary; // mức lương
    private String address; // địa chỉ

    public Employee() {
    }

    public Employee(String empId, String firstName,
                    String lastName, String email,
                    String address, float salary) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.salary = salary;
    }

    /**
     * Phương thức khởi tạo họ và tên trở thành cụm string có chữ cái đầu từ được viết hoa
     */
    @Init
    private void initNames() {
        this.firstName = this.firstName.substring(0, 1).toUpperCase() +
                this.firstName.substring(1);
        this.lastName = this.lastName.substring(0, 1).toUpperCase() +
                this.lastName.substring(1);
    }
}
