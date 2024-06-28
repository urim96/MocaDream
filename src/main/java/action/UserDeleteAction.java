package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.UserDeleteService;
import vo.ActionForward;

public class UserDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		ActionForward forward = null;
		String r_no = request.getParameter("r_no");
		String r_cal = request.getParameter("r_cal");
		String r_statime = request.getParameter("r_statime");
		String deleteId = "urim";
		UserDeleteService userDeleteService = new UserDeleteService();
		boolean deleteResult = userDeleteService.deleteOrderService(deleteId, r_no, r_cal, r_statime);

		if (deleteResult) {
			forward = new ActionForward();
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('취소가 완료되었습니다.');");
			out.println("</script>");
			forward.setRedirect(true);
			forward.setPath("myOrderList.mc");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('다시 시도해주세요.');");
			out.println("location.href='./myOrderList.mc';");
			out.println("</script>");
		}
		return forward;
	}

}
