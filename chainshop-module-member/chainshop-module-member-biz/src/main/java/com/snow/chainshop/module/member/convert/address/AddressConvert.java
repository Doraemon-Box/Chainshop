package com.snow.chainshop.module.member.convert.address;

import com.snow.chainshop.framework.ip.core.utils.AreaUtils;
import com.snow.chainshop.module.member.api.address.dto.AddressRespDTO;
import com.snow.chainshop.module.member.controller.admin.address.vo.AddressRespVO;
import com.snow.chainshop.module.member.controller.app.address.vo.AppAddressCreateReqVO;
import com.snow.chainshop.module.member.controller.app.address.vo.AppAddressRespVO;
import com.snow.chainshop.module.member.controller.app.address.vo.AppAddressUpdateReqVO;
import com.snow.chainshop.module.member.dal.dataobject.address.MemberAddressDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户收件地址 Convert
 *
 * @author Chainshop
 */
@Mapper
public interface AddressConvert {

    AddressConvert INSTANCE = Mappers.getMapper(AddressConvert.class);

    MemberAddressDO convert(AppAddressCreateReqVO bean);

    MemberAddressDO convert(AppAddressUpdateReqVO bean);

    @Mapping(source = "areaId", target = "areaName",  qualifiedByName = "convertAreaIdToAreaName")
    AppAddressRespVO convert(MemberAddressDO bean);

    List<AppAddressRespVO> convertList(List<MemberAddressDO> list);

    AddressRespDTO convert02(MemberAddressDO bean);

    @Named("convertAreaIdToAreaName")
    default String convertAreaIdToAreaName(Integer areaId) {
        return AreaUtils.format(areaId);
    }

    List<AddressRespVO> convertList2(List<MemberAddressDO> list);

}
