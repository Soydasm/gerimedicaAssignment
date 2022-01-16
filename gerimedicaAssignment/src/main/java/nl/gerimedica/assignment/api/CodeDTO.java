package nl.gerimedica.assignment.api;

import lombok.Data;
import nl.gerimedica.assignment.model.Code;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CodeDTO
{
    private String source;
    private String code;
    private String codeListCode;
    private String displayValue;
    private String longDescription;
    private Date fromDate;
    private Date toDate;
    private String sortingPriority;

    public static List<Code> convertToCodeList(List<CodeDTO> codeDTOList)
    {
        List<Code> codeList = new ArrayList<>();
        for(CodeDTO codeDTO : codeDTOList)
        {
            codeList.add(convertToCode(codeDTO));
        }
        return  codeList;
    }

    public static List<CodeDTO> convertCodeListToCodeDTOList(List<Code> codeList)
    {
        List<CodeDTO> codeDTOList = new ArrayList<>();
        for(Code code : codeList)
        {
            codeDTOList.add(convertCodeToCodeDTO(code));
        }
        return  codeDTOList;
    }

    public static Code convertToCode(CodeDTO codeDTO)
    {
        Code code = new Code();
        code.setSource(codeDTO.getSource());
        code.setCode(codeDTO.getCode());
        code.setCodeListCode(codeDTO.getCodeListCode());
        code.setDisplayValue(codeDTO.getDisplayValue());
        code.setLongDescription(codeDTO.getLongDescription());
        code.setFromDate(codeDTO.getFromDate());
        code.setToDate(codeDTO.getToDate());
        code.setSortingPriority(codeDTO.getSortingPriority());
        return  code;
    }

    public static CodeDTO convertCodeToCodeDTO(Code code)
    {
        CodeDTO codeDTO = new CodeDTO();
        codeDTO.setSource(code.getSource());
        codeDTO.setCode(code.getCode());
        codeDTO.setCodeListCode(code.getCodeListCode());
        codeDTO.setDisplayValue(code.getDisplayValue());
        codeDTO.setLongDescription(code.getLongDescription());
        codeDTO.setFromDate(code.getFromDate());
        codeDTO.setToDate(code.getToDate());
        codeDTO.setSortingPriority(code.getSortingPriority());
        return codeDTO;
    }
}
