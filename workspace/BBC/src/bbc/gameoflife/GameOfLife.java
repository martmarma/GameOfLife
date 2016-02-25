package bbc.gameoflife;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import bbc.gameoflifestub.Cell;
import bbc.gameoflifestub.Life;

//A Very Simple Example
class GameOfLife {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        System.out.println("Initial cell population.");
        System.out.println("Live: '*', Dead: '.', New line: '_'");
        System.out.println("Example: ..*.*.._.*....*_...*...");
        System.out.print("Enter: ");
        String initialCellPopulation = br.readLine();
        System.out.print("Enter number of iterations: ");
        
        int numberOfIterations = 0;
        
        try{
            numberOfIterations = Integer.parseInt(br.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format");
        }
		
		ArrayList<ArrayList<Cell>> initialCells = prepareCellsFromString(initialCellPopulation);

		Life life = new Life(initialCells);
		
		for (int i = 0; i < numberOfIterations; i++) {
			
			System.out.println("\nIteration: " + (i + 1));
			Life newLife = life.gameOfLife();
			System.out.println(newLife);
			life = newLife;
		}
	}

	public static ArrayList<ArrayList<Cell>> prepareCellsFromString(String inputString) {

		ArrayList<ArrayList<Cell>> cells = new ArrayList<>();
		
		String[] lines = inputString.split("_");
		
		if (areLinesBalanced(lines)) {
			
			for (int i = 0; i < lines.length; i++) {
				
				String line = lines[i];
				ArrayList<Cell> cellsRow = new ArrayList<>();
				
				for (int j = 0; j < line.length(); j++) {
					
					if (line.charAt(j) == '*') {
						
						cellsRow.add(new Cell(i, j, true));
					} else if (line.charAt(j) == '.') {
						
						cellsRow.add(new Cell(i, j, false));
					}
				}
				
				cells.add(cellsRow);
			}
		}

		return cells;
	}

	public static boolean areLinesBalanced(String[] lines) {

		int lineLength = lines[0].length();
		boolean balancedLines = true;

		for (String string : lines) {
			
			if (string.length() != lineLength) {
				
				balancedLines = false;
				break;
			}
		}

		return balancedLines;
	}
}