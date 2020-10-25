package bo.custom;

import bo.SuperBO;
import dto.SInformationDTO;

import java.util.ArrayList;

public interface SInformationBO extends SuperBO {
    public boolean updateInformation(SInformationDTO dto)throws Exception;

}
