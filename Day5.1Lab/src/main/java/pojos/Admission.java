package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "admissions_tbl", uniqueConstraints = 
@UniqueConstraint(columnNames = {"course_id","student_id"}))
public class Admission extends BaseEntity{
	@Column(name = "admission_date")
	@CreationTimestamp
	private LocalDate applicationDate;
	@Column(name = "result_date")
	private LocalDate resultDate;
	@Enumerated(EnumType.STRING)
	@Column(name = "admission_status")
	private Status admissionStatus;
	
	//admission *-->1 course  
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course chosenCourse;
	
	//admission *-->1 stduent  
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student candidate;
	
	public Admission() {
		super();
	}

	public Admission(LocalDate applicationDate, LocalDate resultDate, Status admissionStatus) {
		super();
		this.applicationDate = applicationDate;
		this.resultDate = resultDate;
		this.admissionStatus = admissionStatus;
	}

	public Status getAdmissionStatus() {
		return admissionStatus;
	}

	public void setAdmissionStatus(Status admissionStatus) {
		this.admissionStatus = admissionStatus;
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public LocalDate getResultDate() {
		return resultDate;
	}

	public void setResultDate(LocalDate resultDate) {
		this.resultDate = resultDate;
	}

	public Course getChosenCourse() {
		return chosenCourse;
	}

	public void setChosenCourse(Course chosenCourse) {
		this.chosenCourse = chosenCourse;
	}

	public Student getCandidate() {
		return candidate;
	}

	public void setCandidate(Student candidate) {
		this.candidate = candidate;
	}

	@Override
	public String toString() {
		return super.toString()+"Admission [applicationDate=" + applicationDate + ", resultDate=" + resultDate + ", admissionStatus="
				+ admissionStatus + "]";
	}

}
