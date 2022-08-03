package top.chenxuebing.validate;

import lombok.Data;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author chen.xuebing
 * @date 2022/7/9 14:30
 */
@Data
@ToString
public class HelloDTO {

    @NotEmpty
    private String name;

    @NotNull
    private Integer age;

    @Valid
    @NotNull
    private HelloInterDTO helloInter;
}
