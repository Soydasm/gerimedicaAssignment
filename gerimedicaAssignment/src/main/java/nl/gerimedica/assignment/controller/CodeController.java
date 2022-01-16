package nl.gerimedica.assignment.controller;

import nl.gerimedica.assignment.api.CodeDTO;
import nl.gerimedica.assignment.service.CodeService;
import nl.gerimedica.assignment.util.FileHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("code")
public class CodeController
{

    @Autowired
    CodeService codeService;
    /**
     * This method persists the data to the in-memory database and returns the DTOs of the persisted data
     * @param file
     * @return List of Objects that are queried from the database
     */
    @PostMapping
    public ResponseEntity<List<CodeDTO>> importFromCsv(@RequestParam("file") MultipartFile file)
    {
        List<CodeDTO> codeDTOList = null;
        if (FileHelper.hasCSVFormat(file)) {
            try
            {
                codeDTOList = codeService.saveAllCodesFromFile(file);
                return ResponseEntity.status(HttpStatus.OK).body(codeDTOList);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(codeDTOList);
            }
        }

        if (codeDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(Collections.emptyList());
    }

    /**
     *
     * @return List of elements found in the in-memory database
     */
    @GetMapping
    public ResponseEntity<List<CodeDTO>> getAll()
    {
        return ResponseEntity.ok(codeService.getAllCodeDTOs());
    }

    /**
     *
     * @param code The code based on which to lookup the entries
     * @return Single element if it exists
     */
    @GetMapping("/{code}")
    public ResponseEntity<CodeDTO> getSingle(@PathVariable("code") String code){

        CodeDTO codeDTO = codeService.findCodeByCode(code);
        if(codeDTO.getCode() == null || "".equals(codeDTO.getCode()))
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(codeDTO);

    }

    /**
     * Removes all elements from the in-memory database
     * @return
     */
    @DeleteMapping
    public ResponseEntity<String> removeAll()
    {
        codeService.removeAll("removed");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
