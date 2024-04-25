package com.teachMeSkills.task.servlet;

import com.teachMeSkills.task.date.FormatDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import static com.teachMeSkills.task.date.FormatDate.dateFormat;

@WebServlet("/book")
public class ServletDownloadFile extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        log(dateFormat(new Date()) + " Получен запрос на скачивание файла.");
        PrintWriter out = response.getWriter();
        String pdfName = "AutoScan.txt";
        String pdfPath = "E:\\";


        response.setContentType("application/txt");
        response.setHeader("Content-Disposition",
                "attachment; filename=\""
                        + pdfName + "\"");


        FileInputStream inputStream
                = new FileInputStream(pdfPath + pdfName);


        int in;
        while ((in = inputStream.read()) != -1) {
            out.write(in);
        }


        inputStream.close();
        out.close();
        log(dateFormat(new Date()) + " Файл успешно скачан с сервера.");
    }

}
