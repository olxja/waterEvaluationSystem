package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FTP上传下载
 * 
 * @author dragonwu
 */
public class FTPUtils {
	private final static String url = "121.40.80.6";
	private final static int port = 21;
	private final static String username = "panda";
	private final static String passwd = "uploadpanda";
	private final static Logger logger = LoggerFactory
			.getLogger(FTPUtils.class);

	private static FTPClient ftpClient = new FTPClient();
	private static String encoding = System.getProperty("file.encoding");

	public static boolean uploadFile(String path, String filename,
			InputStream input) {
		return uploadFile(url, port, username, passwd, path, filename, input);
	}

	/**
	 * Description: 向FTP服务器上传文�?
	 * 
	 * @Version1.0
	 * @param url
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端�?
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * @param path
	 *            FTP服务器保存目�?,如果是根目录则为�?/�?
	 * @param filename
	 *            上传到FTP服务器上的文件名
	 * @param input
	 *            本地文件输入�?
	 * @return 成功返回true，否则返回false
	 */
	private static boolean uploadFile(String url, int port, String username,
			String password, String path, String filename, InputStream input) {
		boolean result = false;

		try {
			int reply;
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务�?
			// ftpClient.connect(url);
			ftpClient.connect(url, port);// 连接FTP服务�?
			// 登录
			ftpClient.login(username, password);
			ftpClient.setControlEncoding(encoding);
			// �?验是否连接成�?
			reply = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				logger.info("连接失败");
				ftpClient.disconnect();
				return result;
			}

			// 转移工作目录至指定目录下
			boolean change = ftpClient.changeWorkingDirectory(path);
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			if (change) {
				result = ftpClient.storeFile(
						new String(filename.getBytes(encoding), "iso-8859-1"),
						input);
				if (result) {
					logger.info("上传成功!");
				}
			}
			input.close();
			ftpClient.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return result;
	}

	/**
	 * Description: 从FTP服务器下载文�?
	 * 
	 * @Version1.0
	 * @param url
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端�?
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * @param remotePath
	 *            FTP服务器上的相对路�?
	 * @param fileName
	 *            要下载的文件�?
	 * @param localPath
	 *            下载后保存到本地的路�?
	 * @return
	 */
	private static boolean downFile(String url, int port, String username,
			String password, String remotePath, String fileName,
			String localPath) {
		boolean result = false;
		try {
			int reply;
			ftpClient.setControlEncoding(encoding);

			/*
			 * 为了上传和下载中文文件，有些地方建议使用以下两句代替 new
			 * String(remotePath.getBytes(encoding),"iso-8859-1")转码�?
			 * 经过测试，�?�不过�??
			 */
			// FTPClientConfig conf = new
			// FTPClientConfig(FTPClientConfig.SYST_NT);
			// conf.setServerLanguageCode("zh");

			ftpClient.connect(url, port);
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务�?
			ftpClient.login(username, password);// 登录
			// 设置文件传输类型为二进制
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			// 获取ftp登录应答代码
			reply = ftpClient.getReplyCode();
			// 验证是否登陆成功
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				System.err.println("FTP server refused connection.");
				return result;
			}
			// 转移到FTP服务器目录至指定的目录下
			ftpClient.changeWorkingDirectory(new String(remotePath
					.getBytes(encoding), "iso-8859-1"));
			// 获取文件列表
			FTPFile[] fs = ftpClient.listFiles();
			for (FTPFile ff : fs) {
				if (ff.getName().equals(fileName)) {
					File localFile = new File(localPath + "/" + ff.getName());
					OutputStream is = new FileOutputStream(localFile);
					ftpClient.retrieveFile(ff.getName(), is);
					is.close();
				}
			}

			ftpClient.logout();
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		FTPUtils fa = new FTPUtils();
		String path = "/Users/dragonwu/Work/2ab8b63d-6dad-44c1-833f-b24fde70fcca.jpg";
		File f = new File(path);
		try {
			FileInputStream input = new FileInputStream(f);
			System.out
					.println(FTPUtils.uploadFile("idcard", f.getName(), input));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
