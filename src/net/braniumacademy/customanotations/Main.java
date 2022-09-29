package net.braniumacademy.customanotations;

@ClassPreamble(
        date = "2022/09/29",
        lastModify = "2022/09/29",
        lastModifyBy = "Branium Academy",
        reviewers = {"Than Trieu", "Branium"}
)
public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("EMP1001", "hương",
                "nguyễn", "huongcute@xmail.com", "Hà Nội", 12.5f);
        var converter = new ObjectToJsonConverter();
        var result = converter.convertToJson(employee);
        System.out.println(result);
    }
}
