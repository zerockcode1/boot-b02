package org.zerock.b01.domain;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.NamedEntityGraph;

@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@EqualsAndHashCode(of = "uuid")
public class GourmetImage {

    private String uuid;

    private String fileName;

    private int ord;

    public void setOrd(int ord){
        this.ord = ord;
    }

}
