bugs in code :
palindrom code :
j++ should be j--
i-- should be i++

anagram code :
i <= s1.length() should be i < s1.length() — the <= causes an Exception

binarySearch code :
while (low < high) should be while (low <= high) 


QuadraticEquation code :
no bug 

RomanNumeral code :
i <= symbols.length should be i < symbols.length

fizzBuzz code :
n <= 1 should be n <= 0




i used this :

mvn test




notes :
the line coverage tests are working fine but the others not , because of the bugs in the code .