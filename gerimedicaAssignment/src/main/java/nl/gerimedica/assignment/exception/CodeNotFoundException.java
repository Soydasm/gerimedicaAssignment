package nl.gerimedica.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such a Code record")
public class CodeNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public CodeNotFoundException(String msg) {
        super(msg);
    }
}
