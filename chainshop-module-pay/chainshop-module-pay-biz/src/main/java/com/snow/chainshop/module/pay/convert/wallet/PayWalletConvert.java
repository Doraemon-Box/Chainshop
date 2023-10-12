package com.snow.chainshop.module.pay.convert.wallet;

import com.snow.chainshop.module.pay.controller.app.wallet.vo.wallet.AppPayWalletRespVO;
import com.snow.chainshop.module.pay.dal.dataobject.wallet.PayWalletDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayWalletConvert {

    PayWalletConvert INSTANCE = Mappers.getMapper(PayWalletConvert.class);

    AppPayWalletRespVO convert(PayWalletDO bean);
}
