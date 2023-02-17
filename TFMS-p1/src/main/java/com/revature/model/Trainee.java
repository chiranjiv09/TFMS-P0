package com.revature.model;

public class Trainee {
	

	private String traineeId;
	private String traineeName;
	private String traineeTrack;
	private String traineeQualification;
	private String traineeExperience;
	

	public Trainee(String traineeId, String traineeName, String traineeTrack, String traineeQualification,
			String traineeExperience) {
		super();
		this.traineeId = traineeId;
		this.traineeName = traineeName;
		this.traineeTrack = traineeTrack;
		this.traineeQualification = traineeQualification;
		this.traineeExperience = traineeExperience;
	}

	public Trainee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(String traineeId) {
		this.traineeId = traineeId;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public String getTraineeTrack() {
		return traineeTrack;
	}

	public void setTraineeTrack(String traineeTrack) {
		this.traineeTrack = traineeTrack;
	}

	public String getTraineeQualification() {
		return traineeQualification;
	}

	public void setTraineeQualification(String traineeQualification) {
		this.traineeQualification = traineeQualification;
	}

	public String getTraineeExperience() {
		return traineeExperience;
	}

	public void setTraineeExperience(String traineeExperience) {
		this.traineeExperience = traineeExperience;
	}

	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", traineeName=" + traineeName + ", traineeTrack=" + traineeTrack
				+ ", traineeQualification=" + traineeQualification + ", traineeExperience=" + traineeExperience + "]";
	}
	
	
}