//시,군,구 콤보박스 구현

import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class Detail_Area {

	// 서울시
	static String[] Detail_Seoul = { "전체", "강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구",
			"동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구" };

	// 경기도
	static String[] Detail_Gyeonggi = { "전체", "가평군", "고양시 덕약구", "고양시 일산동구", "고양시 일산서구", "과천시", "광명시", "광주시", "구리시",
			"군포시", "김포시", "남양주시", "동두천시", "부천시", "성남시 분당구", "성남시 수정구", "성남시 중원구", "수원시 권선구", "수원시 영통구", "수원시 장안구",
			"수원시 팔달구", "시흥시", "안산시 단원구", "안산시 상록구", "수원시 권선구", "수원시 영통구", "수원시 장안구", "수원시 팔달구", "시흥시", "안산시 단원구",
			"안산시 상록구", "안성시", "안양시 동안구", "안양시 만안구", "양주시", "양평군", "여주시", "연천구", "오산시", "용인시 기흥구", "용인시 수지구", "용인시 처인구",
			"의왕시", "의정부시", "이천시", "파주시", "평택시", "포천시", "하남시", "화성시" };

	// 인천
	static String[] Detail_Incheon = { "전체", "강화군", "계양구", "남동구", "동구", "미추홀구", "부평구", "서구", "연수구", "옹진군", "중구" };

	// 강원
	static String[] Detail_Gangwon = { "전체", "강릉시", "고성군", "동해시", "삼척시", "속초시", "양구군", "양양군", "영월군", "원주시", "인제군",
			"정선군", "철원군", "춘천시", "태백시", "평창군", "홍천군", "화천군", "횡성군" };

	// 대전
	static String[] Detail_Daejeon = { "전체", "대덕구", "동구", "서구", "유성구", "중구" };

	// 세종
	static String[] Detail_Sejong = { "전체", "세종시" };

	// 충남
	static String[] Detail_Chungnam = { "전체", "계룡시", "공주시", "금산군", "논산시", "당진시", "보령시", "부여군", "서산시", "서천군", "아산시",
			"예산군", "천안시 동남구", "천안시 서북구", "청양군", "태안군", "홍성군" };

	// 충북
	static String[] Detail_Chungbuk = { "전체", "괴산군", "단양군", "보은군", "영동군", "옥천군", "음성군", "제천시", "증평군", "진천군", "청주시 상당구",
			"청주시 서원구", "청주시 청원구", " 청주시 흥덕구", "충주시" };

	// 부산
	static String[] Detail_Busan = { "전체", "강서구", "금정구", "기장군", "남구", "동구", "동래구", "부산진구", "북구", "사상구", "시하구", "서구",
			"수영구", "연제구", "영도구", "중구", "해운대구" };

	// 울산
	static String[] Detail_Ulsan = { "전체", "남구", "동구", "북구", "울주군", "중구" };

	// 경남
	static String[] Detail_Gyeongnam = { "전체", "거제시", "거창군", "고성군", "김해시", "남해군", "밀양시", "사천시", "산청군", "양산시", "의령군",
			"진주시", "창녕군", "창원시 마산합포구", "창원시 마산회원구", "창원시 성산구", "창원시 의창구", "창원시 진해구", "통영시", "하동군", "함안군", "함양군",
			"합천군" };

	// 경북
	static String[] Detail_Gyeongbuk = { "전체", "경산시", "경주시", "고령군", "구미시", "군위군", "김천시", "문경시", "봉화군", "상주시", "성주군",
			"안동시", "영덕군", "영양군", "영주시", "영천시", "예천군", "울릉군", "울진군", "의성군", "청도군", "청송군", "칠곡군", "포항시 남구", "포항시 북구" };
	// 대구
	static String[] Detail_Dae_gu = { "전체", "남구", "달서구", "달성군", "동구", "북구", "서구", "수성구", "중구" };
	// 광주
	static String[] Detail_Gwangju = { "전체", "광산구", "남구", "동구", "북구", "서구" };
	// 전남
	static String[] Detail_Jeonnam = { "전체", "강진군", "고흥군", "곡성군", "광양시", "구례군", "나주시", "담양군", "목포시", "무안군", "보성군",
			"순천시", "신안군", "여수시", "영광군", "영암군", "완도군", "장성군", "장흥군", "진도군", "함평군", "해남군", "화순군" };
	// 전북
	static String[] Detail_Jeonbuk = { "전체", "고창군", "군산시", "김제시", "남원시", "무주군", "부안군", "순창군", "완주군", "익산시", "임실군",
			"장수군", "전주시 덕진구", "전주시 완산구", "정읍시", "진안군" };
	// 제주
	static String[] Detail_Jeju = { "전체", "서귀포시", "제주시" };

	public void changeComboBox(ActionEvent e) {
		JComboBox cb = (JComboBox) e.getSource();
		switch ((String) cb.getSelectedItem()) {
		case "서울":
			Mainpage.ComboModel= new DefaultComboBoxModel(Detail_Seoul);
			Mainpage.Detail_Area.setModel(Mainpage.ComboModel);
			crolling.area = "I000";
			break;
		case "경기":
			Mainpage.ComboModel= new DefaultComboBoxModel(Detail_Gyeonggi);
			Mainpage.Detail_Area.setModel(Mainpage.ComboModel);
			crolling.area = "B000";
			break;
		case "인천":
			Mainpage.ComboModel= new DefaultComboBoxModel(Detail_Incheon);
			Mainpage.Detail_Area.setModel(Mainpage.ComboModel);
			crolling.area = "K000";
			break;
		case "강원":
			Mainpage.ComboModel= new DefaultComboBoxModel(Detail_Gangwon);
			Mainpage.Detail_Area.setModel(Mainpage.ComboModel);
			crolling.area = "A000";
			break;
		case "대전":
			Mainpage.ComboModel= new DefaultComboBoxModel(Detail_Daejeon);
			Mainpage.Detail_Area.setModel(Mainpage.ComboModel);
			crolling.area = "G000";
			break;
		case "세종":
			Mainpage.ComboModel= new DefaultComboBoxModel(Detail_Sejong);
			Mainpage.Detail_Area.setModel(Mainpage.ComboModel);
			crolling.area = "1000";
			break;
		case "충남":
			Mainpage.ComboModel= new DefaultComboBoxModel(Detail_Chungnam);
			Mainpage.Detail_Area.setModel(Mainpage.ComboModel);
			crolling.area = "O000";
			break;
		case "충북":
			Mainpage.ComboModel= new DefaultComboBoxModel(Detail_Chungbuk);
			Mainpage.Detail_Area.setModel(Mainpage.ComboModel);
			crolling.area = "P000";
			break;
		case "부산":
			Mainpage.ComboModel= new DefaultComboBoxModel(Detail_Busan);
			Mainpage.Detail_Area.setModel(Mainpage.ComboModel);
			crolling.area = "H000";
			break;
		case "울산":
			Mainpage.ComboModel= new DefaultComboBoxModel(Detail_Ulsan);
			Mainpage.Detail_Area.setModel(Mainpage.ComboModel);
			crolling.area = "J000";
			break;
		case "경남":
			Mainpage.ComboModel= new DefaultComboBoxModel(Detail_Gyeongnam);
			Mainpage.Detail_Area.setModel(Mainpage.ComboModel);
			crolling.area = "C000";
			break;
		case "경북":
			Mainpage.ComboModel= new DefaultComboBoxModel(Detail_Gyeongbuk);
			Mainpage.Detail_Area.setModel(Mainpage.ComboModel);
			crolling.area = "D000";
			break;
		case "대구":
			Mainpage.ComboModel= new DefaultComboBoxModel(Detail_Dae_gu);
			Mainpage.Detail_Area.setModel(Mainpage.ComboModel);
			crolling.area = "F000";
			break;
		case "광주":
			Mainpage.ComboModel= new DefaultComboBoxModel(Detail_Gwangju);
			Mainpage.Detail_Area.setModel(Mainpage.ComboModel);
			crolling.area = "E000";
			break;
		case "전남":
			Mainpage.ComboModel= new DefaultComboBoxModel(Detail_Jeonnam);
			Mainpage.Detail_Area.setModel(Mainpage.ComboModel);
			crolling.area = "L000";
			break;
		case "전북":
			Mainpage.ComboModel= new DefaultComboBoxModel(Detail_Jeonbuk);
			Mainpage.Detail_Area.setModel(Mainpage.ComboModel);
			crolling.area = "M000";
			break;
		case "제주":
			Mainpage.ComboModel= new DefaultComboBoxModel(Detail_Jeju);
			Mainpage.Detail_Area.setModel(Mainpage.ComboModel);
			crolling.area = "N000";
			break;
		default:
			
			crolling.area = "";
			break;

		}

	}

}
