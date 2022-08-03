package top.chenxuebing.validate;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author chen.xuebing
 * @date 2022/7/5 15:38
 */
@RestController
@RequestMapping("/hello")
@Validated
public class HelloController {

    @GetMapping("/hi")
    public String hi(@NotEmpty String name,
                     @NotNull Integer age) {
        return name + age;
    }

    @PostMapping("/ho")
    public String ho(@Valid @RequestBody HelloDTO helloDTO) {
        return helloDTO.toString();
    }

    @GetMapping("/he")
    public Integer he(@Enum(intValues = {18, 19}) Integer age) {
        return age;
    }
}
