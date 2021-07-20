package trip.img.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public class ImgServiceImple implements ImgService {
	
	public ImgServiceImple() {
		
	}
	
	/*
	 * 
	 * 파일 경로에 관련된 메서드 묶음
	 * 
	 */
	public String tempDirName(int idx) {
		return "temp"+idx+"/";
	}
	public String tempPathName(int idx) {
		return SERVER_PATH+tempDirName(idx);
	}
	
	
	
	//PlanBbs관련
	public String planInfoImgUpdate(MultipartFile file) {
		File f = new File(SERVER_PATH+file.getOriginalFilename());
		if(f.exists()) f = dupleCheck(f);
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(f);
			fos.write(file.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return DB_PATH+f.getName();
	}
	public void planInfoImgDelete(String path) {
		File target = new File(SERVER_PATH + path.substring(path.lastIndexOf("/")+1));
		if(target.exists()) target.delete();
	}
	
	
	
	/*
	 *
	 * 임시폴더 내 파일 저장/삭제 기능 
	 * 
	 */
	/** 업데이트된 파일을 임시 폴더에 저장 */
	public String imgUpdate(MultipartFile file, int idx) {
		String tempPath = tempPathName(idx);
		File dir = new File(tempPath);
		if(!dir.exists()) dir.mkdirs();
		
		File f = new File(tempPath+file.getOriginalFilename());
		if(f.exists()) f = dupleCheck(f);
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(f);
			fos.write(file.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return DB_PATH+tempDirName(idx)+f.getName();
	}
	/** 임시 폴더 내의 파일을 삭제 */
	public void imgDelete(String path, int idx) {
		File target = new File(tempPathName(idx) + path.substring(path.lastIndexOf("/")+1));
		if(target.exists()) target.delete();
	}
	/** 임시 폴더 삭제 */
	public void deleteAllTempFile(int idx) {
		File dir = new File(tempPathName(idx));
		if(!dir.exists()) return;
		dirDelete(dir);
	}
	//실제 삭제 코드
	private void dirDelete(File f) {
		File[] files = f.listFiles();
		for(File temp : files) {
			if(temp.isDirectory()) {
				dirDelete(temp);
			} else {
				temp.delete();
			}
		}
		f.delete();
	}
	
	
	
	
	
	
	/*
	 *
	 * jsp와 연동되어 있어야 하는 데이터에 대한 메서드들
	 * 
	 */
	/** img 폴더에서 jsp에 사용될 파일들을 임시파일로 옮기는 메서드 */
	public void imgFileSetting(ArrayList<String> paths, int idx) {
		File dir = new File(tempPathName(idx));
		if(!dir.exists()) dir.mkdirs();
		
		for(String temp : paths) {
			String fileName = temp.substring(temp.lastIndexOf("/")+1);
			File origin = new File(SERVER_PATH + fileName);
			File target = new File(tempPathName(idx) + fileName);
			fileCopyMethod(origin, target);
		}
	}
	/** 임시파일에 있는 이미지를 img 폴더로 옮긴 후 DB에 저장될 값을 리스트로 만들어서 반환함 */ 
	public ArrayList<String> adImgSubmit(int idx) {
		File[] files = getTempFiles(idx);
		ArrayList<String> imgList = new ArrayList<String>();
		for(File temp : files) {
			String bbs_img = fileCopy(temp);
			imgList.add(bbs_img);
		}
		return imgList;
	}
	/** 파일을 실제 img 폴더로 옮기고 DB에 저장할 경로를 반환하는 메서드 */
	public String fileCopy(File f) {
		File copy = new File(SERVER_PATH+f.getName());
		if(copy.exists()) copy = dupleCheck(copy);
		f = fileCopyMethod(f, copy);
		return DB_PATH+f.getName();
	}
	
	/** 임시폴더에 있는 파일 목록 반환 */
	public File[] getTempFiles(int idx) {
		File f = new File(tempPathName(idx));
		return f.listFiles();
	}
	
	/** img에 있는 기존 파일들을 지우는 메서드 */
	public void removeAllFile(ArrayList<String> targets) {
		File dir = new File(SERVER_PATH);
		File[] files = dir.listFiles();
		HashMap<String, File> map = new HashMap<String, File>(); 
		for(File temp : files) map.put(temp.getName(), temp);
		for(String temp : targets) {
			String fileName = temp.substring(temp.lastIndexOf("/")+1);
			File targetFile = map.get(fileName);
			if(targetFile != null && targetFile.exists()) targetFile.delete(); 
		}
	}
	
	

	
	
	/*
	 *
	 * 파일 이름 변경데 해한 메서드들
	 * 
	 */
	//파일 이름 중복검사
	private File dupleCheck(File f) {
		File copy = null;
		if(f.exists()) {
			copy = setNewFileName(f);
			copy = fileCopyMethod(f, copy);
		}
		return copy;
	}
	//중복된 파일 이름을 새 파일 이름으로 바꾸어줌
	private File setNewFileName(File f) {
		File copy = null;
		if(f.exists()) {
			int random = (int) (Math.random()*100+1);
			copy = new File(f.getParent()+"/"+random+f.getName());
			setNewFileName(copy);
		}
		return copy;
	}
	//바꾼 이름을 토대로 실제 새 파일을 생성
	private File fileCopyMethod(File origin, File copy) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(origin);
			fos = new FileOutputStream(copy);
			int availableLen = fis.available();
			byte[] buf = new byte[availableLen];
			fis.read(buf);
			fos.write(buf);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return copy;
	}
}
