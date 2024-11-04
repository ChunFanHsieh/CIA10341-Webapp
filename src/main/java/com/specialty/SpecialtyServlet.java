package com.specialty;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.specialty.SpecialtyService;
import com.specialty.SpecialtyVO;

public class SpecialtyServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        if ("getOne_For_Display".equals(action)) {
            List<String> errorMsgs = new LinkedList<>();
            req.setAttribute("errorMsgs", errorMsgs);

            try {
                /*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ******************************/
                String str = req.getParameter("specNo");
                if (str == null || (str.trim()).length() == 0) {
                    errorMsgs.add("請輸入占卜項目編號");
                }
                if (!errorMsgs.isEmpty()) {
                    RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
                    failureView.forward(req, res);
                    return;
                }

                Integer specNo = null;
                try {
                    specNo = Integer.valueOf(str);
                } catch (Exception e) {
                    errorMsgs.add("占卜項目編號格式不正確");
                }
                if (!errorMsgs.isEmpty()) {
                    RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
                    failureView.forward(req, res);
                    return;
                }

                /*************************** 2.開始查詢資料 *****************************************/
                SpecialtyService specialtySvc = new SpecialtyService();
                SpecialtyVO specialtyVO = specialtySvc.getOneSpecialty(specNo);
                if (specialtyVO == null) {
                    errorMsgs.add("查無資料");
                }
                if (!errorMsgs.isEmpty()) {
                    RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
                    failureView.forward(req, res);
                    return;
                }

                /*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
                req.setAttribute("specialtyVO", specialtyVO);
                String url = "/listOneSpecialty.jsp";
                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

            } catch (Exception e) {
                errorMsgs.add("無法取得資料:" + e.getMessage());
                RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
                failureView.forward(req, res);
            }
        }

        if ("getOne_For_Update".equals(action)) {
            List<String> errorMsgs = new LinkedList<>();
            req.setAttribute("errorMsgs", errorMsgs);

            try {
                /*************************** 1.接收請求參數 ****************************************/
                Integer specNo = Integer.valueOf(req.getParameter("specNo"));

                /*************************** 2.開始查詢資料 ****************************************/
                SpecialtyService specialtySvc = new SpecialtyService();
                SpecialtyVO specialtyVO = specialtySvc.getOneSpecialty(specNo);

                /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
                req.setAttribute("specialtyVO", specialtyVO);
                String url = "/update_specialty_input.jsp";
                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

            } catch (Exception e) {
                errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
                RequestDispatcher failureView = req.getRequestDispatcher("/listAllSpecialty.jsp");
                failureView.forward(req, res);
            }
        }

        if ("update".equals(action)) {
            List<String> errorMsgs = new LinkedList<>();
            req.setAttribute("errorMsgs", errorMsgs);

            try {
                /*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
                Integer specNo = Integer.valueOf(req.getParameter("specNo").trim());
                String specName = req.getParameter("specName");
                String specDesc = req.getParameter("specDesc");

                SpecialtyVO specialtyVO = new SpecialtyVO();
                specialtyVO.setSpecNo(specNo);
                specialtyVO.setSpecName(specName);
                specialtyVO.setSpecDesc(specDesc);

                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("specialtyVO", specialtyVO);
                    RequestDispatcher failureView = req.getRequestDispatcher("/update_specialty_input.jsp");
                    failureView.forward(req, res);
                    return;
                }

                /*************************** 2.開始修改資料 *****************************************/
                SpecialtyService specialtySvc = new SpecialtyService();
                specialtyVO = specialtySvc.updateSpecialty(specNo, specName, specDesc);

                /*************************** 3.修改完成,準備轉交(Send the Success view) *************/
                req.setAttribute("specialtyVO", specialtyVO);
                String url = "/listOneSpecialty.jsp";
                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

            } catch (Exception e) {
                errorMsgs.add("修改資料失敗:" + e.getMessage());
                RequestDispatcher failureView = req.getRequestDispatcher("/update_specialty_input.jsp");
                failureView.forward(req, res);
            }
        }

        if ("insert".equals(action)) {
            List<String> errorMsgs = new LinkedList<>();
            req.setAttribute("errorMsgs", errorMsgs);

            try {
                /*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
                Integer specNo = Integer.valueOf(req.getParameter("specNo").trim());
                String specName = req.getParameter("specName");
                String specDesc = req.getParameter("specDesc");

                SpecialtyVO specialtyVO = new SpecialtyVO();
                specialtyVO.setSpecNo(specNo);
                specialtyVO.setSpecName(specName);
                specialtyVO.setSpecDesc(specDesc);

                if (!errorMsgs.isEmpty()) {
                    req.setAttribute("specialtyVO", specialtyVO);
                    RequestDispatcher failureView = req.getRequestDispatcher("/addSpecialty.jsp");
                    failureView.forward(req, res);
                    return;
                }

                /*************************** 2.開始新增資料 ***************************************/
                SpecialtyService specialtySvc = new SpecialtyService();
                specialtyVO = specialtySvc.addSpecialty(specNo, specName, specDesc);

                /*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
                String url = "/listAllSpecialty.jsp";
                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

            } catch (Exception e) {
                errorMsgs.add("新增資料失敗:" + e.getMessage());
                RequestDispatcher failureView = req.getRequestDispatcher("/addSpecialty.jsp");
                failureView.forward(req, res);
            }
        }

        if ("delete".equals(action)) {
            List<String> errorMsgs = new LinkedList<>();
            req.setAttribute("errorMsgs", errorMsgs);

            try {
                /*************************** 1.接收請求參數 ***************************************/
                Integer specNo = Integer.valueOf(req.getParameter("specNo"));

                /*************************** 2.開始刪除資料 ***************************************/
                SpecialtyService specialtySvc = new SpecialtyService();
                specialtySvc.deleteSpecialty(specNo);

                /*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
                String url = "/listAllSpecialty.jsp";
                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

            } catch (Exception e) {
                errorMsgs.add("刪除資料失敗:" + e.getMessage());
                RequestDispatcher failureView = req.getRequestDispatcher("/listAllSpecialty.jsp");
                failureView.forward(req, res);
            }
        }
    }
}
