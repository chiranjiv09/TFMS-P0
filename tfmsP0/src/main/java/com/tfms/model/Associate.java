package com.tfms.model;   //POJO

public class Associate {
	
  private String traineeName;
  private String traineeId;
  private String track;
  private String  qualification;
  private String experience;
  private String trainerId;
   
   
public Associate() {
	super();
	// TODO Auto-generated constructor stub
}


public Associate(String traineeName, String traineeId, String track, String qualification, String experience,
		String trainerId) {
	super();
	this.traineeName = traineeName;
	this.traineeId = traineeId;
	this.track = track;
	this.qualification = qualification;
	this.experience = experience;
	this.trainerId = trainerId;
}


public String getTraineeName() {
	return traineeName;
}


public void setTraineeName(String traineeName) {
	this.traineeName = traineeName;
}


public String getTraineeId() {
	return traineeId;
}


public void setTraineeId(String traineeId) {
	this.traineeId = traineeId;
}


public String getTrack() {
	return track;
}


public void setTrack(String track) {
	this.track = track;
}


public String getQualification() {
	return qualification;
}


public void setQualification(String qualification) {
	this.qualification = qualification;
}


public String getExperience() {
	return experience;
}


public void setExperience(String experience) {
	this.experience = experience;
}


public String getTrainerId() {
	return trainerId;
}


public void setTrainerId(String trainerId) {
	this.trainerId = trainerId;
}


@Override
public String toString() {
	return "Associate [traineeName=" + traineeName + ", traineeId=" + traineeId + ", track=" + track
			+ ", qualification=" + qualification + ", experience=" + experience + ", trainerId=" + trainerId + "]";
}
   


   
}
