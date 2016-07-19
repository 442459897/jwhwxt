package com.muran.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;

import com.muran.api.service.imp.PasswordService;

public class FileUtil {

	private final static Logger log = Logger.getLogger(FileUtil.class);

	public static void saveFile(byte[] bfile, String filePath, String fileName) {
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		File file = null;
		try {
			File dir = new File(filePath);
			if (!dir.exists()) {// 判断文件目录是否存在
				if (!dir.getParentFile().exists()) {
					dir.getParentFile().mkdirs();
				}
			}
			file = new File(filePath + "\\" + fileName);
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(bfile);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public static void saveFile(InputStream fileInputStream, String dstFilePath) {
		OutputStream outputStream = null;
		try {
			File file = new File(dstFilePath);
			if (!file.exists()) {
				if (!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();
				}
				outputStream = new FileOutputStream(new File(dstFilePath));
				int read = 0;
				byte[] bytes = new byte[1024];

				outputStream = new FileOutputStream(new File(dstFilePath));
				while ((read = fileInputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
			} else {
				log.info("文件已存在！");
			}
		} catch (IOException e) {
			log.error(e);
			e.printStackTrace();
		} finally {
			try {
				fileInputStream.close();
				outputStream.flush();
				outputStream.close();
			} catch (IOException e) {
				log.error("关闭流异常！");
				e.printStackTrace();
			}
		}
	}

}
