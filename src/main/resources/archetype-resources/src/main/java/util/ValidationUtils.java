package ${package}.util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Collection;
import java.util.Set;

/**
 * 请求验证
 * Created by xuzhuo on 2017/6/8.
 */
public class ValidationUtils {
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T>  void validate(T t) throws ValidationException {
        Set<ConstraintViolation<T>> set =  validator.validate(t);
        if(set.size()>0){
            StringBuilder validateError = new StringBuilder();
            for(ConstraintViolation<T> val : set){
                validateError.append(val.getMessage()).append(";");
            }
            throw new ValidationException(validateError.toString());
        }

    }
    public static <T>  void validate(Collection<T>ts, int size) throws ValidationException {
        if (ts == null || ts.isEmpty()){
            throw new IllegalArgumentException("参数为空");
        }
        if (ts.size() > size){
            throw new IllegalArgumentException("超出最大查询数量:" + size);
        }
        for (T t : ts) {
            validate(t);
        }
    }
}
