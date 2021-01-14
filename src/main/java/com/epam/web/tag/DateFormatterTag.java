package com.epam.web.tag;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class DateFormatterTag extends BodyTagSupport {

    private static final String LANG_ATTRIBUTE = "language";

    @Override
    public int doAfterBody() throws JspException {
        BodyContent content = this.bodyContent;
        String body = content.getString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyy-mm-dd");
        Date date = null;
        try {
            date = dateFormat.parse(body);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        HttpSession session = pageContext.getSession();
        Object languageObj =  session.getAttribute(LANG_ATTRIBUTE);
        Locale locale = new Locale("ru","BY");

        if(languageObj != null) {
            String language= languageObj.toString();
            switch (language) {
                case "ru":
                    locale = new Locale("ru", "BY");
                    break;
                case "en":
                    locale = Locale.ENGLISH;
                    break;
                case "fr":
                    locale = Locale.FRANCE;
                    break;
                default:
                    throw new IllegalArgumentException("No such language is provided");
            }
        }
        DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        String resultDate = format.format(date);

        JspWriter out = content.getEnclosingWriter();
        try {
            out.write(resultDate);
        } catch (IOException e) {
            throw new JspTagException(e.getMessage());
        }
        return SKIP_BODY;
    }
}
