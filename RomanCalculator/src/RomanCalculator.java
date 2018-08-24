/**
 * @author Adriana Fuentes
 *
 */
public class RomanCalculator {
   
   enum RomanNumeral {
      I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(500), CM(900), M(1000);
      int value;    
      
      RomanNumeral(int v) {
         this.value = v;
      }    
      
      int getValue() {
         return value;
      }
   };
   
   /**
    * Adds two Roman numbers
    * 
    * @param romanNum1
    * @param romanNum2
    * @return result of addition in Roman numbers
    */
   public String addRomanNumerals(String romanNum1, String romanNum2) {
      int decNum1 = romanNumeralDecoder(romanNum1);
      int decNum2 = romanNumeralDecoder(romanNum2);
      
      int decResult = decNum1 + decNum2;
      String romanNumRes = romanNumeralEncoder(decResult);
      
      return romanNumRes;
   }
   
   /**
    * Subtracts two Roman numbers
    * 
    * @param romanNum1
    * @param romanNum2
    * @return
    */
   public String subtractRomanNumerals(String romanNum1, String romanNum2) {
      int decNum1 = romanNumeralDecoder(romanNum1);
      int decNum2 = romanNumeralDecoder(romanNum2);
      
      int decResult = decNum1 - decNum2;
      String romanNumRes = romanNumeralEncoder(decResult);
      
      return romanNumRes;
   }
   
   /**
    * Converts Roman number to decimal value
    * 
    * @param romanNum
    * @return decimal value of Roman number
    */
   public int romanNumeralDecoder(String romanNum) {
      int romanLen = romanNum.length();
      
      if(romanLen == 0)
         return 0;
      else if(romanLen == 1)
         return decodeRomanNum(romanNum);
      
      int decimalResult = 0;     
      for(int i=0; i < romanLen-1; i++) {
         int decimalValueCur = decodeRomanNum(Character.toString(romanNum.charAt(i))); 
         int decimalValueNext = decodeRomanNum(Character.toString(romanNum.charAt(i+1)));
         if(decimalValueCur < decimalValueNext) {              // if current value is less than next one, subtract
            decimalResult = decimalResult - decimalValueCur;
         } 
         else {                                                // if current value is greater than next one, add
            decimalResult = decimalResult + decimalValueCur;
         }
      } 
      decimalResult = decimalResult + decodeRomanNum(Character.toString(romanNum.charAt(romanLen-1))); // add last value
      return decimalResult;
   }
   
   public int decodeRomanNum(String croman) {
      RomanNumeral rnum = RomanNumeral.valueOf(croman);
      return rnum.value;     
   }

   /**
    * Converts Decimal value to Roman number
    * 
    * @param decNum
    * @return Roman number
    */
   public String romanNumeralEncoder(int decNum) {
      if(decNum <= 0) 
         return "0";
      
      StringBuilder romanRes = new StringBuilder();
      
      RomanNumeral[] romanValues = RomanNumeral.values();
      for(int i=romanValues.length-1; i>=0; i--) {
         while(decNum >= romanValues[i].value) {
            romanRes.append(romanValues[i]);
            decNum = decNum - romanValues[i].value;
         }
      }
      return romanRes.toString();
   }
   

   public static void main(String[] args) {
      
      // Test Roman Numeral Decoder Method
      RomanCalculator rc = new RomanCalculator();
      
      // Test Adding Two Roman Numeral Numbers
      System.out.println("-------------- Add Results --------------");
      String addRomanRes = rc.addRomanNumerals("IV", "C");
      System.out.println(addRomanRes);
      String addRomanRes2 = rc.addRomanNumerals("CM", "L");
      System.out.println(addRomanRes2);
      String addRomanRes3 = rc.addRomanNumerals("XIV", "LX");
      System.out.println(addRomanRes3);
      String addRomanRes4 = rc.addRomanNumerals("XX", "II");
      System.out.println(addRomanRes4);
      String addRomanRes5 = rc.addRomanNumerals("II", "II");
      System.out.println(addRomanRes5);
      String addRomanRes6 = rc.addRomanNumerals("D", "D");
      System.out.println(addRomanRes6);
      String addRomanRes7 = rc.addRomanNumerals("MMDXLI", "MDXLV");
      System.out.println(addRomanRes7);
      
      // Test Subtracting Two Roman Numeral Numbers
      System.out.println("-------------- Subtract Results --------------");
      String subRomanRes = rc.subtractRomanNumerals("C", "IV");
      System.out.println(subRomanRes);
      String subRomanRes2 = rc.subtractRomanNumerals("CM", "L");
      System.out.println(subRomanRes2);
      String subRomanRes3 = rc.subtractRomanNumerals("LX", "XIV");
      System.out.println(subRomanRes3);
      String subRomanRes4 = rc.subtractRomanNumerals("XX", "II");
      System.out.println(subRomanRes4);
      String subRomanRes5 = rc.subtractRomanNumerals("II", "II");
      System.out.println(subRomanRes5);
      String subRomanRes6 = rc.subtractRomanNumerals("D", "D");
      System.out.println(subRomanRes6);
      String subRomanRes7 = rc.subtractRomanNumerals("MMDXLI", "MDXLV");
      System.out.println(subRomanRes7);     
      
   }
}
