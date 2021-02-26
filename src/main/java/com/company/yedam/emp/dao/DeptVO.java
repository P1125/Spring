package com.company.yedam.emp.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeptVO {
	private String department_id;
	private String department_name;
	private String manager_id;
}
