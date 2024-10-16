package com.kh.spring.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.member.model.vo.Member;
import com.kh.spring.member.service.MemberService;

// Bean에 Class를 등록하는 방법으로 @Component 을  클래스에 부여해주면 된다.
// @Controller -> @Component + Controller 객체가 가질 수 있는 예외처리 등이 추가된 어노테이션
// @RestController // 전부 리턴하겠따 무엇으로 ? 까먹었따 뭐지 ? 나중에 따로 만들어도 된다 근데 뭐로 리턴하는거지. 
@CrossOrigin
@Controller
public class MemberController {
	
	/* 
	 * @Autowired
	 * 의존성주입을 사용할 때 사용하는 어노테이션
	 * 클래스 네에서 필요한 객체를 직접 생성하지 않고 spring 컨테이너가 관리하는 객체(Bean)를 주입받아 사용할 수 있게 해준다.
	 * + 필드주입방식 / 생성자주입방식
	 */
	
	/*
	 * private MemberService memberService = new MemberServiceImpl();
	 * 기존 객체 생성 방식
	 * 객체 간의 결합도가 높아진다. (소스코드 수정이 일어날 경우 하나하나 전부 다 바꿔줘야 한다.)
	 * 서비스가 동시에 매우 많은 획수요청이 될 경우 그만큼 객체가 생성된다.
	 * 
	 * DI(Dependency Injection) - 의존성 주입
	 * 코드 결합도가 낮아지고 코드를 분리할 수 있다.
	 * 
	 * 필드 주입방식
	 * 스프링 컨테이너가 객체를 생성한 후, @Autowired 어노테이션이 붙은 필드에 의존성을 주입한다.
	 * 
	 * 생성자주입방식
	 * 스프링컨테이너가 객체를 생성할 때 생성자를 통해서 의존성을 주입한다.
	 * 
	 * 필드주입방식 보단 생성자주입방식이 좋다
	 * 필드주입방식 < 생성자 주입방식
	 * : 주입시점의 차이로 인해 객체가 완전히 초기화된 상태로 사용할 수 있음을 보장하고 
	 *   테스트 기능성과 유지보수성이 좋아진다.
	 * 
	 */
	
//	@Autowired
//	public MemberService memberService;
	
	private final MemberService memberService; //필드주입방식
	private final BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	public MemberController(MemberService memberService, BCryptPasswordEncoder bcryptPasswordEncoder) {
		this.memberService = memberService;
		this.bcryptPasswordEncoder = bcryptPasswordEncoder;
	}
	/*
	 * Spring에서 클라이언트가 보낸 정보를 받는 방법
	 * 
	 * 1. HttpServletRequest 를 활용해서 전달 값을 가져오는 방법
	 * 메소드에 매개변수로 HttpServletRequest를 작성해두면
	 * 스프링 컨테이너가 해당 메소드를 호출할 때 자동으로 객체 생성해서 매개변수로 주입해준다
	 */
	
	// method 마다 mapping
	
//	@RequestMapping("login.me")	
//	public String loginMember(HttpServletRequest request) {
//		String id = request.getParameter("userId");
//		String pwd = request.getParameter("userPwd");
//	
//		System.out.println(id);
//		System.out.println(pwd);
//		return null;
//	}
	
	/*
	 * 2. @RequestParam 어노테이션을 이용하는 방법ㄴ
	 * requset.getParameter(키)로 벨류를 추출하는 역할을 대신해주는 어노테이션
	 * value 속성의 값으로 jsp 에서 작성했던 name 속성 값을 담으면 알아서 해당 매개변수로 받아올 수 있다.
	 * 만약, 요청할 때의 값이 비어있는 경우 defalutValue 속성응로 기본 값을 지정할 수 있다.
	 * 
	 * default 와 같은 설정을 사용하지 않고 요청받은 key값과 매개변수 명을 동일하게 해준다면
	 * @RequestParam 을 생략할 수 있다.
	 */
	
//	@RequestMapping("login.me")
//	public String loginMember(@RequestParam(value="userId", default) String id, String userPwd) {
//		String id = request.getParameter("userId");
//		String pwd = request.getParameter("userPwd");
//		
//		System.out.println(id);
//		System.out.println(pwd);
//		return null;
//	}
	
	
	/*
	 * 3. 커맨드 객체 방식
	 * 
	 * 해당 메소드의 매개변수로
	 * 요청 시 전달  값을 담고자 하는 클래스 타입으로 만들어 준 뒤
	 * 전달 되는 key 값과 매개변수 클래스의 필드 명을 동일하게 작성해주면
	 * 객체를 생성하여 값을 담아서 전달해준다.
	 */
	
//	@RequestMapping("login.me")
//	public String loginMember(Member m) {		
		
//		Member loginMember = memberService.loginMember(m);
//		if (loginMember == null) {
//			System.out.println("로그인 실패");
//		} else {
//			System.out.println("로그인 성공");
//		}
//		
//		return "main";
		// /WEB-INF/views/main.jsp
//	}
	
	// 요청처리 후에 응답데이터를 담고 응답페이지로 포워딩 또는 url 재요청 처리하는 방법
	// 1. 스프링에서 제공하는 Model 객체를 이용해서 return 해주기
	
//	@RequestMapping("login.me")
//	public String loginMember(Member m, HttpSession session) {
//		
//		Member loginMember = memberService.loginMember(m);
//		
//		if (loginMember == null) {
//			System.out.println("로그인 실패");
//		} else {
//			System.out.println("로그인 성공", loginMember);
//		}
//		
//		return "main";
//		// /WEB-INF/views/main.jsp	
//		
//	}
	
	
	// 요청 처리 후에 응답 데이터를 담고 응답페이지로 포워딩 또는 url 재요청 처리 하는 방법
	/*
	 * 1. 스프링에서 제공하는 Model 객체를 이용하는 방법
	 * 포워딩할 응답뷰로 전달하고자하는 데이터를 (k-v)으로 담을 수 있는 영역
	 * Model 객체는 requestScope
	 * request.setAttribute() -> model.addAttribute()
	 */
//	
//	@RequestMapping("login.me")
//	public String loginMember(Member m, HttpSession session, Model model) {
//		Member loginMember = memberService.loginMember(m);
//		
//		if(loginMember == null) {
//			System.out.println("로그인실패"); //requestScope에 에러문구를 담는다.
//			
//			// WEB-INF/views/common/erroPage.jsp
//			return "/common/errorPage";
//			
//		} else {
//			session.setAttribute("loginUser", loginMember);
//			System.out.println("로그인 성공");
//			
//			return "redirect:/";
//		}
//	}
	
	
	// 2. 스프링에서 제공하는 ModelAndView 객체를 이용하면 데이터를 담고 리턴형식까지 지정할 수 있다	
	@RequestMapping("login.me")
	public ModelAndView loginMember(Member m, HttpSession session, ModelAndView mv, String saveId, HttpServletResponse response) {
		
//		
//		if(loginMember == null) {
//			System.out.println("로그인실패"); //requestScope에 에러문구를 담는다.
//			//model.addAttribute("errorMsg", "로그인실패"); 
//			mv.addObject("errorMsg", "로그인실패");
//			
//			
//			// WEB-INF/views/common/erroPage.jsp
//			//return "/common/errorPage";
//			mv.setViewName("common/errorPage");
//			
//		} else {
//			session.setAttribute("loginUser", loginMember);
//			System.out.println("로그인 성공");
//			
//			//return "redirect:/";
//			mv.setViewName("redirect:/");
//		
//		}
		
		/*
		 * 암호화 후
		 * Member m 의 id -> 사용자가 입력한 아이디
		 * Member m 의 pwd -> 사용자가 입력한 pwe(평문)
		 */
		Member loginMember = memberService.loginMember(m);
		
		// loginMember pwd -> 암호화된 비밀번호
		// bCryptPasswordEncoder -> matches(평문, 암호문) 메소드를 이용하여 내부적을 복호화작업 후 비교가 이루어진다.
		// 두 구문이 일치하면 true 를 반환 , 일치하지 않으면 false 를 반환
		// bCryptPasswordEncoder.matches(m.getUserpwd(), loginMember.getUserpwd());
		
		if(loginMember == null) { // 아이디가 없는 경우
			mv.addObject("errorMsg", "일치하는 아이디를 찾을 수 없습니다,");
			mv.setViewName("common/ErrorPage");
		} else if(!bcryptPasswordEncoder.matches(m.getUserpwd(), loginMember.getUserpwd())) { //비밀번호가 다른 경우
			mv.addObject("", "비밀번호가 일치하지 않습니다.");
			mv.setViewName("common/ErrorPage");
		} else {
			Cookie ck = new Cookie("saveId", loginMember.getUserId());
		}
		
		session.setAttribute("loginUser", loginMember);
		
		return mv;
		
	}
	
	@RequestMapping("logout.me")
	// @GetMapping("logout.me")
	public String logoutMember(HttpSession session) {
//		session.invalidate();
		session.removeAttribute("loginUser");
		
		return "redirect:/";
	}
	
	@RequestMapping("enrollForm.me")
	// @GetMapping("logout.me")
	public String enrollForm() {
		return "member/memberEnrollerForm";
	}
	
	/*
	 * ajax 요청에 대한 응답을 위한 controller 에는 @ResponseBody 어노테이션을 작성해줘야한다.
	 * 기본적인 세팅이 jsp 응답으로 되어있기 때문에  @ResponseBody 를 작성해주면
	 * 반환 값을 http 응답 객체에 직접 작성하겠따 라는 의미를 가지고 있다.
	 */
	@ResponseBody // 반환 값이 기본적으로 String 이다
	@RequestMapping("idCheck.me")
	// @GetMapping("logout.me")
	public String idCheck(String checkId) {
		int result = memberService.idCheck(checkId);
		
		if(result > 0) { // id 가 이미 존재하는 경우
			return "NNNNN";
		} else {
			return "NNNNY";
		}	
		
	}
	
	@RequestMapping("insert.me")
	public String insertMember(Member m, HttpSession session, Model model) {
		System.out.println(m);
		
		/*
		 * 인코딩 필터를 적용해줬기 때문에 한글을 잘 받을 수 있다.
		 * 
		 * age 같은 경우 int 로 필드를 구성할 경우 빈문자열이 전달되면 형변환과정에서 400에러가 발생한다.
		 * 400 에러는 보통 요청하는 데이터와 이를 받아주는 데이터가 일치하지 않아서 많이 발생한다.
		 * 
		 * semi 프로젝트의 단점 :
		 * 비밀번호가 사용자의 입력 그대로 전달된다. (평문)
		 * Bcrypt 방식을 이용해서 암호화 작업 후 저장을 하겠다.
		 * => 스프링시큐리티에서 제공하는 모듈을 이용한다. (pom.xml 에 라이브러리 추가 후 빈에 객체 등록한다.)
		 */
		
		String encPwd = bcryptPasswordEncoder.encode(m.getUserpwd());
		System.out.println(encPwd);
		
		int result = memberService.insertMember(m);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "성공적을오 회원가입이 완료 되었습니다.");
			return "redirect:/";
		} else {
			model.addAttribute("errorMsg", "회원가입 실패");
			return "common/errorPage";
		}
	}
	
	@RequestMapping("myPage.me")
	public String myPage() {
		return "member/myPage";
	}
	
	@RequestMapping("update.me")
	public String updateMember(Member m, HttpSession session, Model model) {
		int result = memberService.updateMember(m);
		
		if(result > 0) {
			session.setAttribute("loginUser", memberService.loginMember(m));
			session.setAttribute("alertMsg", "회원정보 수정 성공");
			return "redirect:/mypage.me";
		} else {
			model.addAttribute("errorMsg", "회원정보 수정 실패");
			return "common/errorPage";
		}
	}
	
	@RequestMapping("delete.me")
	public String deleteMember(Member m, HttpSession session) {
		
		// 비밀번호를 암호화 된 비밀번호와 비교
		String encPwd = ((Member)session.getAttribute("loginUser")).getUserpwd();
		
		// 일치하면 탈퇴처리 -> session 에서 로그인 정보 제거 -> 메인페이지
		
		
		// 일치하지 않으면 -> alertMsg : 비밀번호 다시 입력 -> 마이페이지
		if(bcryptPasswordEncoder.matches(m.getUserpwd(), encPwd)) {
			int result = memberService.deleteMember(m.getUserId());
			
			if(result > 0) {
				session.removeAttribute("loginUser");
				session.setAttribute("alertMsg", "회원탈퇴가 성공적으로 이루어졌습니다.");
				return "redirect:/";
			} else {
				session.setAttribute("alertMsg", "회원탈퇴처리 실패");
				return "redirect:/mypage.me";
			}
		} else { // 비밀번호 틀렸을 때
			session.setAttribute("alertMsg", "비밀번호를 다시 확인해주세요.");
			return "rediect:/mypage.me";
		}
	}
}
