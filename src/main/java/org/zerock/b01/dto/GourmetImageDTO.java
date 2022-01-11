package org.zerock.b01.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "uuid")
public class GourmetImageDTO {

    private String uuid;
    private String fileName;
    private int ord;

}
