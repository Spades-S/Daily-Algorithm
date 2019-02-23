class Solution {
    public int findNthDigit(int n) {
        long index = 1, count = 9;
        while(n > index*count){
            n -= index*count;
            index++;
            count *= 10;
        }
        long baseNumber = (long) Math.pow(10, index - 1);
        long number = (n - 1) / index + baseNumber;
        long nthDight = (n - 1) % index;
        return (""+ number).charAt((int)nthDight) - '0';
    }
}