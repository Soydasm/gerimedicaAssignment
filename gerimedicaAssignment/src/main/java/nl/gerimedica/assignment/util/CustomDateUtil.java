package nl.gerimedica.assignment.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateUtil
{
    public static final String DATE_FORMAT_MONTH_DAY_YEAR_WITH_DASHES = "MM-dd-yyyy";


    public static Date convertDate(String dateStr, String format)
    {
        if(dateStr.equals("") || dateStr == null)
        {
            return null;
        }

        try
        {
            SimpleDateFormat dateFormat  = new SimpleDateFormat(format);
            return dateFormat.parse(dateStr);
        }
        catch(Exception e)
        {
            return null;
        }

    }
}
