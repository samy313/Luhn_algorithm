import java.util.Scanner;

public class Luhn_formula {

    String card_number;

    public Luhn_formula (String card){
        this.card_number = card;
    }

    public String luhn_algorithm (){
        if(this.card_number.length() <= 1){
            return "Longueur invalide (doit être supérieur à 1).";
        } else {
            try{
                String [] card_number_format = this.card_number.replaceAll(" ", "").split("");
                int [] card_number = new int [card_number_format.length];
                for(int i = 0; i < card_number_format.length; i++){
                    card_number[i] = Integer.parseInt(card_number_format[i]);
                }
                for(int i = card_number.length-2; i >= 0 ; i-=2){
                    if((card_number[i] * 2) > 9){
                        card_number[i] = (card_number[i] *= 2) - 9;
                    } else {
                        card_number[i] *= 2;
                    }
                }

                int sum = 0;
                for(int digit : card_number){
                    sum += digit;
                }

                if(sum % 10 == 0) {
                    return sum + " est divisible par 10, donc ce numéro de carte (" + this.card_number + ") est valide !";
                } else {
                    return sum + " n'est pas divisible par 10, donc ce numéro de carte (" + this.card_number + ") est invalide.";
                }
            }catch(NumberFormatException e){
                return "Erreur : " + e + "\n" + "Chaîne invalide, seuls les chiffres sont autorisés.";
            }
        }
    }

    public static void main (String [] args){
        boolean again = true;
        while(again){
            System.out.println("Veuillez entrer un numéro de carte de crédit : ");
            Scanner sc = new Scanner(System.in);
            String card_number = sc.nextLine();
            Luhn_formula card1 = new Luhn_formula(card_number);
            String result1 = card1.luhn_algorithm();
            System.out.println(result1);
            System.out.println("Entrez un nouveau numéro (Y/N) ?");
            if(sc.next().equals("N")){
                System.out.println("Fin du programme.");
                again = false;
                sc.close();
            }
        }
    }
}
