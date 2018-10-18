import java.util.Arrays;
import java.util.Random;

public class Game {

	public static void main(String[] args) {
		//���Ͱ}�C���(100�P�j�p������ 200�^���...) �P�j�p(�q2�}�l)
		int poker [][] = new int [4][13];
		int color_recognize = 100;
		
		for(int i = 0; i <= 3;i++ ) {
			for(int j = 0; j <= 12; j++) {
				poker[i][j] = color_recognize + j + 2;
			}
			color_recognize = color_recognize + 100;
		}
		//�qpoker�x�}�����ͪ��a�P�q���}�C���P�j�p(taking 4 cards from poker ,two for the computer and two for you) 
		
		Random ran = new Random();
		int result_user [] = new int [2];
		for(int i = 0; i <= 1; i++) {
			result_user[i] = poker[ran.nextInt(4)][ran.nextInt(13)];    //���ͪ��a���P(output the cards of yours)
		}
		
		int result_computer [] = new int [2];
		for(int i = 0; i <= 1; i++) {
			result_computer[i] = poker[ran.nextInt(4)][ran.nextInt(13)];   //���͹q�����P(output the cards of computer)
		}
		
		poker = null;    //����poker���O����(releasing memory of poker )
		
		System.out.printf("I got: ");    //�L�X���P�Ʀr(���a)(output what you got)
		int j = 0;
		Color_output(result_user, j);
		Arrays.sort(result_user);   //�ƦC�P�j�p(sorting the cards including numbers and color)
	
		System.out.printf("\n\nComputer got :"); //�L�X���P�Ʀr(�q��)(output what the computer got)
		j = 0;
		Color_output(result_computer, j);
		Arrays.sort(result_computer);    //�ƧǵP�j�p(sorting the cards including numbers and color)

		int [] number_user = new int [2];
		for(int i = 0; i <= 1; i++) {
			number_user[i] = result_user[i] % 100;    //���ͪ��a���Ʀr�x�}(��¥u���Ʀr)(output the numbers of the yours without color)
		}
		Arrays.sort(number_user);     //�ƧǵP�j�p(�u�ƼƦr���Ҽ{���)(sorting the numbers of the cards without color)
		
		int [] number_computer = new int [2];
		for(int i = 0; i <= 1; i++) {
			number_computer[i] = result_computer[i] % 100;    //���͹q�����Ʀr�x�}(��¥u���Ʀr)(output the numbers of the computer without color)
		}
		Arrays.sort(number_computer);    //�ƧǵP�j�p(�u�ƼƦr���Ҽ{���)(sorting the numbers of the cards without color)
		
		int [] color_user = new int [2];
		for(int i = 0; i <= 1; i++) {
			color_user[i] = result_user[i] / 100;    //���ͪ��a���(��¥u�����)(output the color of yours without numbers)
		}
		Arrays.sort(color_user);     //�ƧǵP�j�p(�u�ƪ�⤣�Ҽ{�Ʀr)(sorting the color of the cards without number)
		
		int [] color_computer = new int [2];
		for(int i = 0; i <= 1; i++) {
			color_computer[i] = result_computer[i] / 100;    //���͹q�����(��¥u�����)(output the color of the computer without numbers)
		}
		Arrays.sort(color_computer);    //�ƧǵP�j�p(�u�ƪ�⤣�Ҽ{�Ʀr)(sorting the color of the cards without number)
		
		Result_output(result_user, result_computer, number_user, number_computer, color_user, color_computer);//��X������G(print the result of comparing with the computer)
		
		result_user = null; result_computer = null; number_user = null ; number_computer = null ; color_user = null; color_computer = null;//releasing all memory of arrays
}

    //��X����k(print the color of cards which you and the computer got)
    public static void Color_output(int [] x,int j) {
	    while(j <= 1) {
		  int temp = x[j] % 100;
		  if((x [j] > 100) && (x[j] < 200)) {
			  if(temp == 14)
				System.out.printf("%s%c ","\u2663",'A');
			  if(temp == 13)
				System.out.printf("%s%c ","\u2663",'K');	
			  if(temp == 12)		
				System.out.printf("%s%c ","\u2663",'Q');	
			  if(temp == 11)			
				System.out.printf("%s%c ","\u2663",'J');	
			  if(temp < 11)
				System.out.printf("%s%d ","\u2663",temp);
		}
		  if((x [j] > 200) && (x[j] < 300)) {
			  if(temp == 14)
				System.out.printf("%s%c ","\u2666",'A');
			  if(temp == 13)
				System.out.printf("%s%c ","\u2666",'K');	
			  if(temp == 12)		
				System.out.printf("%s%c ","\u2666",'Q');	
			  if(temp == 11)			
				System.out.printf("%s%c ","\u2666",'J');	
			  if(temp < 11)
				System.out.printf("%s%d ","\u2666",temp);
		}
		  if((x [j] > 300) && (x[j] < 400)) {
			  if(temp == 14)
				System.out.printf("%s%c ","\u2665",'A');
			  if(temp == 13)
				System.out.printf("%s%c ","\u2665",'K');	
			  if(temp == 12)		
				System.out.printf("%s%c ","\u2665",'Q');	
			  if(temp == 11)			
				System.out.printf("%s%c ","\u2665",'J');	
			  if(temp < 11)
				System.out.printf("%s%d ","\u2665",temp);
		}
		  if(x [j] > 400) {
			  if(temp == 14)
				System.out.printf("%s%c ","\u2660",'A');
			  if(temp == 13)
				System.out.printf("%s%c ","\u2660",'K');	
			  if(temp == 12)		
				System.out.printf("%s%c ","\u2660",'Q');	
			  if(temp == 11)			
				System.out.printf("%s%c ","\u2660",'J');	
			  if(temp < 11)
				System.out.printf("%s%d ","\u2660",temp);
		  }
		  j++;
	  }
   }

	//��X������G(print the result of comparing with the computer)
	public static void Result_output(int [] result_user, int [] result_computer, int [] number_user, int [] number_computer, int [] color_user, int [] color_computer) {
		int count = 0;
		//�P��pair���aĹ
		if(number_user[0] == number_user[1] && number_computer[0] == number_computer[1] && result_user[1] > result_computer[1]) {
			System.out.print("\n\nYou win!");
			count++;
		}
		
		//�P��pair�q��Ĺ
		if((count != 1) && number_user[0] == number_user[1] && number_computer[0] == number_computer[1] && result_user[1] < result_computer[1]) {
			System.out.print("\n\nComputer wins!");
			count++;
		}
				
		//pair���a���p�U�ӧQ
		if(number_user[0] == number_user[1] && (count != 1)) {
			System.out.print("\n\nYou win!");
			count++;
		}
				
		//pair�q�����p�U�ӧQ
		if(number_computer[0] == number_computer[1] && (count != 1)) {
			System.out.print("\n\nComputer wins!");
			count++;
		}
		//�|�i�P���@�ˤj
		if(result_user[0] == result_computer[0] && result_user[0] == result_computer[1] && result_user[1] == result_computer[0]) {
			System.out.print("\n\ntie");
			count++;
		}
				
		//�Ʀr�j��q��
		if((number_user[1]) > (number_computer[1]) && (count != 1)){
			System.out.print("\n\nYou win!");
			count++;
		}
				
		//�Ʀr�p��q��
		if((number_user[1]) < (number_computer[1]) && (count != 1)){
			System.out.print("\n\nComputer wins!");
			count++;
		}
				
		//�Ʀr�@�˪��j
		if((color_user[1] > color_computer[1]) && (result_user[1] > result_computer[1]) && (count != 1)) {
			System.out.printf("\n\nYou win!");
			count++;
		}
				
		//���@�˼Ʀr�@��
		if((result_user[1] == result_computer[1]) && (color_user[1] == color_computer[1]) && (count != 1)){
			System.out.print("\n\nbreak even");
			count++;
		}
				
		//�ѤU�����p���q��Ĺ
		if(count != 1)
			System.out.printf("\n\nComputer wins!");
	}
}
