package jcs.ejb.component;


public enum OrgAddressSendType {
    /**virtual*/
    自取("1") ,
    /**virtual*/
    電子交換("2"),
    本部公告欄("3"), 郵寄("4"), 傳真("5"), 院換("6"), 
    部換("7"), E_mail加院換("8"), 外交郵袋("9"), 快捷("A"), 
    監委系統("B"), 密傳("C");
    
    private String code;
    
    private OrgAddressSendType(String code){
        this.code = code;
    }
    
    public String getCode(){
        return this.code;
    }
    
    public static OrgAddressSendType decode(String code){
        for( OrgAddressSendType orgAddressSendType : OrgAddressSendType.values() ){
            if( orgAddressSendType.code.equals(code)){
                return orgAddressSendType;
            }
        }
        return null;
    }
    
    public static OrgAddressSendType[] getInternalSendMethod(){
        return new OrgAddressSendType[]{
            OrgAddressSendType.本部公告欄
        };
    }
    
}
