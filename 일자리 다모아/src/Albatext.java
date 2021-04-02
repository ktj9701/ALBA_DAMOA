//알바 광고 목록 추가 하기 위한 클래스

public class Albatext {
	private String area;
	private String pay;
	private String office;
	private String text;
	private String time;

	public Albatext(String _area, String _pay, String _office, String _text, String _time) {
			this.area = _area;
			this.pay = _pay;
			this.office = _office;
			this.text = _text;
			this.time = _time;
			
			
		}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}