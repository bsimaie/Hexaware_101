package freddie.data;

import freddie.utilities.Database;

public class DatabaseReader {

	public static void main(String[] args) {
		String[][] dataTable = Database.get("MortgageLoanTestData");
		
		for (int i = 0; i < dataTable.length; i++) {
			for (int j = 0; j < dataTable[i].length; j++) {
				System.out.println(dataTable[i][j]);
			}
			
			/*
			for (String field : dataTable[i]) {
				System.out.println(field);
			}
			*/
			System.out.println();
		}
		
	}

}
