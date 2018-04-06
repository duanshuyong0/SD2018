
package com.dsy.dadui.common.datasource.transaction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * {@link TransactionTemplate}配置.
 * 
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年9月7日
 * @since 1.0
 */
@Configuration
public class TransactionTemplateConfiguration {

	@Bean
	public TransactionTemplate transactionTemplate(PlatformTransactionManager txManager) {
		return new TransactionTemplate(txManager);
	}

}
