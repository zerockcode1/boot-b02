package org.zerock.b01.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GourmetListDTO {

    private Long gno;
    private String title;
    private String writer;

    private String uuid;
    private String fileName;



}
