package min.page;

public class PageModule {
	
	public static String makePage(int totalCnt,int listSize, int pageSize, int cp, int day , int p_idx) {
		
		StringBuffer sb=new StringBuffer();
		
		//총게시글 총몇페이지
		int totalPage=(totalCnt/listSize)+1;
		if(totalCnt%listSize==0)totalPage--;
		
		//사용자 몇번째그룹인지
		int userGroup=cp/pageSize;
		if(cp%pageSize==0)userGroup--;
		
		//왼쪽 화살표 만들어주는 코드
		if(userGroup!=0) {
			sb.append("<a onclick='pageChange(");
			cp=(userGroup-1)*pageSize+pageSize;
			sb.append(cp);
			sb.append(",");
			sb.append(day);
			sb.append(",");
			sb.append(p_idx);
			sb.append(");'>&lt;&lt;</a>");
		}
		
		
		for(int i=userGroup*pageSize+1;
				i<=userGroup*pageSize+pageSize;i++) {
			sb.append("&nbsp;&nbsp;<a onclick='pageChange(");
			sb.append(cp);
			cp=i;
			sb.append(",");
			sb.append(day);
			sb.append(",");
			sb.append(p_idx);
			sb.append(");'>");
			sb.append(i);
			sb.append("</a>&nbsp;&nbsp;");
			
			if(i==totalPage) {
				break;
		
		}
		
		
		}
		
		if(userGroup!=(totalPage/pageSize-(totalPage%pageSize==0?1:0))) {
			sb.append("<a onclick='pageChange(");
			cp=(userGroup+1)*pageSize+1;
			sb.append(cp);
			sb.append(",");
			sb.append(day);
			sb.append(",");
			sb.append(p_idx);
			sb.append(");'>&gt;&gt</a>");
			
			
		}
		
		return sb.toString();

	}

}
