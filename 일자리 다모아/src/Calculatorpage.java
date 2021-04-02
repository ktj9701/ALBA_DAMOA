// 계산기 gui 구현 클래스


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Calculatorpage extends JFrame {
	static JComboBox Before, After, week_num, Worktime;
	static JRadioButton Tex[] = new JRadioButton[2];
	ButtonGroup group = new ButtonGroup();
	static JTextField Pay = new JTextField(10);
	JLabel errorlabel = new JLabel("입력을 하지 않았습니다.");

	static JButton Reset = new JButton("초기화");
	static JButton Calculation = new JButton("계산");

	
	static JLabel Result_pay__Integer_label= new JLabel("원");
	static JLabel Extra_pay_Integer_label= new JLabel("원");
	static JLabel Total_pay_Integer_label= new JLabel("원");
	static JLabel Tex_pay__Integer_label= new JLabel("원");
	
	Buttonlistener listener = new Buttonlistener();
	Radiolistener radiolistener = new Radiolistener();

	static boolean Tex_flag = false; // 세금 적용 여부

	
	DecimalFormat formatter= new DecimalFormat("###,###");
	public Calculatorpage() {
		setTitle("월급 계산기");
		setSize(400, 600);
		this.setLayout(null);
		setVisible(true);
		setResizable(false); // 프로그램 크기 조절 불가 설정
		setLocationRelativeTo(null); // 화면 중앙에 오도록 하는 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ----------------------- 콤보 박스 ----------------------------------
		String[] kinds = { "시급", "일급", "월급", "연봉" };
		Before = new JComboBox(kinds);
		Before.setSelectedIndex(0);
		Before.setBounds(60, 30, 70, 30);
		Before.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(Before);

		After = new JComboBox(kinds);
		After.setSelectedIndex(1);
		After.setBounds(260, 30, 70, 30);
		After.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(After);

		JLabel Changelabel = new JLabel("을(를)     으로");
		Changelabel.setBounds(150, 30, 100, 30);
		Changelabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(Changelabel);

		// ---------------------- 페이 입력 ---------------------------
		Pay.setBounds(230, 100, 100, 30);
		Pay.setText("");
		Pay.setHorizontalAlignment(JTextField.RIGHT);

		Pay.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(Pay);

		JLabel Kindpaylabel;
		Kindpaylabel = new JLabel((String) Before.getSelectedItem());
		Kindpaylabel.setBounds(110, 100, 30, 30);
		Kindpaylabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(Kindpaylabel);

		JLabel Paylabel = new JLabel("원");
		Paylabel.setBounds(335, 100, 30, 30);
		Paylabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(Paylabel);

		errorlabel.setBounds(230, 130, 150, 30);
		errorlabel.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		errorlabel.setForeground(Color.RED);
		errorlabel.setVisible(false);
		add(errorlabel);

		// ---------------------- 주간 근무 횟수 입력 ---------------------------
		String[] num = { "0번", "1번", "1번", "2번", "3번", "4번", "5번", "6번", "7번" };
		week_num = new JComboBox(num);
		week_num.setSelectedIndex(6);
		week_num.setBounds(230, 170, 100, 30);
		week_num.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(week_num);

		JLabel weeklabel = new JLabel("주간 근무 일수");
		weeklabel.setBounds(110, 170, 100, 30);
		weeklabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(weeklabel);

		// ---------------------- 시간 선택 ---------------------------
		String[] time = { "1시간", "2시간", "3시간", "4시간", "5시간", "6시간", "7시간", "8시간", "9시간", "10시간", "11시간", "12시간" };
		Worktime = new JComboBox(time);
		Worktime.setSelectedIndex(7);
		Worktime.setBounds(230, 230, 100, 30);
		Worktime.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(Worktime);

		JLabel timelabel = new JLabel("근무 시간");
		timelabel.setBounds(110, 230, 100, 30);
		timelabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(timelabel);

		// --------------------- 세금 적용 여부 --------------------------

		Tex[0] = new JRadioButton();
		Tex[1] = new JRadioButton();
		Tex[0].setText("소득세 적용(3.3%)");
		Tex[1].setText("적용 안함");
		Tex[0].setBounds(50, 290, 150, 30);
		Tex[1].setBounds(220, 290, 100, 30);
		Tex[0].setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Tex[1].setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Tex[1].setSelected(true);
		group.add(Tex[0]);
		group.add(Tex[1]);
		add(Tex[0]);
		add(Tex[1]);

		Reset.setBounds(80, 340, 100, 30); // -----------------------초기화 버튼
		Reset.setVisible(true);
		add(Reset);

		Calculation.setBounds(230, 340, 100, 30); // -----------------------초기화 버튼
		Calculation.setVisible(true);
		add(Calculation);
          // ----------------------------------------결과 레이블-----------------------------
		JLabel Result_pay_label = new JLabel("예상 급여(+)");
		Result_pay_label.setBounds(30, 400, 100, 30);
		Result_pay_label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(Result_pay_label);

		Result_pay__Integer_label.setHorizontalAlignment(JLabel.RIGHT);
		Result_pay__Integer_label.setBounds(250, 400, 100, 30);
		Result_pay__Integer_label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(Result_pay__Integer_label);

		JLabel Extra_pay_label = new JLabel("예상 주휴 수당(+)");
		Extra_pay_label.setBounds(30, 430, 100, 30);
		Extra_pay_label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(Extra_pay_label);

		Extra_pay_Integer_label.setHorizontalAlignment(JLabel.RIGHT);
		Extra_pay_Integer_label.setBounds(250, 430, 100, 30);
		Extra_pay_Integer_label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(Extra_pay_Integer_label);
		
		JLabel Tex_pay_label = new JLabel("소득세(-)");
		Tex_pay_label.setBounds(30, 460, 100, 30);
		Tex_pay_label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(Tex_pay_label);

		Tex_pay__Integer_label.setHorizontalAlignment(JLabel.RIGHT);
		Tex_pay__Integer_label.setBounds(250, 460, 100, 30);
		Tex_pay__Integer_label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(Tex_pay__Integer_label);
		
		JLabel device_label = new JLabel("-------------------------------------------------------");
		device_label.setBounds(30, 490, 350, 30);
		device_label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(device_label);
		
		
		JLabel Total_pay_label = new JLabel("최종 급여");
		Total_pay_label.setBounds(30, 510, 100, 30);
		Total_pay_label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(Total_pay_label);

		Total_pay_Integer_label.setHorizontalAlignment(JLabel.RIGHT);
		Total_pay_Integer_label.setBounds(250, 510, 100, 30);
		Total_pay_Integer_label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(Total_pay_Integer_label);
		
		
		Reset.addActionListener(listener);
		Calculation.addActionListener(listener);
		Tex[0].addItemListener(radiolistener);
		Tex[1].addItemListener(radiolistener);
	}

	class Buttonlistener implements ActionListener { // 계산 및 리셋 버튼 이벤트
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == Reset) { // 리셋 버튼
				Before.setSelectedIndex(0);
				After.setSelectedIndex(1);
				Worktime.setSelectedIndex(7);
				Pay.setText("");
				Tex[1].setSelected(true);
				Tex_flag = false;
				errorlabel.setVisible(false);

			} else if (e.getSource() == Calculation) { // 계산 버튼
				if (Pay.getText().equals("")) // 임금을 입력하지 않았으면
					errorlabel.setVisible(true);
				else {
					Calculation_function process = new Calculation_function();
					Result_pay__Integer_label.setText(formatter.format(process.Result_pay_function())+"원");
					Extra_pay_Integer_label.setText(formatter.format(process.extra_pay_function())+"원");
					Tex_pay__Integer_label.setText(process.Tex_function()+"원");
					Total_pay_Integer_label.setText(formatter.format(process.total_function())+"원");
				}
			}
		}
	}

	class Radiolistener implements ItemListener { // 소득세 여부 버튼 이벤트
		public void itemStateChanged(ItemEvent e) {
			if (Tex[0].isSelected()) {
				Tex_flag =true;
			}
		}
	}
}