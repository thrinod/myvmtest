package com.thrinod.myvmtest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EmpFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fileId;

    private String fileName;

    @Lob
    private byte[] data;

    private String status;

    public EmpFile(Long fileId, String fileName, byte[] data,String status) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.data = data;
        this.status = status;
    }
}
