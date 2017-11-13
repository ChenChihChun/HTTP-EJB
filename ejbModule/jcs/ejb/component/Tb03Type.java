package jcs.ejb.component;

public enum Tb03Type {
    機關代碼('0'),單位代碼('1'),使用者代碼('2');
    
    private char code;
    private Tb03Type( char code){
        this.code = code;
    }
    
    public char getCode(){
        return this.code;
    }
    
    public static Tb03Type decode(char code){
        for( Tb03Type tb03Type : Tb03Type.values()){
            if( tb03Type.code == code){
                return tb03Type;
            }
        }
        return null;
    }
}
