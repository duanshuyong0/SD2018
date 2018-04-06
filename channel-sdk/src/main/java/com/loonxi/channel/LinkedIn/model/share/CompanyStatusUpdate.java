package com.loonxi.channel.LinkedIn.model.share;

/**
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 16/1/17
 * @since 1.0
 */

public class CompanyStatusUpdate implements  java.io.Serializable{

    private Share share;

    public Share getShare() {
        return share;
    }

    public void setShare(Share share) {
        this.share = share;
    }
}
