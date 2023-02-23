import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

public class CodiceFiscale {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Inserire cognome\n>");
        String cognome = sc.next();
        System.out.print("Inserire nome\n>");
        String nome = sc.next();
        System.out.print("Data di nascita\n");
        System.out.print("Inserire giorno\n>");
        Integer giorno = sc.nextInt();
        System.out.print("Inserire mese\n>");
        Integer mese = sc.nextInt();
        System.out.print("Inserire anno\n>");
        Integer anno = sc.nextInt();
        System.out.print("Inserire sesso\n>");
        char sesso = sc.next().charAt(0);
        System.out.print("Inserire comune/nazione estera di nascita\n>");
        String comune= sc.next();
        String codiceFiscale = "";
        cognome=cognome.toUpperCase();
        cognome=cognome.replace(" ", "");
        nome=nome.toUpperCase();
        nome=nome.replace(" ", "");
        for(int i=0;i<cognome.length();i++){
            if(cognome.charAt(i)!='A'&&cognome.charAt(i)!='E'&&cognome.charAt(i)!='I'&&cognome.charAt(i)!='O'&&cognome.charAt(i)!='U'&&codiceFiscale.length()<3){
                codiceFiscale+=cognome.charAt(i);
            }
        }
        //non abbastatanza consonanti
        if(codiceFiscale.length()!=3){
            for(int i=0;i<cognome.length();i++){
                if((cognome.charAt(i)=='A'||cognome.charAt(i)=='E'||cognome.charAt(i)=='I'||cognome.charAt(i)=='O'||cognome.charAt(i)=='U')&&codiceFiscale.length()<3){
                    codiceFiscale+=cognome.charAt(i);
                }
            }
        }
        //non abbastanza lettere
        if(codiceFiscale.length()!=3){
            while(codiceFiscale.length()!=3){
                codiceFiscale+='X';
            }
        }
        //System.out.println(codiceFiscale);
        //conto consonanti
        int c=0;
        for(int i=0;i<nome.length();i++){
            if(nome.charAt(i)!='A'&&nome.charAt(i)!='E'&&nome.charAt(i)!='I'&&nome.charAt(i)!='O'&&nome.charAt(i)!='U'){
                c++;
            }
        }
        if(c>3){
            c=0;
            for(int i=0;i<nome.length();i++){
                if(nome.charAt(i)!='A'&&nome.charAt(i)!='E'&&nome.charAt(i)!='I'&&nome.charAt(i)!='O'&&nome.charAt(i)!='U'&&codiceFiscale.length()<6){
                    if(c!=1){
                        codiceFiscale+=nome.charAt(i);
                    }
                    c++;
                }
            }
        }else{
            for(int i=0;i<nome.length();i++){
                if(nome.charAt(i)!='A'&&nome.charAt(i)!='E'&&nome.charAt(i)!='I'&&nome.charAt(i)!='O'&&nome.charAt(i)!='U'&&codiceFiscale.length()<6){
                    codiceFiscale+=nome.charAt(i);
                }
            }
        }
        //non abbastatanza consonanti
        if(codiceFiscale.length()!=6){
            for(int i=0;i<nome.length();i++){
                if((nome.charAt(i)=='A'||nome.charAt(i)=='E'||nome.charAt(i)=='I'||nome.charAt(i)=='O'||nome.charAt(i)=='U')&&codiceFiscale.length()<6){
                    codiceFiscale+=nome.charAt(i);
                }
            }
        }
        //non abbastanza lettere
        if(codiceFiscale.length()!=6){
            while(codiceFiscale.length()!=6){
                codiceFiscale+='X';
            }
        }
        //System.out.println(codiceFiscale);
        anno=anno%100;
        String annoS = anno.toString();
        if(anno<10){
            codiceFiscale+='0';
        }
        codiceFiscale+=annoS;
        //System.out.println(codiceFiscale);
        char ch='/';
        switch(mese){
            case 1:
                ch='A';
                break;
            case 2:
                ch='B';
                break;
            case 3:
                ch='C';
                break;
            case 4:
                ch='D';
                break;
            case 5:
                ch='E';
                break;
            case 6:
                ch='H';
                break;
            case 7:
                ch='L';
                break;
            case 8:
                ch='M';
                break;
            case 9:
                ch='P';
                break;
            case 10:
                ch='R';
                break;
            case 11:
                ch='S';
                break;
            case 12:
                ch='T';
                break;
        }
        codiceFiscale+=ch;
        //System.out.println(codiceFiscale);
        if(sesso=='F'||sesso=='f'){
            giorno+=40;
        }
        if(giorno<10){
            codiceFiscale+='0';
        }
        String giornoS = giorno.toString();
        codiceFiscale+=giornoS;
        //System.out.println(codiceFiscale);
        File fread = new File ("listaCodiciCatastali.txt");
        BufferedReader br = new BufferedReader(new FileReader(fread));
        String freadLine = "";
        comune=comune.toUpperCase();
        String codiceCatastale="";
        while ((freadLine=br.readLine()) != null) {
            String comuneR=freadLine.substring(0,freadLine.indexOf(";"));
            //System.out.println(comuneR);
            if (comune.equals(comuneR)) {
                for (int i = freadLine.indexOf(";") + 1; i < freadLine.length(); i++) {
                    //System.out.print(freadLine.charAt(i));
                    codiceCatastale+=freadLine.charAt(i);
                }
                //System.out.print("\n");
            }
        }
        codiceFiscale+=codiceCatastale;
        //System.out.println(codiceFiscale);
        Integer somma=0;
        for(int i=0;i<codiceFiscale.length();i++){
            if(i%2==1){
                switch(codiceFiscale.charAt(i)){
                    case 'A':
                        somma+=0;
                        break;
                    case '0':
                        somma+=0;
                        break;
                    case 'B':
                        somma+=1;
                        break;
                    case '1':
                        somma+=1;
                        break;
                    case 'C':
                        somma+=2;
                        break;
                    case '2':
                        somma+=2;
                        break;
                    case 'D':
                        somma+=3;
                        break;
                    case '3':
                        somma+=3;
                        break;
                    case 'E':
                        somma+=4;
                        break;
                    case '4':
                        somma+=4;
                        break;
                    case 'F':
                        somma+=5;
                        break;
                    case '5':
                        somma+=5;
                        break;
                    case 'G':
                        somma+=6;
                        break;
                    case '6':
                        somma+=6;
                        break;
                    case 'H':
                        somma+=7;
                        break;
                    case '7':
                        somma+=7;
                        break;
                    case 'I':
                        somma+=8;
                        break;
                    case '8':
                        somma+=8;
                        break;
                    case 'J':
                        somma+=9;
                        break;
                    case '9':
                        somma+=9;
                        break;
                    case 'K':
                        somma+=10;
                        break;
                    case 'L':
                        somma+=11;
                        break;
                    case 'M':
                        somma+=12;
                        break;
                    case 'N':
                        somma+=13;
                        break;
                    case 'O':
                        somma+=14;
                        break;
                    case 'P':
                        somma+=15;
                        break;
                    case 'Q':
                        somma+=16;
                        break;
                    case 'R':
                        somma+=17;
                        break;
                    case 'S':
                        somma+=18;
                        break;
                    case 'T':
                        somma+=19;
                        break;
                    case 'U':
                        somma+=20;
                        break;
                    case 'V':
                        somma+=21;
                        break;
                    case 'W':
                        somma+=22;
                        break;
                    case 'X':
                        somma+=23;
                        break;
                    case 'Y':
                        somma+=24;
                        break;
                    case 'Z':
                        somma+=25;
                        break;
                }
            }else{
                switch(codiceFiscale.charAt(i)){
                    case 'A':
                        somma+=1;
                        break;
                    case '0':
                        somma+=1;
                        break;
                    case 'B':
                        somma+=0;
                        break;
                    case '1':
                        somma+=0;
                        break;
                    case 'C':
                        somma+=5;
                        break;
                    case '2':
                        somma+=5;
                        break;
                    case 'D':
                        somma+=7;
                        break;
                    case '3':
                        somma+=7;
                        break;
                    case 'E':
                        somma+=9;
                        break;
                    case '4':
                        somma+=9;
                        break;
                    case 'F':
                        somma+=13;
                        break;
                    case '5':
                        somma+=13;
                        break;
                    case 'G':
                        somma+=15;
                        break;
                    case '6':
                        somma+=15;
                        break;
                    case 'H':
                        somma+=17;
                        break;
                    case '7':
                        somma+=17;
                        break;
                    case 'I':
                        somma+=19;
                        break;
                    case '8':
                        somma+=19;
                        break;
                    case 'J':
                        somma+=21;
                        break;
                    case '9':
                        somma+=21;
                        break;
                    case 'K':
                        somma+=2;
                        break;
                    case 'L':
                        somma+=4;
                        break;
                    case 'M':
                        somma+=18;
                        break;
                    case 'N':
                        somma+=20;
                        break;
                    case 'O':
                        somma+=11;
                        break;
                    case 'P':
                        somma+=3;
                        break;
                    case 'Q':
                        somma+=6;
                        break;
                    case 'R':
                        somma+=8;
                        break;
                    case 'S':
                        somma+=12;
                        break;
                    case 'T':
                        somma+=14;
                        break;
                    case 'U':
                        somma+=16;
                        break;
                    case 'V':
                        somma+=10;
                        break;
                    case 'W':
                        somma+=22;
                        break;
                    case 'X':
                        somma+=25;
                        break;
                    case 'Y':
                        somma+=24;
                        break;
                    case 'Z':
                        somma+=23;
                        break;
                }
            }
        }
        int resto = somma%26;
        //System.out.println(resto);
        resto += 65;
        ch=(char)resto;
        //System.out.println(ch);
        codiceFiscale+=ch;
        System.out.println(codiceFiscale);
    }
}