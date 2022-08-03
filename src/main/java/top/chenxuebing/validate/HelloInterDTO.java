package top.chenxuebing.validate;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * @author chen.xuebing
 * @date 2022/7/9 15:45
 */
@Data
@ToString
public class HelloInterDTO {

    @NotEmpty
    private String sex;
}
