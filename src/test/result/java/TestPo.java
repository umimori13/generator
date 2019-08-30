
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
public class TestPo implements Serializable {
    
    @Getter @Setter
    private String name;
    
    @Getter @Setter
    private Integer age;
    
    @Getter @Setter
    private String city;
    
}