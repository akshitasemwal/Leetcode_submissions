class Solution {
    public int addDigits(int num) {
        int s=0;
        while(num!=0)
        {
            int r=num%10;
            num/=10;
            s+=r;
            if(s>9)
            {
                r=s%10;
                s=s/10;
                s+=r;
            }
        }
        return s;
    }
}