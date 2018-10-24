import java.util.Arrays;
import java.util.Random;

public class Game {

	public static void main(String[] args) {
		//產生陣列花色(100與大小為梅花 200回方塊...) 與大小(從2開始)
		int poker [][] = new int [4][13];
		int color_recognize = 100;
		
		for(int i = 0; i <= 3;i++ ) {
			for(int j = 0; j <= 12; j++) {
				poker[i][j] = color_recognize + j + 2;
			}
			color_recognize = color_recognize + 100;
		}
		//從poker矩陣中產生玩家與電腦陣列花色與大小(taking 4 cards from poker ,two for the computer and two for you) 
		
		Random ran = new Random();
		int result_user [] = new int [2];
		for(int i = 0; i <= 1; i++) {
			result_user[i] = poker[ran.nextInt(4)][ran.nextInt(13)];    //產生玩家的牌(output the cards of yours)
		}
		
		int result_computer [] = new int [2];
		for(int i = 0; i <= 1; i++) {
			result_computer[i] = poker[ran.nextInt(4)][ran.nextInt(13)];   //產生電腦的牌(output the cards of computer)
		}
		
		poker = null;    //釋放poker的記憶體(releasing memory of poker )
		
		System.out.printf("I got: ");    //印出花色與數字(玩家)(output what you got)
		int j = 0;
		Color_output(result_user, j);
		Arrays.sort(result_user);   //排列牌大小(sorting the cards including numbers and color)
	
		System.out.printf("\n\nComputer got :"); //印出花色與數字(電腦)(output what the computer got)
		j = 0;
		Color_output(result_computer, j);
		Arrays.sort(result_computer);    //排序牌大小(sorting the cards including numbers and color)

		int [] number_user = new int [2];
		for(int i = 0; i <= 1; i++) {
			number_user[i] = result_user[i] % 100;    //產生玩家的數字矩陣(單純只有數字)(output the numbers of the yours without color)
		}
		Arrays.sort(number_user);     //排序牌大小(只排數字不考慮花色)(sorting the numbers of the cards without color)
		
		int [] number_computer = new int [2];
		for(int i = 0; i <= 1; i++) {
			number_computer[i] = result_computer[i] % 100;    //產生電腦的數字矩陣(單純只有數字)(output the numbers of the computer without color)
		}
		Arrays.sort(number_computer);    //排序牌大小(只排數字不考慮花色)(sorting the numbers of the cards without color)
		
		int [] color_user = new int [2];
		for(int i = 0; i <= 1; i++) {
			color_user[i] = result_user[i] / 100;    //產生玩家花色(單純只有花色)(output the color of yours without numbers)
		}
		Arrays.sort(color_user);     //排序牌大小(只排花色不考慮數字)(sorting the color of the cards without number)
		
		int [] color_computer = new int [2];
		for(int i = 0; i <= 1; i++) {
			color_computer[i] = result_computer[i] / 100;    //產生電腦花色(單純只有花色)(output the color of the computer without numbers)
		}
		Arrays.sort(color_computer);    //排序牌大小(只排花色不考慮數字)(sorting the color of the cards without number)
		
		Result_output(result_user, result_computer, number_user, number_computer, color_user, color_computer);//輸出比較結果(print the result of comparing with the computer)
		
		result_user = null; result_computer = null; number_user = null ; number_computer = null ; color_user = null; color_computer = null;//releasing all memory of arrays
	}

    //輸出花色方法(print the color of cards which you and the computer got)
    public static void Color_output(int [] x,int j) {
		while(j <= 1) {
			switch(x[j] / 100) {
			case 1 :
				System.out.printf("%s", "\u2663");break;
			case 2 :
				System.out.printf("%s", "\u2666");break;
			case 3:
				System.out.printf("%s", "\u2665");break;
			case 4:
				System.out.printf("%s", "\u2660");break;
				}
			switch(x[j] % 100) {
			case 14:
				System.out.printf("%c ",'A');break;
			case 13:
				System.out.printf("%c ",'K');break;
			case 12:
				System.out.printf("%c ",'Q');break;
			case 11:
				System.out.printf("%c ",'J');break;
			default:
				System.out.printf("%d ",(x[j] % 100));
				}
			j++;
		}	
    }

	//輸出比較結果(print the result of comparing with the computer)
	public static void Result_output(int [] result_user, int [] result_computer, int [] number_user, int [] number_computer, int [] color_user, int [] color_computer) {
		int count = 0;
		//同為pair玩家贏
		if(number_user[0] == number_user[1] && number_computer[0] == number_computer[1] && result_user[1] > result_computer[1]) {
			System.out.print("\n\nYou win!");
			count++;
		}
		
		//同為pair電腦贏
		if((count != 1) && number_user[0] == number_user[1] && number_computer[0] == number_computer[1] && result_user[1] < result_computer[1]) {
			System.out.print("\n\nComputer wins!");
			count++;
		}
				
		//pair玩家情況下勝利
		if(number_user[0] == number_user[1] && (count != 1)) {
			System.out.print("\n\nYou win!");
			count++;
		}
				
		//pair電腦情況下勝利
		if(number_computer[0] == number_computer[1] && (count != 1)) {
			System.out.print("\n\nComputer wins!");
			count++;
		}
		//四張牌都一樣大
		if(result_user[0] == result_computer[0] && result_user[0] == result_computer[1] && result_user[1] == result_computer[0]) {
			System.out.print("\n\ntie");
			count++;
		}
				
		//數字大於電腦
		if((number_user[1]) > (number_computer[1]) && (count != 1)){
			System.out.print("\n\nYou win!");
			count++;
		}
				
		//數字小於電腦
		if((number_user[1]) < (number_computer[1]) && (count != 1)){
			System.out.print("\n\nComputer wins!");
			count++;
		}
				
		//數字一樣花色大
		if((color_user[1] > color_computer[1]) && (result_user[1] > result_computer[1]) && (count != 1)) {
			System.out.printf("\n\nYou win!");
			count++;
		}
				
		//花色一樣數字一樣
		if((result_user[1] == result_computer[1]) && (color_user[1] == color_computer[1]) && (count != 1)){
			System.out.print("\n\nbreak even");
			count++;
		}
				
		//剩下的情況都電腦贏
		if(count != 1)
			System.out.printf("\n\nComputer wins!");
	}
}
