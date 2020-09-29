package ctcibook.arraystring;

/**
 * @author shivanidwivedi on 29/09/20
 * @project JavaProgramming
 * Write a method to replace all spaces in a string with '%20'.
 */
public class ReplaceAllSpacesString {
    public void replaceSpaces(char[] str, int length){
        int spaceCount = 0, newLength;
        for(int i = 0; i < length; i++){
            if(str[i] == ' '){
                spaceCount++;
            }
        }
        newLength = length + spaceCount * 2;
        str[newLength] = '\0';
        for(int i = length-1; i >= 0; i--){
            if(str[i] == ' '){
                str[newLength-1] = '0';
                str[newLength-2] = '2';
                str[newLength-3] = '%';
                newLength -= 3;
            }else {
                str[newLength-1] = str[i];
                newLength--;
            }
        }
    }
}
