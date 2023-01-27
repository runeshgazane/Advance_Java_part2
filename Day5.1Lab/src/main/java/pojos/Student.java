package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students_tbl")
public class Student extends BaseEntity{
	@Column(name="first_name", length = 30)
	private String firstName;
	@Column(name="last_name", length = 30)
	private String lastName;
	@Column(length = 40, unique = true)
	private String email;
	
	//student 1-->* admission
	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Admission> admissions=new ArrayList<Admission>();
	
	public Student() {
		super();
	}
	
	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return super.toString()+"Student [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
}
