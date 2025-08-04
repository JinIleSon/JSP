package dto.college;

public class CourseDTO {
	private String cs_id;
	private String cs_name;
	private String cs_credit;
	private String cs_dept;
	
	public String getCs_id() {
		return cs_id;
	}
	public void setCs_id(String cs_id) {
		this.cs_id = cs_id;
	}
	public String getCs_name() {
		return cs_name;
	}
	public void setCs_name(String cs_name) {
		this.cs_name = cs_name;
	}
	public String getCs_credit() {
		return cs_credit;
	}
	public void setCs_credit(String cs_credit) {
		this.cs_credit = cs_credit;
	}
	public String getCs_dept() {
		return cs_dept;
	}
	public void setCs_dept(String cs_dept) {
		this.cs_dept = cs_dept;
	}
	@Override
	public String toString() {
		return "CourseDTO [cs_id=" + cs_id + ", cs_name=" + cs_name + ", cs_credit=" + cs_credit + ", cs_dept="
				+ cs_dept + "]";
	}
}
