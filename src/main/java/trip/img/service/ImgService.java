package trip.img.service;

import java.io.File;
import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

public interface ImgService {
	
	public static String SERVER_PATH = "/lne8372/tomcat/webapps/ROOT/img/";
	public static String DB_PATH = "http://lne8372.cafe24.com/img/";
	
	public String tempDirName(int idx);
	public String tempPathName(int idx);
	
	public String planInfoImgUpdate(MultipartFile file);
	public void planInfoImgDelete(String path);
	
	public String imgUpdate(MultipartFile file, int idx);
	public void imgDelete(String path, int idx);
	
	/** temp에 있는 파일 목록 반환 */
	public File[] getTempFiles(int idx);	
	/** 파일을 실제 img 폴더로 옮기고 DB에 저장할 경로를 반환하는 메서드 */
	public ArrayList<String> adImgSubmit(int idx);
	/** File을 실제 img 폴더로 옮기고 DB에 저장할 경로를 반환 */
	public String fileCopy(File f);
	/** img의 파일을 임시폴더에 옮기는 메서드 */
	public void imgFileSetting(ArrayList<String> paths, int idx);
	/** 임시 폴더 삭제 */
	public void deleteAllTempFile(int idx);
	/** img에 있는 기존 파일들을 지우는 메서드 */
	public void removeAllFile(ArrayList<String> targets);
}
