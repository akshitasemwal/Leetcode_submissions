class Solution {
public:
    vector<int> countPoints(vector<vector<int>>& points, vector<vector<int>>& queries) {
        int qsize=queries.size();
        int psize=points.size();
        vector <int> v;
        double d=0.0;
        int count=0;
        for(int i=0;i<qsize;i++)
        {
            count=0;
            for(int j=0;j<psize;j++)
            {
                int p1=points[j][0]-queries[i][0];
                int p2=points[j][1]-queries[i][1];
                int sum=pow(p1,2)+pow(p2,2);
                d= sqrt(sum);
                if(d<= queries[i][2])
                {
                    count++;
                }
            }
            v.push_back(count);
            
        }
        return v;
    }
};