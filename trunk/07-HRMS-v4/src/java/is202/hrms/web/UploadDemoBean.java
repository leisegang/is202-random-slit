/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.FileEJB;
import is202.hrms.entity.StoredFile;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.apache.myfaces.custom.fileupload.UploadedFile;


/**
 * This class demonstrates how to handle file up and downloads in backing beans.
 *
 * @author even
 */
@Named("fileBean")
@RequestScoped
public class UploadDemoBean {
    @EJB FileEJB fileEjb;
    private UploadedFile file;

    public UploadDemoBean() {
    }

    /** This method will be called when the user clicks the submit button
     * in the file upload form.
     */
    public View submit() throws IOException {
        if (null == file) return View.upload;

        StoredFile dbFile = new StoredFile(file);
        fileEjb.insert(dbFile);
        return View.upload;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile f) {
System.out.println("Upload: Receieved fiel "+f.getName()+" "+f.getContentType()+" "+f.getSize());
        this.file = f;
    }

    public List<StoredFile> getFiles() {
        return fileEjb.findAll();
    }

}
