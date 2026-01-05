class Solution(object):
    def findMinArrowShots(self, points):
        points.sort(key=lambda x:x[1])
        cnt = 1
        prev = points[0]
        for i in range(1,len(points)):
            if points[i][0] > prev[-1]:
                cnt +=1 
                prev = points[i]
        
        return cnt
        """
        :type points: List[List[int]]
        :rtype: int
        """
        