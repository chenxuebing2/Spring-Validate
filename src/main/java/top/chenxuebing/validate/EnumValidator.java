package top.chenxuebing.validate;

import cn.hutool.core.convert.Convert;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author chen.xuebing
 * @date 2022/8/3 17:04
 */
public class EnumValidator implements ConstraintValidator<Enum, Object> {

    private String[] strValues;
    private int[] intValues;

    @Override
    public void initialize(Enum constraintAnnotation) {
        strValues = constraintAnnotation.strValues();
        intValues = constraintAnnotation.intValues();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value instanceof String) {
            for (String s : strValues) {
                if (s.equals(value)) {
                    return true;
                }
            }
        } else if (value instanceof Number) {
            for (Integer i : intValues) {
                if (i.equals(Convert.toInt(value))) {
                    return true;
                }
            }
        }
        return false;
    }
}
