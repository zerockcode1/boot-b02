package org.zerock.b01.domain;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GourmetDiary extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gno;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;

    public void change(String title, String content){
        this.title = title;
        this.content = content;
    }

    @ElementCollection
    @Builder.Default
    private Set<GourmetImage> imageSet = new HashSet<>();

    public void addImage(GourmetImage image){
        image.setOrd(imageSet.size());
        imageSet.add(image);
    }
}














