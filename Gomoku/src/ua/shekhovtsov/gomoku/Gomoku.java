package ua.shekhovtsov.gomoku;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;

public class Gomoku {
	public static int SIZE = 15;
	public static int WIN_COUNT = 5;

	public static char NO_WINNER = 0;
	public static char EMPTY = ' ';
	public static char HUMAN = 'X';
	public static char COMPUTER = 'O';
	
	public static JLabel cells[][];

	///////////////////////
	
	public static GameTable[][] gameTable = new GameTable[SIZE][SIZE];
	
	private static void setPriorityByLines(GameTable[] line, char player) {
		char player2 = COMPUTER;
		if (player == COMPUTER) {
			player2 = HUMAN;
		}
		for (int i = 0; i < line.length - WIN_COUNT + 1; i++) {
			int count = 0;
			for (int j = i; j < i + WIN_COUNT; j++) {
				if (line[j].getElement() == player2) {
					count = -1;
					break;
				}
			}
			if(count == -1) {
				continue;
			}
			for (int j = i; j < i + WIN_COUNT; j++) {
				if (line[j].getElement() == player) {
					count++;
				}
			}
			if(count == -1) {
				continue;
			}
			if(count == 5) {
				for (int j = i; j < i + WIN_COUNT; j++) {
					line[j].setPriority(count);
				}
				return;	
			}
			for (int j = i; j < i + WIN_COUNT; j++) {
				if (line[j].getElement() == ' ' && line[j].getPriority() < count) {
					line[j].setPriority(count);
				}
			}
		}
		String lineException = "";
		for (int j = 0; j < 7; j++) {
			if (j > 1 && j < 5) {
				lineException += player;
				continue;
			}
			lineException += ' ';
		}
		String lineString = "";
		for (int j = 0; j < line.length; j++) {
			lineString += line[j].getElement();
		}
		if (lineString.contains(lineException)) {
			int start = lineString.indexOf(lineException);
			line[start].setPriority(2);
			line[start+6].setPriority(2);
		}
	}

	private static void setPriority(GameTable[][] gameTable, char player) {
		for (int i = 0; i < SIZE; i++) {
			GameTable[] line = new GameTable[SIZE];
			for (int j = 0; j < SIZE; j++) {
				line[j] = gameTable[i][j];
			}
			setPriorityByLines(line, player);
		}
		for (int i = 0; i < SIZE; i++) {
			GameTable[] line = new GameTable[SIZE];
			for (int j = 0; j < SIZE; j++) {
				line[j] = gameTable[j][i];
			}
			setPriorityByLines(line, player);
		}
		
		for (int i = WIN_COUNT - 1; i < SIZE; i++) {
			//by diagonal
			GameTable[] line = new GameTable[i+1];
			for (int j = 0, k = i, iterator = 0; k>=0; j++, k--, iterator++) {
				line[iterator] = gameTable[j][k];
			}
			setPriorityByLines(line, player);

			line = new GameTable[i+1];
			for (int j = SIZE - 1, k = SIZE - i - 1, iterator = 0; k < SIZE; j--, k++, iterator++) {
				line[iterator] = gameTable[j][k];
			}
			setPriorityByLines(line, player);

			//by inverse
			line = new GameTable[i+1];
			for (int j = SIZE - i - 1, k = 0, iterator = 0; j < SIZE; j++, k++, iterator++) {
				line[iterator] = gameTable[j][k];
			}
			setPriorityByLines(line, player);

			line = new GameTable[i+1];
			for (int j = SIZE - i - 1, k = 0, iterator = 0; j < SIZE; j++, k++, iterator++) {
				line[iterator] = gameTable[k][j];
			}
			setPriorityByLines(line, player);
		}
		
	}
	
	private static void nullPriority(GameTable[][] gameTable) {
		for (int i = 0; i < gameTable.length; i++) {
			for (int j = 0; j < gameTable[i].length; j++) {
				gameTable[i][j].setPriority(0);
			}			
		}
	}
	
	private static ArrayList<GameTable> getPriorityByValue(GameTable[][] gameTable, int value) {
		ArrayList<GameTable> list = new ArrayList<>();
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if(gameTable[i][j].getPriority() == value) {
					list.add(gameTable[i][j]);
				}
			}
		}
		return list;
	}
	
	///////////////////////

	public static void init() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				gameTable[i][j] = new GameTable(j, i);
			}
		}
	}

	public static void makeTurn(int i, int j, char figure) {
		gameTable[i][j].setElement(figure);
		gameTable[i][j].setPriority(0);
		drawFigure(i, j);
	}

	public static void drawFigure(int i, int j) {
		cells[i][j].setText(String.valueOf(gameTable[i][j].getElement()));
	}

	public static boolean isCellFree(int i, int j) {
		return gameTable[i][j].getElement() == EMPTY;
	}

	public static void makeHumanTurn(int i, int j) {
		makeTurn(i, j, HUMAN);
	}

	public static boolean hasEmptyCells() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (gameTable[i][j].getElement() == EMPTY) {
					return true;
				}
			}
		}
		return false;
	}

	public static void markWinningCombinationByRedColor(ArrayList<GameTable> list) {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				for (int j2 = 0; j2 < list.size(); j2++) {
					if (list.get(j2).getY() == i && list.get(j2).getX() == j) {
						cells[i][j].setForeground(Color.RED);
						cells[i][j].setFont(new Font(Font.SERIF, Font.BOLD, 35));
					}
				}
			}
		}
	}

	public static void makeComputerTurn() {
		nullPriority(gameTable);
		setPriority(gameTable, HUMAN);

		GameTable[][] computerTable = new GameTable[SIZE][SIZE];
		for (int j = 0; j < SIZE; j++) {
			for (int j2 = 0; j2 < SIZE; j2++) {
				computerTable[j][j2] = gameTable[j][j2].clone();
			}
		}
		nullPriority(computerTable);
		setPriority(computerTable, COMPUTER);
		
		for (int j = WIN_COUNT - 1; j > 0; j--) {
			ArrayList<GameTable> computerTurn = getPriorityByValue(computerTable, j);
			ArrayList<GameTable> humanTurn = getPriorityByValue(gameTable, j);

			//i think if i remove it nothing will change))
			for (int k = 0; k < computerTurn.size(); k++) {
				for (int k2 = 0; k2 < humanTurn.size(); k2++) {
					if (computerTurn.get(k).equals(humanTurn.get(k2))) {
						GameTable temp = computerTurn.get(k);
						makeTurn(temp.getY(), temp.getX(), COMPUTER);
						return;
					}
				}
			}
			////////////???????????????????????
			
			if (computerTurn.size() != 0) {
				GameTable temp = computerTurn.get(new Random().nextInt(computerTurn.size()));
				makeTurn(temp.getY(), temp.getX(), COMPUTER);
				return;
			}
			if (humanTurn.size() != 0 && j > 2) {
				GameTable temp = humanTurn.get(new Random().nextInt(humanTurn.size()));
				makeTurn(temp.getY(), temp.getX(), COMPUTER);
				return;
			}
		}
		ArrayList<GameTable> humanTurn = getPriorityByValue(gameTable, 1);
		GameTable temp = humanTurn.get(new Random().nextInt(humanTurn.size()));
		makeTurn(temp.getY(), temp.getX(), COMPUTER);
	}

	public static boolean findWinner(char figure) {
		setPriority(gameTable, figure);
		ArrayList<GameTable> list = getPriorityByValue(gameTable, 5);
		if (list.size() != 0) {
			markWinningCombinationByRedColor(list);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		GUIGomoku.main(args);
	}
}