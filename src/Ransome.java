public class Ransome {
//    Given two strings ransomNote and magazine, return true if ransomNote can be constructed
//
//    by using the letters from magazine and false otherwise.
//
//Each letter in magazine can only be used once in ransomNote.
    boolean canConstruct(String magazine, String ransomNote){
        //construct rans from mag


        for(int i=0; i < ransomNote.length(); i++){
            //get the first char of magazine
            char r=ransomNote.charAt(i);
            //check for an existing match
            int matching=magazine.indexOf(r);

            //No match
            if(matching == -1){
                return false;
            }

            magazine=magazine.substring(0,matching)+magazine.substring(matching + 1);
        }
        return true;
    }
}