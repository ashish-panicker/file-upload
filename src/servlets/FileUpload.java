package servlets;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUpload() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
//	private String getFileName(final Part part) {
//	    final String partHeader = part.getHeader("content-disposition");
//	    for (String content : part.getHeader("content-disposition").split(";")) {
//	        if (content.trim().startsWith("filename")) {
//	            return content.substring(
//	                    content.indexOf('=') + 1).trim().replace("\"", "");
//	        }
//	    }
//	    return null;
//	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
		if (isMultiPart) {
			FileItemFactory  factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List items = upload.parseRequest(request);
				Iterator iterator = items.iterator();
				while (iterator.hasNext()) {
					FileItem item = (FileItem) iterator.next();

					if (!item.isFormField()) {
						
						String fileName = item.getName();
						String root = getServletContext().getRealPath("/");
						File path = new File(root + "/uploads");
						if (!path.exists()) {
							boolean status = path.mkdirs();
						}

						File uploadedFile = new File(path + "/" + FilenameUtils.getName(fileName));
						System.out.println(uploadedFile.getAbsolutePath());
						item.write(uploadedFile);
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
	}

}
