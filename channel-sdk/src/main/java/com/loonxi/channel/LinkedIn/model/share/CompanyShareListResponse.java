package com.loonxi.channel.LinkedIn.model.share;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 16/1/17
 * @since 1.0
 */

public class CompanyShareListResponse implements  java.io.Serializable{

    @JsonProperty("_total")
    private Integer _total; //总数
    private List<CompanyShareBean> values; //数据集合

    public Integer get_total() {
        return _total;
    }

    public void set_total(Integer _total) {
        this._total = _total;
    }

    public List<CompanyShareBean> getValues() {
        return values;
    }

    public void setValues(List<CompanyShareBean> values) {
        this.values = values;
    }
}
