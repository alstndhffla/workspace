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
		
		//���ε��� ���� ��� ����( \ �� \\ 2�� ��� �ν� ��)
		File currentDirPath = new File("C:\\myJSP\\workspace\\file_repo");
		
		//�� Ŭ������ ������ġ�� ���ε� ������ �ִ� ���� ũ�⸦ �����ϰ� �Ѵ�.
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);	//���� ��� ����
		factory.setSizeThreshold(1024*1024);//�ִ� ���ε� ���� ũ�� ����
		
		//���� ���ε� â���� ���ε�� ���ϰ� �Ű������� ���� ������ ������ 
		//������ ���ε��ϰ� �Ű����� ���� ���
		ServletFileUpload upload = new ServletFileUpload();
		try {
			List items = upload.parseRequest(request);	//request��ü���� �Ű������� List�� �����´�.
			for(int i=0; i<items.size(); i++) {
				FileItem fileItem = (FileItem)items.get(i);	//���Ͼ��ε�â���� ���ε�� �׸���� �ϳ��� �����´�.
				
				//�� �ʵ��̸� ���۵� �Ű����� ���� ����Ѵ�.
				if(fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName()+"="+fileItem.getString(encoding));}
				else {
					//�� �ʵ尡 �ƴϸ� ���� ���ε� ����� �����Ѵ�.
					System.out.println("param name: "+ fileItem.getFieldName());
					System.out.println("filename: "+ fileItem.getName());
					System.out.println("filesize: "+ fileItem.getSize());
					
					//���ε��� �����̸��� �����´�.
					if(fileItem.getSize()>0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if(idx==-1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						String fileName = fileItem.getName().substring(idx+1);
						
						//���ε��� ���� �̸����� ����ҿ� ������ ���ε��Ѵ�.
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
