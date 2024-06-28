package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.MocaDeleteProService;
import vo.ActionForward;

public class MocaDeleteProAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		int r_no = Integer.parseInt(request.getParameter("r_no"));
		String nowPage = request.getParameter("page");
		MocaDeleteProService mocaDeleteProService = new MocaDeleteProService();
		boolean isDeleteSuccess = mocaDeleteProService.removeRoom(r_no);

		if (!isDeleteSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('다시 시도해주세요.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("mocaList.mc");
		}

		return forward;
	}

}