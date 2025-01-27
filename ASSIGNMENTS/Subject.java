package com.assignment2;

public class Subject {
	
		private String vote;
		private String judgement;
		
		public Subject(String vote,String judgement) {
			this.vote=vote;
			this.judgement=judgement;
		}
		
		public String getVote() {
			return vote;
		}
		
		public String getJudgement() {
			return judgement;
		}

}
