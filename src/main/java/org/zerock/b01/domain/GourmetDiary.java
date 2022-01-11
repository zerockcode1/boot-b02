package org.zerock.b01.domain;


import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "imageSet")
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

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    @BatchSize(size = 100)
    private Set<GourmetImage> imageSet = new HashSet<>();

    public void addImage(GourmetImage image){
        image.setOrd(imageSet.size());
        imageSet.add(image);
    }
}














