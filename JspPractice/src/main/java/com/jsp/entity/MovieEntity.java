package com.jsp.entity;

import com.jsp.dto.MovieDTO;

public class MovieEntity extends MovieDTO{
	private int totalDataCount;

	public int getTotalDataCount() {
		return totalDataCount;
	}

	public void setTotalDataCount(int totalDataCount) {
		this.totalDataCount = totalDataCount;
	}
	@Override
	public String toString() {
		return "totalDataCount=" + this.getTotalDataCount() + "m_id: " + this.getM_id() +", m_name: " + this.getM_name();
	}
}
