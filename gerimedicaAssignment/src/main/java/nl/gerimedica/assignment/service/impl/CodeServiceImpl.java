package nl.gerimedica.assignment.service.impl;


import nl.gerimedica.assignment.api.CodeDTO;
import nl.gerimedica.assignment.repository.CodeRepository;
import nl.gerimedica.assignment.service.CodeService;
import nl.gerimedica.assignment.util.FileHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service("codeService")
public class CodeServiceImpl implements CodeService
{

    @Resource(name = "codeRepository")
    private CodeRepository codeRepository;

    @Override
    public CodeDTO findCodeByCode(String code)
    {
        return CodeDTO.convertCodeToCodeDTO(codeRepository.findCodeByCode(code));
    }

    @Override
    public List<CodeDTO> saveAllCodesFromFile(MultipartFile file)
    {
        try
        {
            List<CodeDTO> codeDTOList = FileHelper.csvToCodeDTO(file.getInputStream());
            codeRepository.saveAll(CodeDTO.convertToCodeList(codeDTOList));
            return codeDTOList;
        } catch (IOException e)
        {
            throw new RuntimeException("Fail to store csv data: " + e.getMessage());
        }
    }


    @Override
    public List<CodeDTO> getAllCodeDTOs()
    {
        return CodeDTO.convertCodeListToCodeDTOList(codeRepository.findAll());

    }

    @Override
    @Transactional
    public void removeAll(String deleted)
    {
        codeRepository.deleteAllCodes(deleted);
    }
}
