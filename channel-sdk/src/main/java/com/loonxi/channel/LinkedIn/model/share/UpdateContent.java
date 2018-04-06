package com.loonxi.channel.LinkedIn.model.share;

/**
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 16/1/17
 * @since 1.0
 */

public class UpdateContent implements  java.io.Serializable {

    private CompanyStatusUpdate companyStatusUpdate;

    public CompanyStatusUpdate getCompanyStatusUpdate() {
        return companyStatusUpdate;
    }

    public void setCompanyStatusUpdate(CompanyStatusUpdate companyStatusUpdate) {
        this.companyStatusUpdate = companyStatusUpdate;
    }
}
