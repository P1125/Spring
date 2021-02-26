package com.company.yedam.emp.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobVO {
	private String job_id;
	private String job_title;
	private String min_salary;
}
