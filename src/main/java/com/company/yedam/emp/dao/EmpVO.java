package com.company.yedam.emp.dao;



import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder // 빌더가 생성자를 대체할수있다. (빌더만들때 밑에 두개같이만들어준다)
@NoArgsConstructor
@AllArgsConstructor
@Data // 데이터만 쓰면 다포함된다. 앞으로 롬복 사용.
//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
public class EmpVO {
	private String employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String	phone_number;
	private Date	hire_date;
	private String	job_id;
	private String	salary;
	private String	commission_pct;
	private String	manager_id;
	private String	department_id;
}
