// 메인 화면

import java.awt.Button;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Mainpage extends JFrame {
	Detail_Area Detail= new Detail_Area(); // 세부적인 지역 모음 클래스
	
	static Button Serch = new Button("검색");
	static Button Calculator = new Button("월급 계산기");
	
	static DefaultTableModel TableModel = new DefaultTableModel(); 
	static DefaultComboBoxModel ComboModel = new DefaultComboBoxModel();
	
	static String head[] = { "지역", "급여", "회사명", "내용", "등록 시간" };
	static TextField SerchField = new TextField();
	public static JScrollPane scroll;

	crolling crolling = new crolling();
	static Vector<Albatext> Alba;
	static Object arr[][];

	static JComboBox Area, Detail_Area;  //시, 도 콤보박스
	

//-------------------------------------이벤트 
	Buttonlistener listener = new Buttonlistener();
	
	
	
	
	
	
	public Mainpage() {
		setTitle("일자리 다모아");
		setSize(1500, 800);
		this.setLayout(null);
		setVisible(true);
		setResizable(false); // 프로그램 크기 조절 불가 설정
		setLocationRelativeTo(null); // 화면 중앙에 오도록 하는 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//----------------------------------------------------------광고 테이블 ------------------------------------------------------
		
		Search_Alba();
		JTable table = new JTable(TableModel);
		scroll = new JScrollPane(table);
		table.setFont(new Font("맑은 고딕", Font.BOLD, 25)); // 글자 크기 설정
		table.setRowHeight(25);
		scroll.setBounds(160, 130, 1325, 633);
		scroll.setVisible(true);
		add(scroll);

		// ----------------------------------------------------------검색 버튼과 검색 텍스트 필드
		Serch.setBounds(900, 30, 60, 60);
		Serch.setVisible(true);
		add(Serch);

		SerchField.setBounds(30, 40, 850, 40);
		SerchField.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		SerchField.setVisible(true);
		add(SerchField);

		Calculator.setBounds(1000, 30, 60, 60);
		Calculator.setVisible(true);
		add(Calculator);
		Calculator.addActionListener(listener);

		// ------------------------------------지역 콤보박스-------------------

		JLabel Province = new JLabel("지역");
		Province.setBounds(40, 90, 50, 30);
		Province.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(Province);
		String[] Korea_Province = { "선택","서울", "경기", "인천", "강원", "대전", "세종", "충남", "충복", "부산", "울산", "경남", "경북", "대구", "광주",
				"전남", "전북", "제주" };
		Area = new JComboBox(Korea_Province);
		Area.setSelectedIndex(0);
		Area.setBounds(100, 90, 70, 30);
		Area.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(Area);
		combolistener Combolistener = new combolistener();
		Area.addActionListener(Combolistener);
		// ------------------------------------세부적인 지역 콤보박스-------------------


		Detail_Area = new JComboBox();
	
		Detail_Area.setBounds(200, 90, 150, 30);
		Detail_Area.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Detail_Area.setVisible(false);
		add(Detail_Area);
			
	}	
	
	//------------------ 내부 클래스 및 메소드 구현
	
	class Buttonlistener implements ActionListener { // 버튼 이벤트
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == Calculator) {
				Calculatorpage calculator = new Calculatorpage();
				calculator.setVisible(true);
			}
		}
	}
	public class combolistener implements ActionListener { // 콤보박스 선택시 이벤트 발생 클래스
		public void actionPerformed(ActionEvent e) {
			JComboBox cb = (JComboBox) e.getSource();
			Detail_Area.setVisible(true);
			Detail.changeComboBox(e); // 콤보박스에 맞는 리스트 출력
			Detail_Area.setSelectedIndex(0);
			Search_Alba();
			
		}
	}
	

	
	public void Search_Alba() {  //광고 검색
		Alba = crolling.crolling();
		arr = new Object[Alba.size()][5];

		for (int i = 0; i < Alba.size(); i++) {
			int j = 0;
			arr[i][j++] = Alba.get(i).getArea();
			arr[i][j++] = Alba.get(i).getPay();
			arr[i][j++] = Alba.get(i).getOffice();
			arr[i][j++] = Alba.get(i).getText();
			arr[i][j++] = Alba.get(i).getTime();

		}
		TableModel.setDataVector(arr, head);
	}
}
