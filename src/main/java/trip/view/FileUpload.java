package trip.view;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class FileUpload {

	private String ADDRESS = "210.114.6.195";
	private int PORT = 22;
	private String USERNAME = "lne8372";
	private String PASSWORD = "travel567!";
	private static Session session = null;
	private static Channel channel = null;
	private static ChannelSftp channelSftp = null;
	
	private static final String USER_PATH = "C:/uploadTemp/temp/";
	private static final String SERVER_PATH = "/lne8372/tomcat/webapps/ROOT/img/";
	private static final String DB_PATH = "http://lne8372.cafe24.com/img/";
	
	public static final int SUCCESS = 1;
	public static final int EXTENSION_ERORR = -1;
	public static final int OTHER_ERORR = -2;
	

	public String getUserPath() {
		return USER_PATH;
	}

	public String getServerPath() {
		return SERVER_PATH;
	}
	
	public String getDbPath() {
		return DB_PATH;
	}
	
	public void sshAccess() throws Exception {
		JSch jsch = new JSch();
		session = jsch.getSession(USERNAME, ADDRESS, PORT);
		session.setPassword(PASSWORD);
		java.util.Properties config = new java.util.Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		session.connect();
        channel = session.openChannel("sftp");
        channel.connect();
        channelSftp = (ChannelSftp) channel;
	}
	
	public void sshClose() {
		if(channelSftp!=null) channelSftp.disconnect();
		if(channel!=null) channel.disconnect();
		if(session!=null) session.disconnect();
	}
	
	public boolean sendFileToOtherServer(String sourcePath, String destinationPath) {
		try {
			sshAccess();
	        channelSftp.put(sourcePath, destinationPath);  //파일을 전송하는 메소드
	        return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			sshClose();
		}
    }

}
