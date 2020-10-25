package dto;

public class SInformationDTO {
    private String name;
    private String address;
    private String zone;
    private String province;
    private String district;
    private String name_principal;
    private String principal_con;

    public SInformationDTO() {
    }

    public SInformationDTO(String name, String address, String zone, String province, String district, String name_principal, String principal_con) {
        this.name = name;
        this.address = address;
        this.zone = zone;
        this.province = province;
        this.district = district;
        this.name_principal = name_principal;
        this.principal_con = principal_con;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getName_principal() {
        return name_principal;
    }

    public void setName_principal(String name_principal) {
        this.name_principal = name_principal;
    }

    public String getPrincipal_con() {
        return principal_con;
    }

    public void setPrincipal_con(String principal_con) {
        this.principal_con = principal_con;
    }
}
