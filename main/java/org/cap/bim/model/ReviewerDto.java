package org.cap.bim.model;

public class ReviewerDto 
{
	private int reviewerid;
	private String name;
	private String employedBy;
	
	
	public ReviewerDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewerDto(int reviewerid, String name, String employedBy) {
		super();
		this.reviewerid = reviewerid;
		this.name = name;
		this.employedBy = employedBy;
	}
	public int getReviewerid() {
		return reviewerid;
	}
	public void setReviewerid(int reviewerid) {
		this.reviewerid = reviewerid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmployedBy() {
		return employedBy;
	}
	public void setEmployedBy(String employedBy) {
		this.employedBy = employedBy;
	}
	
	


}
