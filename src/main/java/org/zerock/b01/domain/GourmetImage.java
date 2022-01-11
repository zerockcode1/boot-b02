package org.zerock.b01.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.NamedEntityGraph;

@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GourmetImage {

    private String uuid;

    private String fileName;

    private int ord;

    public void setOrd(int ord){
        this.ord = ord;
    }
}
