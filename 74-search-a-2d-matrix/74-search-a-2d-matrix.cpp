class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int n=matrix.size();
        int m=matrix[0].size();
        for(int i=0;i<n;i++)
        {
            int high=m-1;
            int low=0;
            int mid=(high+low)/2;
            if(target>=matrix[i][0] && target<=matrix[i][m-1])
            {
                for(int j=0;j<m;j++)
                {
                    if(matrix[i][mid]==target)
                    {
                        return 1;
                    }
                    else if(target>matrix[i][mid])
                    {
                        low=mid+1;
                        mid=(high+low)/2;
                    }
                    else if(target<matrix[i][mid])
                    {
                        high=mid-1;
                        mid=(high+low)/2;
                    }
                }
            }
        }
        return 0;
    }   
};