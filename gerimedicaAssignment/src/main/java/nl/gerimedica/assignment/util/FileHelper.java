package nl.gerimedica.assignment.util;

import nl.gerimedica.assignment.api.CodeDTO;
import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHelper
{
    public static String TYPE = "text/csv";
    public static int lengthConstraint = 2000;

    public static boolean hasCSVFormat(MultipartFile file)
    {
        if (file.isEmpty() || !TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<CodeDTO> csvToCodeDTO(InputStream is)
    {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<CodeDTO> codeDTOList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords)
            {
                CodeDTO codeDTO= new CodeDTO();
                codeDTO.setSource(csvRecord.get("source"));
                codeDTO.setCode(csvRecord.get("code"));
                codeDTO.setCodeListCode(csvRecord.get("codeListCode"));
                codeDTO.setDisplayValue(getValidStringField(csvRecord.get("displayValue"), "displayValue"));
                codeDTO.setLongDescription(getValidStringField(csvRecord.get("longDescription"), "longDescription"));
                codeDTO.setFromDate(CustomDateUtil.convertDate(csvRecord.get("fromDate"), CustomDateUtil.DATE_FORMAT_MONTH_DAY_YEAR_WITH_DASHES));
                codeDTO.setToDate(CustomDateUtil.convertDate(csvRecord.get("toDate"), CustomDateUtil.DATE_FORMAT_MONTH_DAY_YEAR_WITH_DASHES));
                codeDTO.setSortingPriority(csvRecord.get("sortingPriority"));
                codeDTOList.add(codeDTO);
            }

            return codeDTOList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static String getValidStringField(String stringField, String fieldName) {
        if (stringField.equals("") || stringField == null) {
            return null;
        }

        if (stringField.length() > lengthConstraint) {
            throw new RuntimeException(String.format("The file has invalid field %s, this can not be biggern than 2000 length", fieldName));
        }

        return stringField;
    }
}
