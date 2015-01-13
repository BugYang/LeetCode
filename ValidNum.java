public class Solution {
    public boolean isEmpty(String s) {
        return s.equals("");
    }
    
    public boolean isDigits(String s) {
        for (int i = 0; i < s.length(); i++)
            if (!Character.isDigit(s.charAt(i)))
                return false;
        return !isEmpty(s);
    }
    
    public boolean isEmptyOrDigits(String s) {
        return isEmpty(s) || isDigits(s);
    }
    
    public String removeSig(String s) {
        if (s.length() > 0 && (s.charAt(0) == '+' || s.charAt(0) == '-'))
            s = s.substring(1);
        return s;
    }
    
    public boolean isInt(String s) {
        s = removeSig(s);
        return isDigits(s);
    }
    
    public boolean isFloat(String s) {
        s = removeSig(s);
        int idxDot = s.indexOf('.');
        if (idxDot == -1)
            return false;
        String partL = s.substring(0, idxDot), partR = s.substring(idxDot+1);
        return isEmptyOrDigits(partL) && isEmptyOrDigits(partR) && !(isEmpty(partL) && isEmpty(partR));
    }
    
    // exp
    public boolean isExp(String s) {
        int idxE = s.indexOf('e');
        if (idxE == -1)
            return false;
        String partL = s.substring(0, idxE), partR = removeSig(s.substring(idxE+1));
        return (isInt(partL) || isFloat(partL)) && isDigits(partR);
    }
    
    public boolean isNumber(String s) {
        s = s.trim().toLowerCase();
        return s.indexOf('e') == -1 ? isFloat(s) || isInt(s) : isExp(s);
    }
    

}