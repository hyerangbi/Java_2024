package com.kh.etc.chat;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component // 어노테이션이 (chatServer 로) Bean 에 등록 됨 
public class ChatServer extends TextWebSocketHandler{
	
	private final Map<String, WebSocketSession> userSession = new ConcurrentHashMap<>();

	// 클라이언트가 연결을 맺을 때 호출이 되는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String nick = (String)session.getAttributes().get("nick");
		log.info("연결됨 ...", nick);
		
		userSession.put(nick, session);
	}

	// 클라이언트로부터 메세지를 받을 때 호출되는 메소드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		// 세션에 저장되어있는 발송자 닉네임 가져오기
		String nick = (String)session.getAttributes().get("nick"); // 서비스에서는 로그인 유저에 담겨져있다.
		
		// 메시지 payload 를 json 객체로 파싱
		JsonObject obj = new JsonParser().parse(message.getPayload()).getAsJsonObject();
		
		log.info("message : {}", obj.get("message").getAsString());
		log.info("message : {}", obj.get("target").getAsString());
		
		MsgVo vo = new MsgVo();
		vo.setMsg(obj.get("message").getAsString()); // 메세지
		vo.setNick(nick); // 발신자
		vo.setTargetNick(obj.get("target").getAsString()); // 수신자
		vo.setTime(new Date().toLocaleString()); // 밑줄은 신버전을 사용하면 좋다고 업데이트가 있는 것을 사용 권장한다는 뜻 (구버전 이라는 뜻)
		
		sendMessageUser(vo);
		
		
	}
	
	// 특정 사용자에게 메세지를 전송하는 메소드
	private void sendMessageUser(MsgVo vo) {
		
		WebSocketSession mySession = userSession.get(vo.getNick());
		// 수신자 세션정보 가져오기
				WebSocketSession targetSession = userSession.get(vo.getTargetNick());
				
				if(targetSession != null && targetSession.isOpen()) { // 자바의 단점 무조건 null check
					
					String str = new Gson().toJson(vo);
					// 웹소켓 텍스트 전송규격 메세지로 변환한다.
					TextMessage msg = new TextMessage(str);
					log.info("msg: {}", vo.getMsg());
					try {
						targetSession.sendMessage(msg); // 누가 보냈는지, 어떤 내용, 몇 시 그런 내용들이 다 들어있다.
						mySession.sendMessage(msg); // 내가 보낸 메시지 도 받는다.
					} catch(IOException e) {
						e.printStackTrace();
					}
				}
	}

	// 클라이언트가 연결을 끊을 때 호출되는 메소드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
	}
	
}
