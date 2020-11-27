package algorithms;

public class Defanging_IP_Address {
    public String defangIPaddr(String address) {
        String defangedIp = "";
        for(int i = 0; i < address.length();i++){
            if(address.charAt(i) == '.'){
                defangedIp += "[" + address.charAt(i) + "]";
            } else {
                defangedIp += address.charAt(i);
            }
        }
        return defangedIp;
    }

    public String defangIPaddrbest(String address) {
        return address.replace(".","[.]");
    }
}
