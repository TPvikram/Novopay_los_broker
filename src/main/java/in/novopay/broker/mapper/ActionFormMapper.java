package in.novopay.broker.mapper;

import in.novopay.broker.common.model.ActionForm;
import in.novopay.broker.dao.ActionFormDoc;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActionFormMapper {

    ActionFormMapper MAPPER = Mappers.getMapper(ActionFormMapper.class);

    ActionFormDoc fromActionForm(ActionForm actionForm);

    @InheritInverseConfiguration
    ActionForm toActionForm(ActionFormDoc actionFormDoc);

}
