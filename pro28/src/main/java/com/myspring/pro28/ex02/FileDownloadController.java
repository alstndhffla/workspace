package com.myspring.pro28.ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.coobird.thumbnailator.Thumbnails;

/*@Controller*/
public class FileDownloadController {
	private static String CURR_IMAGE_REPO_PATH = "c:\\spring\\image_repo";
	
	//원본 이미지에 대해 썸네일 이미지 파일을 생성한 후 다운로드할 수 있도록.
//	@RequestMapping("/download")
//	protected void download(@RequestParam("imageFileName") String imageFileName,
//			                 HttpServletResponse response) throws Exception {
//		OutputStream out = response.getOutputStream();
//		String filePath = CURR_IMAGE_REPO_PATH + "\\" + imageFileName;
//		File image = new File(filePath);
//		
//		//확장자를 제외한 원본 이미지 파일의 이름을 가져온다.
//		int lastIndex = imageFileName.lastIndexOf(".");
//		String fileName = imageFileName.substring(0,lastIndex);
//		
//		//원본 이미지 파일 이름과 같은 이름의 썸네일 파일에 대한 File 객체를 생성한다.
//		File thumbnail = new File(CURR_IMAGE_REPO_PATH+"\\"+"thumbnail"+"\\"+fileName+".png");
//		
//		//원본 이미지 파일을 가로세로가 50픽셀인 png 형식의 썸네일 이미지 파일로 생성. 
//		if (image.exists()) { 
//			thumbnail.getParentFile().mkdirs();
//		    Thumbnails.of(image).size(50,50).outputFormat("png").toFile(thumbnail);
//		}
//		
//		//생성된 썸네일 파일을 브라우저로 전송
//		FileInputStream in = new FileInputStream(thumbnail);
//		byte[] buffer = new byte[1024 * 8];
//		while (true) {
//			int count = in.read(buffer); // 버퍼에 읽어들인 문자개수
//			if (count == -1) // 버퍼의 마지막에 도달했는지 체크
//				break;
//			out.write(buffer, 0, count);
//		}
//		in.close();
//		out.close();
//	}
	
	//썸네일 이미지 파일을 따로 생성할 필요 없이 썸네일 이미지 자체를 바로 다운로드 하도록(위 메서드의 상위버전) - 쇼핑몰의 상품 목록 이미지 같은 경우.
	@RequestMapping("/download")
	protected void download(@RequestParam("imageFileName") String imageFileName,
			                 HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath = CURR_IMAGE_REPO_PATH + "\\" + imageFileName;
		File image = new File(filePath);
		int lastIndex = imageFileName.lastIndexOf(".");
		String fileName = imageFileName.substring(0,lastIndex);
		File thumbnail = new File(CURR_IMAGE_REPO_PATH+"\\"+"thumbnail"+"\\"+fileName+".png");
		if (image.exists()) { 
			Thumbnails.of(image).size(50,50).outputFormat("png").toOutputStream(out);	//원본 이미지에 대한 썸네일 이미지를 생성한 후 OutStream 객체에 할당한다.
		}else {
			return;
		}

		//썸네일 이미지를 OutStream 객체를 이용해 브라우저로 전송한다.
		byte[] buffer = new byte[1024 * 8];
		out.write(buffer);
		
		out.close();
	}
}
