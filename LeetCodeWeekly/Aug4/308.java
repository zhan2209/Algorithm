
class NumMatrix {

	   public int[][] matrix=null;
		
	   public NumMatrix(int[][] matrix) {
	        this.matrix= matrix.clone();
	    }
	    
	    public void update(int row, int col, int val) {
	        this.matrix[row][col]=val;
	    }
	    
	    public int sumRegion(int row1, int col1, int row2, int col2) {
	        int ans=0;
	        if(matrix==null||matrix.length==0){
	        	return ans;
	        }
	        if(row1<0||row2>=matrix.length||col1<0||col2>=matrix[0].length){
	        	return ans;
	        }
	        for(int i = row1; i<=row2;i++)
	        	for(int j=col1;j<=col2;j++)
	        		ans+=matrix[i][j];
	        return ans;
	    }
}



/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */