package dio.challenge.designpattern.exception;

import dio.challenge.designpattern.dto.ResponseDTO;
import dio.challenge.designpattern.dto.ValidationErrorResponseDTO;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final int ERROR_POSITION = 0;

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler({BusinessRuleException.class})
    public @ResponseBody ResponseDTO handleBusinessErrors(Exception e) {
        return new ResponseDTO(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public List<ValidationErrorResponseDTO> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        List<ValidationErrorResponseDTO> response = new ArrayList<>();

        for (ObjectError error : e.getBindingResult().getAllErrors()) {
            String errorAll = Objects.requireNonNull(error.getCodes())[ERROR_POSITION];
            String fieldName = errorAll.substring(errorAll.lastIndexOf(".") + 1);
            response.add(new ValidationErrorResponseDTO(fieldName, error.getDefaultMessage()));
        }

        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConversionFailedException.class)
    public @ResponseBody ResponseDTO handleConflict(RuntimeException ex) {
        return new ResponseDTO(ex.getMessage());
    }
}