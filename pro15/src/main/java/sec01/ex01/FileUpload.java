package sec01.ex01;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		doHandle(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		String encoding="utf-8";
		
		//업로드할 파일 경로 지정( \ 는 \\ 2번 써야 인식 됨)
		File currentDirPath = new File("C:\\myJSP\\workspace\\file_repo");
		
		//이 클래스는 저장위치와 업로드 가능한 최대 파일 크기를 설정하게 한다.
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);	//파일 경로 설정
		factory.setSizeThreshold(1024*1024);//최대 업로드 파일 크기 설정
		
		//파일 업로드 창에서 업로드된 파일과 매개변수에 대한 정보를 가져와 
		//파일을 업로드하고 매개변수 값을 출력
		ServletFileUpload upload = new ServletFileUpload();
		try {
			List items = upload.parseRequest(request);	//request객체에서 매개변수를 List로 가져온다.
			for(int i=0; i<items.size(); i++) {
				FileItem fileItem = (FileItem)items.get(i);	//파일업로드창에서 업로드된 항목들을 하나씩 가져온다.
				
				//폼 필드이면 전송된 매개변수 값을 출력한다.
				if(fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName()+"="+fileItem.getString(encoding));}
				else {
					//폼 필드가 아니면 파일 업로드 기능을 수행한다.
					System.out.println("param name: "+ fileItem.getFieldName());
					System.out.println("filename: "+ fileItem.getName());
					System.out.println("filesize: "+ fileItem.getSize());
					
					//업로드한 파일이름을 가져온다.
					if(fileItem.getSize()>0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if(idx==-1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						String fileName = fileItem.getName().substring(idx+1);
						
						//업로드한 파일 이름으로 저장소에 파일을 업로드한다.
						File uploadFile = new File(currentDirPath+"\\"+fileName);
						fileItem.write(uploadFile);
					}//end if
				}//end if
			}//end for
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
