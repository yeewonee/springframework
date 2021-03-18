package com.mycompany.webapp.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.webapp.dto.Board;


@Controller
public class Exam01Controller {
   private static final Logger logger = LoggerFactory.getLogger(Exam01Controller.class);
   
   @RequestMapping("/home")
   public String home() {
      logger.info("info �޽���");
      logger.error("error �޽���");
      logger.warn("warn �޽���");
      logger.debug("debug �޽���");
      return "home";
   }
   
   @RequestMapping("/exam01/boardlist")
   public String getBoardList(HttpServletRequest request, HttpServletResponse response) {
      //��û ������ Ȯ��
      System.out.println(request.getRemoteHost());

      //
      List<Board> list = new ArrayList<Board>();
      for(int i=1; i<=10; i++) {
         Board board = new Board();
         board.setBno(i);
         board.setBtitle("����"+i);
         board.setBcontent("����"+i);
         board.setBwriter("spring");
         list.add(board);
      }
      request.setAttribute("list", list);
      
      return "exam01/boardlist";
   }
}