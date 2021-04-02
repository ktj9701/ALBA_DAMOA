// 계산기 계산 방법 구현 클래스


public class Calculation_function {
	String time_temp = (String) Calculatorpage.Worktime.getSelectedItem(); // 선택한 근무 시간을 String 형으로 변경
	int time = Integer.parseInt(time_temp.substring(0, 1)); // String 형으로 변경한 근무 시간을 int 형으로 변경

	String week_temp = (String) Calculatorpage.week_num.getSelectedItem(); // 선택한 주간 근무 횟수를 String 형으로 변경
	int week = Integer.parseInt(week_temp.substring(0, 1)); // String 형으로 변경한 주간 근무 횟수를 int 형으로 변경

	double avg_num = 4.345238; // 한 달 평균 주 ( 365/ 12 / 7)

	public int Result_pay_function() { // 예상 급여 메소드
		int pay = Integer.parseInt((String) Calculatorpage.Pay.getText()); // 입력한 급여 -> 예상 급여
		if (Calculatorpage.Before.getSelectedItem().equals("시급")) { // 시급으로 계산 시
			pay = pay * time; // 일급
			switch ((String) Calculatorpage.After.getSelectedItem()) { // 변환 결과
			case "시급": // 시급 -> 시급
				pay = pay / time;
				break;
			case "일급": // 시급 -> 일급
				break;
			case "월급": // 시급 -> 월급
				pay = (int) (pay * week * avg_num);
				break;
			case "연봉": // 시급-> 연봉;
				pay = (int) (pay * week * avg_num * 12);
				break;
			}
		} else if (Calculatorpage.Before.getSelectedItem().equals("일급")) { // 일급으로 계산 시
			switch ((String) Calculatorpage.After.getSelectedItem()) { // 변환 결과
			case "시급": // 시급 -> 시급
				pay = pay / time;
				break;
			case "일급": // 시급 -> 일급
				break;
			case "월급": // 시급 -> 월급
				pay = (int) (pay * week * avg_num);
				break;
			case "연봉": // 시급-> 연봉;
				pay = (int) (pay * week * avg_num * 12);
				break;
			}
		} else if (Calculatorpage.Before.getSelectedItem().equals("월급")) { // 월급으로 계산 시
			switch ((String) Calculatorpage.After.getSelectedItem()) { // 변환 결과
			case "시급": // 시급 -> 시급
				pay =  (int)(pay/avg_num/week/time);
				break;
			case "일급": // 시급 -> 일급
				pay = (int)(pay/avg_num/week);
				break;
			case "월급": // 시급 -> 월급
				break;
			case "연봉": // 시급-> 연봉;
				pay = pay*12;
				break;
			}
		} else if (Calculatorpage.Before.getSelectedItem().equals("연봉")) { // 연봉으로 계산 시
			switch ((String) Calculatorpage.After.getSelectedItem()) { // 변환 결과
			case "시급": // 시급 -> 시급
				pay = (int)(pay/12/avg_num/week/time);
				break;
			case "일급": // 시급 -> 일급
				pay=(int)(pay/12/avg_num/week);
				break;
			case "월급": // 시급 -> 월급
				pay = pay/12;
				break;
			case "연봉": // 시급-> 연봉;
				break;
			}
		}
		return pay;
	}

	public int extra_pay_function() { // 주휴수당 메소드
		int extra_pay = 0; // 주휴수당
		if (time * week >= 15 && Calculatorpage.Before.getSelectedItem().equals("시급")) {
			// 주휴수당 구하기 -> 주간 15시간 이상 일해야 주휴수당 지급 조건 만족, 시급으로 월급이나 연봉계산할 때만 쓰면 됨, 일봉으로 월급이상을
			// 구할 땐 적용x
			if (Calculatorpage.After.getSelectedItem().equals("월급"))
				extra_pay = (int) (avg_num
						* ((time * week) / 40 * 8 * Integer.parseInt((String) Calculatorpage.Pay.getText()))); // 한달은 약
																												// 4.34
																												// 주

			else if (Calculatorpage.After.getSelectedItem().equals("연봉"))
				extra_pay = (int) ((365.0 / 7.0)
						* ((time * week) / 40 * 8 * Integer.parseInt((String) Calculatorpage.Pay.getText()))); // 1년은 약
																												// 52주
		}
		return extra_pay;
	}
	public int Tex_function() { // 최종 급여 메소드
		if(Calculatorpage.Tex_flag==true)
			return (int)((Result_pay_function() + extra_pay_function())*0.033);
		else
			return 0;
	}

	public int total_function() { // 최종 급여 메소드
		return Result_pay_function() + extra_pay_function()-Tex_function();
	}

}
