package com.muran.api;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.muran.application.GlobalConfig;
import com.muran.util.FileUtil;

@Component
@Path("/upload")
public class UploadApi extends AbstractApi {

	private final static Logger log = Logger.getLogger(FileUtil.class);

	private String basePath = "";

	/**
	 * 第一种方式上传
	 * 
	 * @param fileInputStream
	 * @param disposition
	 * @return
	 */
	@POST
	@Path("/stream")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadByStream(
			@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition disposition) {

		basePath = request.getSession().getServletContext().getRealPath("/")
				+ "/upload/web/";
		//
		String fileName = Calendar.getInstance().getTimeInMillis()
				+ disposition.getFileName();

		String filePath = basePath + fileName;

		log.info("basePath:" + basePath);
		log.info("filePath:" + filePath);
		// 存储
		FileUtil.saveFile(fileInputStream, filePath);
		// 网络地址
		String url = GlobalConfig.KEY_WEB_BASE + "upload/web/" + fileName;

		return Response.ok().entity(url).build();
	}

	/**
	 * * 第二种方式上传 使用FormDataMultiPart 获取表单数据
	 * 
	 * @param form
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@POST
	@Path("/form")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response uploadByForm(FormDataMultiPart form,
			@Context HttpServletResponse response)
			throws UnsupportedEncodingException {

		basePath = request.getSession().getServletContext().getRealPath("/")
				+ "/upload/web/";

		// 获取文件流
		FormDataBodyPart filePart = form.getField("file");
		// 获取表单的其他数据
		// FormDataBodyPart usernamePart = form.getField("filename");
		// 把表单内容转换成流
		InputStream fileInputStream = filePart.getValueAs(InputStream.class);

		FormDataContentDisposition formDataContentDisposition = filePart
				.getFormDataContentDisposition();

		String source = formDataContentDisposition.getFileName();

		String filename = new String(source.getBytes("ISO8859-1"), "UTF-8");

		filename = Calendar.getInstance().getTimeInMillis() + filename;

		log.info("formDataContentDisposition.getFileName() " + filename);
		String filePath = basePath + filename;
		// 存储
		FileUtil.saveFile(fileInputStream, filePath);
		// 网络地址
		String url = GlobalConfig.KEY_WEB_BASE + "upload/web/" + filename;
		response.setCharacterEncoding("UTF-8");
		return Response.ok().entity(url).build();
	}
}
