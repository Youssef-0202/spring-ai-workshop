package dev.yab.spring_ai.tools.datetime;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.context.i18n.LocaleContextHolder;

import java.time.LocalDateTime;

/**
 * @author HP
 **/
public class DateTimeTools {

    @Tool(description = "Get the current data and time in the user's timezone")
    public String getCurrentDateTime(){
        return LocalDateTime.now().atZone(LocaleContextHolder.getTimeZone().toZoneId()).toString();
    }

}
