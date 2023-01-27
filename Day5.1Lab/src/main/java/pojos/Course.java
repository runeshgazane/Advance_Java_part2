package pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses_tbl")
public class Course extends BaseEntity {
	@Column(name="title", length = 30, unique = true)
	private String courseTitle;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "end_date")
	private LocalDate endDate;
	private double fees;
	private int capacity;
	
	//course 1-->* admission
	@OneToMany(mappedBy = "chosenCourse", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Admission> admissions=new ArrayList<Admission>();
	
	public Course() {
		super();
	}

	public Course(String courseTitle, LocalDate startDate, LocalDate endDate, double fees, int capacity) {
		super();
		this.courseTitle = courseTitle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fees = fees;
		this.capacity = capacity;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return super.toString()+"Course [courseTitle=" + courseTitle + ", startDate=" + startDate + ", endDate=" + endDate + ", fees="
				+ fees + ", capacity=" + capacity + "]";
	}
}
