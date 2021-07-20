package trip.total.service;

public interface TotalVistitService {

		//금일 방문자수
		public int toDay();
		
		//누적 방문자수
		public int totalDay();
		
		//ip로 접속한 클라이언트가 금일 방문 했는지 확인
		public int ipSelect(String ip);
		
		//ip검색 통과 후 없으면 insert로 추가
		public int insertTotal(String ip);
		
		//로그인 할때 세션에서 그룹번호를 받아 ip검색 후 그곳에 update 한다.
		public int groupTotal(int type,int idx);
		
		//일반유저,사용자 의 오늘 방문자수 
		public int groupToday(int type);
		
		//일반유저,사용자 의 누적 방문자수
		public int groupTotalDay(int type);
		
		//금일 가입한 회원 타입별 보기
		public int typeJointoday(int type);
		
		//모든 회원 타입별 회원
		public int typeAllJoinday(int type);
		
	
}
