package com.loonxi.channel.LinkedIn.api.inter;

import com.loonxi.channel.LinkedIn.exception.LinkedinException;
import com.loonxi.channel.LinkedIn.model.Company;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by xyy on 2017/1/13.
 *
 * linkedin 官方doc
 * https://developer.linkedin.com/docs/company-pages
 */
public interface CompanyApi {

    List<Company> listCompanies() throws LinkedinException;

    /**
     * 获取公司的详情信息
     * @return
     */
    Company get(String companyId) throws LinkedinException;



}
