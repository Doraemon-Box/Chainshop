package com.snow.chainshop.module.pay.convert.wallet;

import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.module.pay.controller.app.wallet.vo.transaction.AppPayWalletTransactionRespVO;
import com.snow.chainshop.module.pay.dal.dataobject.wallet.PayWalletTransactionDO;
import com.snow.chainshop.module.pay.service.wallet.bo.CreateWalletTransactionBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayWalletTransactionConvert {

    PayWalletTransactionConvert INSTANCE = Mappers.getMapper(PayWalletTransactionConvert.class);

    PageResult<AppPayWalletTransactionRespVO> convertPage(PageResult<PayWalletTransactionDO> page);

    PayWalletTransactionDO convert(CreateWalletTransactionBO bean);

}
