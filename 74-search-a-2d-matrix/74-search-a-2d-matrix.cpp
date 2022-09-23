class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int N=matrix.size();
        int M=matrix[0].size();
        /*for(int i=0;i<n;i++)
        {
            int high=matrix[i][m-1];
            int low=matrix[i][0];
            int mid=(high+low)/2;
            if(target>=low && target<=high)
            {
                for(int j=0;j<m;j++)
                {
                    if(target==mid)
                    {
                        return 1;
                    }
                    else if(target>mid)
                    {
                        low=mid+1;
                        mid=(high+low)/2;
                    }
                    else if(target<mid)
                    {
                        high=
                    }
                }
            }*/
        int j=0;
	    int i=0;
	    for(i=0;i<N;i++)
	    {
	        if(matrix[i][0]<=target && matrix[i][M-1]>=target)
	        {
	            for(j=0;j<M;j++)
	            {
	                if(matrix[i][j]==target)
	                {
	                    return 1;
	                }
	            }
	        }
	    }
	    
	    return 0;
        }
    
};