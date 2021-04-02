// 로그인 화면 구현

import javax.swing.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Loginpage extends JFrame {
	Buttonlistener Loginlistener = new Buttonlistener();

	Font Title_Font = new Font("맑은 고딕", Font.BOLD, 30);
	static JLabel Title = new JLabel("일자리 다모아"); // 프로그램 제목 훗날 사진으로 대체할 예
	static JLabel ID = new JLabel("아이디");
	static JLabel PW = new JLabel("비밀번호");
	static JLabel fail = new JLabel("회원이 아니거나 아이디와 비밀번호가 일치 하지않습니다.");
	static TextField ID_ = new TextField(10);
	static TextField PW_ = new TextField(10);
	static Button Login = new Button("로그인");
	static Button Join = new Button("회원가입");

	static String name = "누굴까"; // -----------회원가입 시험을 위한 테스트 나중에 삭제해야함

	public Loginpage() {
		setTitle("로그인");
		setSize(main.SCREEN_WIDTH, main.SCREEN_HEIGHT);
		this.setLayout(null);
		setVisible(true);
		setResizable(false); // 프로그램 크기 조절 불가 설정
		setLocationRelativeTo(null); // 화면 중앙에 오도록 하는 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Title.setBounds(418, 122, 300, 30); // ------------------------------제목
		Title.setFont(Title_Font);
		Title.setVisible(true);

		ID.setBounds(398, 353, 50, 30); // --------------------------------ID 레이블
		ID.setVisible(true);

		PW.setBounds(398, 396, 50, 30); // ----------------------------PW 레이블
		PW.setVisible(true);

		ID_.setBounds(463, 355, 200, 20); // --------------------------ID & PW 텍스트필드
		PW_.setBounds(463, 398, 200, 20);  
		
		ID_.setVisible(true);
		PW_.setVisible(true);

		Login.setBounds(420, 460, 50, 30); // ---------------------로그인 버튼
		Login.setVisible(true);

		Join.setBounds(560, 460, 50, 30); // -----------------------회원 가입 버튼
		Join.setVisible(true);

		fail.setBounds(420, 420, 400, 30); // ----------------로그인 실패 레이블
		fail.setForeground(Color.red);
		fail.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		fail.setVisible(false);
		add(fail);
		this.add(Title);
		this.add(ID);
		this.add(PW);
		this.add(ID_);
		this.add(PW_);
		this.add(Login);
		this.add(Join);

		Login.addActionListener(Loginlistener); // -------------------------이벤트처리
		Join.addActionListener(Loginlistener);
	}

	class Buttonlistener implements ActionListener { // 버튼 이벤트
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == Login) { // 로그인 버튼 클릭
				
				if (ID_.getText().equals("admin") && (PW_.getText().equals("1234"))) {
					System.out.println("로그인 중");
					Mainpage mainPage = new Mainpage();
					dispose(); // 프레임삭제
					mainPage.setVisible(true); // 새로운 프레임
				}
				if (ID_.getText().equals(name) && (PW_.getText().equals("1234"))) { // -----------회원가입 시험을 위한 테스트 나중에
																					// 삭제해야함
					Mainpage mainPage = new Mainpage();
					dispose(); // 프레임삭제
					mainPage.setVisible(true); // 새로운 프레임
				} else { // ---------------------------------로그인 실패
					ID_.setText("");
					PW_.setText("");
					fail.setVisible(true);
				}
			} else if (event.getSource() == Join) { // 회원 가입 버튼 클릭
				ID_.setText("");
				PW_.setText("");
				Joinpage JoinPage = new Joinpage();
				dispose(); // 프레임삭제
				JoinPage.setVisible(true); // 새로운 프레임
			}

		}
	}
}
