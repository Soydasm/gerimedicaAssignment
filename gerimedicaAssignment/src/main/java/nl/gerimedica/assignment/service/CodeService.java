package nl.gerimedica.assignment.service;

import nl.gerimedica.assignment.api.CodeDTO;
import nl.gerimedica.assignment.model.Code;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface CodeService
{
    CodeDTO findCodeByCode(String code);

    List<CodeDTO> saveAllCodesFromFile(MultipartFile file);

    List<CodeDTO> getAllCodeDTOs();

    void removeAll(String deleted);
}
