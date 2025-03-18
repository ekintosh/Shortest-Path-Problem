import java.io.*;
public class CSVto2DArray {
    private  String fileCSV;
    public CSVto2DArray(String fileCSV){
        this.fileCSV = fileCSV;
    }
    public  int[][] csvMatrix(String fileCSV) throws IOException {
        // have to read two time
    //first determine row and col amount
    BufferedReader reader = new BufferedReader(new FileReader(fileCSV));

    String headerLine = reader.readLine();
    String[] headers = headerLine.split(",");
    int colCounter = headers.length-1;
    // until line equal to null == row number
    int rowCounter= 0;
    while((reader.readLine()) != null){
        rowCounter++;
        // for each line split help and create cells array and length will be col

    }
    reader.close();

    //second fil 2D matrix
    int[][] matrix = new int[rowCounter][colCounter];
    reader = new BufferedReader(new FileReader(fileCSV));
    //skip first line
    reader.readLine();
    String line;
    int row=0;
    while((line=reader.readLine()) !=null){
        // each line will be 1D array(string)
        String[] array1D = line.split(",");
        // distanceMatrix int have to use Integer.parseInt - String can not cast to integer
        // skip first col have to start "1"
        for(int col = 1 ; col < array1D.length; col++){
            matrix[row][col-1]= Integer.parseInt(array1D[col]);
        }
        row++;
    }
    reader.close();
    return  matrix;
    }
    public  String[] csvCities(String fileCSV) throws IOException{

        BufferedReader reader = new BufferedReader(new FileReader(fileCSV));
        // pull first line
        String headerLine = reader.readLine();
        reader.close();
        // split with delimetre array index
        // first row 0. index i  empty so we have index problem
        String[] result = headerLine.split(",");
        String[] cities = new String[result.length - 1];
        // arrayCopy result start 1.index put cities 0. index and length
        for(int i =0 ; i< cities.length; i++){
            cities[i]=result[i+1];
        }
        return cities;
    }
  /*  public static void pritntVertexandEdge(int[][]distanceMatrix, String[] citiesArray) throws IOException{
        System.out.println("Cities:");
        for (String city : citiesArray) {
            System.out.print(city + "\t");
        }
        System.out.println();


        System.out.println("\nDistance Matrix:");
        for (int i = 0; i < distanceMatrix.length; i++) {
            for (int j = 0; j < distanceMatrix[i].length; j++) {
                System.out.print(distanceMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

   */

}



