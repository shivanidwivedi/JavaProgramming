package leetcode.Strings;

/**
 * @author shivanidwivedi on 11/02/20
 * @project JavaProgramming
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * A defanged IP address replaces every period "." with "[.]".
 */
public class DefangingIP {

    //Method-1: Using String Buffer
    public static String defangIPaddr(String address) {
        StringBuffer sb = new StringBuffer(address.length());
        for (int i = 0; i < address.length(); i++){
            if (address.charAt(i) == '.'){
                sb.append("[.]");
            }else {
                sb.append(address.charAt(i));
            }
        }
        return sb.toString();
    }

    //Method-2: Using ReplaceAll
    public static String defangIPaddr_2(String address) {
        return address.replaceAll("\\.", "\\[.]");
    }

    //Method-3:
    public static String defangIPaddr_3(String address) {
        String result = address.replace(".","["+"."+"]");
        return result;
    }
}
