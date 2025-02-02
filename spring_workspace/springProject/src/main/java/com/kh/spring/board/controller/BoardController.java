package com.kh.spring.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;
import com.kh.spring.common.model.vo.PageInfo;
import com.kh.spring.common.template.Pagination;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bService;
	
	
	@RequestMapping("list.bo")  // list.bo?currentPage=xx   또는   list.bo
	public String selectBoardList(@RequestParam(value="currentPage", defaultValue="1") int currentPage, 
								Model model) {
		
		//System.out.println(currentPage);
		int listCount = bService.selectListCount();
		PageInfo pi = Pagination.getPageInfo(listCount, currentPage, 10, 5);
		ArrayList<Board> list = bService.selectBoardList(pi);
		
		model.addAttribute("pi", pi);
		model.addAttribute("list", list);
		
		return "board/boardListView";
		
	}
	
	@RequestMapping("enrollForm.bo")
	public String enrollForm() {
		return "board/boardEnrollForm";
	}
	
	@RequestMapping("insert.bo")
	public String insertBoard(Board b, MultipartFile upfile, 
							HttpSession session, Model model) {
		
		//System.out.println(b);
		//System.out.println(upfile.getOriginalFilename());
		// 첨부파일 업로드 기능을 하기 위해서는 라이브러리 2개 추가, 빈으로등록해야됨
		
		// 전달된 파일이 있을 경우 => 서버에 업로드 => 원본명, 저장경로 b에 담기
		if(!upfile.getOriginalFilename().equals("")) {
			
			/*
			// 파일을 업로드 시킬 폴더의 물리적인 경로 (savePath)
			String savePath = session.getServletContext().getRealPath("/resources/uploadFiles/");
			
			// 어떤 이름으로 업로드 시킬껀지의 수정명 (changeName)
			String originName = upfile.getOriginalFilename(); // flower.png
			
			String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			int ranNum = (int)(Math.random() * 90000 + 10000);
			String ext = originName.substring(originName.lastIndexOf("."));
			
			String changeName = currentTime + ranNum + ext; // 2020120217323045236.png
			
			try {
				upfile.transferTo(new File(savePath + changeName));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			*/
			String changeName = saveFile(session, upfile);
			
			b.setOriginName(upfile.getOriginalFilename());
			b.setChangeName("resources/uploadFiles/" + changeName); // "resources/uploadFiles/2020120217323045236.png"
			
		}
		
		int result = bService.insertBoard(b);
		
		if(result > 0) { // 성공
			session.setAttribute("alertMsg", "성공적으로 게시글이 등록되었습니다.");
			return "redirect:list.bo";
			
		}else { // 실패
			model.addAttribute("errorMsg", "게시글 작성 실패!");
			return "common/errorPage";
		}
		
		
	}
	
	@RequestMapping("detail.bo")
	public String selectBoard(int bno, Model model) {
		
		int result = bService.increaseCount(bno);
		
		if(result > 0) { // 유효한 게시글
			
			Board b = bService.selectBoard(bno);
			
			model.addAttribute("b", b);
			
			return "board/boardDetailView";
			
		}else { // 유효한 게시글 x
			model.addAttribute("errorMsg", "존재하지 않는 게시글이거나 삭제된 게시글입니다.");
			return "common/errorPage";
			
		}
		
	}
	
	
	@RequestMapping("delete.bo")
	public String deleteBoard(int bno, String fileName, HttpSession session, Model model) {
		
		int result = bService.deleteBoard(bno);
		
		if(result > 0) { // 기존의 파일 찾아서 삭제 => 게시글 리스트 페이지 재요청
			
			if(!fileName.equals("")) { // 기존의 첨부파일이 있었을 경우
				new File(session.getServletContext().getRealPath(fileName)).delete();
			}
			
			session.setAttribute("alertMsg", "성공적으로 게시글이 삭제되었습니다.");
			return "redirect:list.bo";
			
		}else {
			
			model.addAttribute("errorMsg", "게시글 삭제 실패");
			return "common/errorPage";
			
		}
		
	}
	
	@RequestMapping("updateForm.bo")
	public String updateForm(int bno, Model model) {
		
		//Board b = bService.selectBoard(bno);
		//model.addAttribute("b", b);
		model.addAttribute("b", bService.selectBoard(bno));
		return "board/boardUpdateForm";
		
	}
	
	
	@RequestMapping("update.bo")
	public String updateBoard(Board b, MultipartFile reupFile, HttpSession session, Model model) {
		
		if(!reupFile.getOriginalFilename().equals("")) { // 새로 전달된 첨부파일 있을 경우
			
			// 만약에 기존의 첨부파일이 있었을 경우 => 삭제
			if(b.getOriginName() != null) {
				new File(session.getServletContext().getRealPath(b.getChangeName())).delete();
			}
			
			// 새로 전달된 첨부파일 => 업로드
			String changeName = saveFile(session, reupFile);
			b.setOriginName(reupFile.getOriginalFilename());
			b.setChangeName("resources/uploadFiles/" + changeName);
			
		}
		
		/*
		 * Board b 객체의 필드 
		 * 
		 * 1. 새로 첨부된 파일 X, 기존의 첨부파일 X
		 *    --> originName:null, changeName:null
		 * 
		 * 2. 새로 첨부된 파일 X, 기존의 첨부파일 O
		 *    --> originName:기존의 첨부파일 원본명, changeName:기존의 첨부파일 저장경로
		 *    
		 * 3. 새로 첨부된 파일 O, 기존의 첨부파일 X
		 * 	  --> 새로운 첨부파일 업로드 후
		 *    --> originName:새로운 첨부파일 원본명, changeName:새로운 첨부파일 저장경로
		 * 
		 * 4. 새로 첨부된 파일 O, 기존의 첨부파일 O
		 *    --> 기존의 첨부파일 삭제 후
		 *    --> 새로운 첨부파일 업로드 후
		 *    --> originName:새로운 첨부파일 원본명, changeName:새로운 첨부파일 저장경로
		 * 
		 */
		
		int result = bService.updateBoard(b);
		
		if(result > 0) { // 게시글 수정 성공 => 상세보기 페이지 재요청(detail.bo)
			
			session.setAttribute("alertMsg", "성공적으로 게시글이 수정됐습니다");
			return "redirect:detail.bo?bno=" + b.getBoardNo();
			
		}else { // 게시글 수정 실패 
			model.addAttribute("errorMsg", "게시글 수정 실패");
			return "common/errorPage";
		}
		
		
	}
	
	
	
	
	
	// 첨부파일 업로드 시켜주는 메소드
	public String saveFile(HttpSession session, MultipartFile upfile) {
		
		// 파일을 업로드 시킬 폴더의 물리적인 경로 (savePath)
		String savePath = session.getServletContext().getRealPath("/resources/uploadFiles/");
		
		// 어떤 이름으로 업로드 시킬껀지의 수정명 (changeName)
		String originName = upfile.getOriginalFilename(); // flower.png
		
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		int ranNum = (int)(Math.random() * 90000 + 10000);
		String ext = originName.substring(originName.lastIndexOf("."));
		
		String changeName = currentTime + ranNum + ext; // 2020120217323045236.png
		
		try {
			upfile.transferTo(new File(savePath + changeName));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return changeName;
		
	}
	@ResponseBody
	@RequestMapping(value="rlist.bo", produces="application/json; charset=utf-8")
	public String selectReplyList(int bno) {
		
		ArrayList<Reply> list = bService.selectReplyList(bno);
		// list => JSON => String
		return new Gson().toJson(list);
	}
	
	@ResponseBody
	@RequestMapping("rinsert.bo")
	public String insertReply(Reply r) {
		
		int result = bService.insertReply(r);
		
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
		
		
	}
	

}







