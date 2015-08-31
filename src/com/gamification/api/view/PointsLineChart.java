package com.gamification.api.view;

public class PointsLineChart {
	private String xAxis[] = new String[] {"JAN","FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
	private String yAxis[] = new String[]{"0","0","0","0","0","0","0","0","0","0","0","0"};
	public String[] getxAxis() {
		return xAxis;
	}
	public void setxAxis(String xAxis[]) {
		this.xAxis = xAxis;
	}
	public String[] getyAxis() {
		return yAxis;
	}
	public void setyAxis(String yAxis[]) {
		this.yAxis = yAxis;
	}
}
