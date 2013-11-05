/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.entity;

import java.io.IOException;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import org.apache.commons.io.FilenameUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;


/**
 *Entity for storing files in the database
 * @author even
 */
@Entity
public class StoredFile implements Serializable{
    @Id @GeneratedValue private long id;
    private String name;
    private String contentType;
    private int fileSize;
    /** The actual content of the file. It is stored as a BLOB in
     * the database. FetchType.LAZY means that JPA will not retrieve
     * it from the database before we explicitly as for it. This is
     * to avoid unnecessary load on the database and application server. */
     @Lob @Basic(fetch=FetchType.LAZY)
     
     @Column(columnDefinition = "longblob")
     
    private byte[] contents;

    public StoredFile() {}

    public StoredFile(UploadedFile uf) throws IOException {
        this.setName(uf.getName());
        this.contentType = uf.getContentType();
        this.contents = uf.getBytes();
        this.fileSize = (int)uf.getSize();
        if (contents.length > fileSize) System.out.println("Oversize array");
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = FilenameUtils.getName(name);
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }


    public int getFileSize() {
        return fileSize;
    }

    public byte[] getContents() {
        return contents;
    }

    public void setContents(byte[] contents) {
        this.contents = contents;
    }

    public String toString() {
        return name;
    }
}
