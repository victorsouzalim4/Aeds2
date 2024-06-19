package Questao1;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//classes


class DateTime {
    private String day;
    private String month;
    private String year;

    DateTime(String data) {
        String valores[] = new String[3];
        pegaValores(data, valores);

        this.day = valores[0];
        this.month = valores[1];
        this.year = valores[2];
    }

    public void pegaValores(String data, String[] valores) {
        int pos = 0;

        for (int i = 0; i < valores.length; i++) {
            StringBuilder str = new StringBuilder();

            for (int j = pos; j < data.length(); j++) {
                if (data.charAt(j) != '-') {
                    str.append(data.charAt(j));
                } else {
                    pos = ++j;
                    j = data.length();
                }
            }
            valores[i] = new String(str);
        }
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void mostra() {
        System.out.print(day + "-" + month + "-" + year + " ## ");
    }

}

class ListaApelidos {
    private String apelidos[];

    ListaApelidos(String frase) {

        int qtd = NumApelidos(frase);
        apelidos = new String[qtd];
        pegaApelido(frase, apelidos);

    }

    public void pegaApelido(String frase, String[] Apelidos) {
        int pos = 0;

        for (int i = 0; i < Apelidos.length; i++) {
            int qtd = 0;
            StringBuilder str = new StringBuilder();

            for (int j = pos; j < frase.length(); j++) {
                int Vascii = frase.charAt(j);

                if (Vascii == 39) {
                    qtd++;
                    j++;
                }

                if (qtd != 0) {
                    if (qtd == 1) {
                        str.append(frase.charAt(j));
                    } else {
                        pos = j;
                        j = frase.length();
                    }
                }
            }

            apelidos[i] = new String(str);

        }
    }

    public int NumApelidos(String frase) {
        int qtd = 0;

        for (int i = 0; i < frase.length(); i++) {
            int Vascii = frase.charAt(i);
            if (Vascii == 39) {
                qtd++;
            }
        }

        return qtd / 2;
    }

    public String[] getapelidos() {
        return apelidos;
    }

    public void setapelidos(String[] apelidos) {
        this.apelidos = apelidos;
    }

    public void mostra() {
        System.out.print("{");
        for (int i = 0; i < apelidos.length; i++) {
            if (i != apelidos.length - 1) {
                System.out.print(apelidos[i] + ", ");
            } else {
                System.out.print(apelidos[i]);
            }

        }
        System.out.print("}" + " ## ");
    }
}

class Personagem {
    private String id;
    private String name;
    private ListaApelidos alternate_names;
    private String house;
    private String ancestry;
    private String species;
    private String patronus;
    private Boolean hogwartsStaff;
    private Boolean hogwartsStudent;
    private String actorName;
    private Boolean alive;
    private DateTime dateOfBirth;
    private int yearOfBirth;
    private String eyeColour;
    private String gender;
    private String hairColour;
    private Boolean wizard;

    public Personagem(String id, String name, ListaApelidos alternate_names, String house, String ancestry, String species,
            String patronus, Boolean hogwartsStaff, Boolean hogwartsStudent, String actorName, Boolean alive,
            DateTime dateOfBirth, int yearOfBirth, String eyeColour, String gender, String hairColour, Boolean wizard) {
        this.id = id;
        this.name = name;
        this.alternate_names = alternate_names;
        this.house = house;
        this.ancestry = ancestry;
        this.species = species;
        this.patronus = patronus;
        this.hogwartsStaff = hogwartsStaff;
        this.hogwartsStudent = hogwartsStudent;
        this.actorName = actorName;
        this.alive = alive;
        this.dateOfBirth = dateOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.eyeColour = eyeColour;
        this.gender = gender;
        this.hairColour = hairColour;
        this.wizard = wizard;
    }

    // getters ans setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ListaApelidos getAlternate_names() {
        return alternate_names;
    }

    public void setAlternate_names(ListaApelidos alternate_names) {
        this.alternate_names = alternate_names;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getAncestry() {
        return ancestry;
    }

    public void setAncestry(String ancestry) {
        this.ancestry = ancestry;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getPatronus() {
        return patronus;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }

    public Boolean getHogwartsStaff() {
        return hogwartsStaff;
    }

    public void setHogwartsStaff(Boolean hogwartsStaff) {
        this.hogwartsStaff = hogwartsStaff;
    }

    public Boolean getHogwartsStudent() {
        return hogwartsStudent;
    }

    public void setHogwartsStudent(Boolean hogwartsStudent) {
        this.hogwartsStudent = hogwartsStudent;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public DateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHairColour() {
        return hairColour;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public Boolean getWizard() {
        return wizard;
    }

    public void setWizard(Boolean wizard) {
        this.wizard = wizard;
    }

    // outros métodos

    public void imprime() {

        System.out.print( id + " ## " + name + " ## ");
        alternate_names.mostra();
        System.out.print(house + " ## " + ancestry + " ## " + species + " ## " + patronus + " ## ");
        System.out.print(hogwartsStaff + " ## ");
        System.out.print(hogwartsStudent + " ## " + actorName + " ## ");
        System.out.print(alive + " ## ");
        dateOfBirth.mostra();
        System.out.print(yearOfBirth + " ## ");
        System.out.print(eyeColour + " ## " + gender + " ## " + hairColour + " ## ");
        System.out.print(wizard);

    }

    public Personagem clone(Personagem personagem) {

        Personagem clone = new Personagem(
            personagem.getId(),
            personagem.getName(),
            personagem.getAlternate_names(),
            personagem.getHouse(),
            personagem.getAncestry(),
            personagem.getSpecies(),
            personagem.getPatronus(),
            personagem.getHogwartsStaff(),
            personagem.getHogwartsStudent(),
            personagem.getActorName(),
            personagem.getAlive(),
            personagem.getDateOfBirth(),
            personagem.getYearOfBirth(),
            personagem.getEyeColour(),
            personagem.getGender(),
            personagem.getHairColour(),
            personagem.getWizard()
        );

        return clone;
    }
}

class Lista{
    private int tamanho;
    private Personagem[] lista;

    Lista(){
        this.tamanho = 0;
        this.lista = new Personagem[404];
    }

    public void inserirFim(Personagem personagem){
        if(tamanho >= lista.length || personagem == null){
            try{
                if(personagem == null){
                    throw new Exception("Valor nulo");
                }else{
                    throw new Exception("ERRO, lista cheia!!");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            lista[tamanho] = personagem;
            tamanho++;
        }
    }

    public void inserirInicio(Personagem personagem){
        if(tamanho >= lista.length || personagem == null){
            try{
                if(personagem == null){
                    throw new Exception("Valor nulo");
                }else{
                    throw new Exception("ERRO, lista cheia!!");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            for(int i = tamanho; i > 0; i--){
                lista[i] = lista[i-1];
            }
            lista[0] = personagem;
            tamanho++;
        }
    }

    public void inserir(Personagem personagem, int pos){
        if(tamanho >= lista.length || personagem == null || pos > tamanho || pos < 0){
            try{
                if(personagem == null){
                    throw new Exception("Valor nulo");
                }else if(tamanho >= lista.length){
                    throw new Exception("ERRO, lista cheia!!");
                }else{
                    throw new Exception("ERRO, posicao invalida");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            for(int i = tamanho; i > pos; i--){
                lista[i] = lista[i-1];
            }
            lista[pos] = personagem;
            tamanho++;
        }
    }

    public Personagem removerInicio(){
        Personagem personagem = null;
        if(tamanho == 0 ){
            try{
                throw new Exception("ERRO, lista vazia!!");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            personagem = lista[0];
            for(int i = 0; i < tamanho; i++){
                lista[i] = lista[i+1];
            }
            tamanho--;
        }

        return personagem;
    }

    public Personagem removerFim(){
        Personagem personagem = null;
        if(tamanho == 0){
            try{
                throw new Exception("ERRO, lista vazia!!");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            personagem = lista[tamanho-1];
            tamanho--;
        }

        return personagem;
    }

    public Personagem remover(int pos){
        Personagem personagem = null;
        if(tamanho == 0 || pos >= tamanho || pos < 0){
            try{
                if(pos >= tamanho || pos < 0){
                    throw new Exception("ERRO, posicao invalida");
                }else{
                    throw new Exception("ERRO, lista vazia!!");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            personagem = lista[pos];
            for(int i = pos; i < tamanho; i++){
                lista[i] = lista[i+1];
            }
            tamanho--;
        }

        return personagem;
    }

    public void mostra(){
        for(int i = 0; i < tamanho; i++){
            System.out.print("[" + i + " ## ");
            lista[i].imprime();
            System.out.println("]" );
        }

    }
}

public class ListaSequencial {

    public static int getEndOfNumber(String entrada){
        int i;

        for(i = 3; i < entrada.length() && entrada.charAt(i) != ' ' && entrada.charAt(i) != '\0'; i++);
        
        return i;
    }

    public static String getId(String entrada){
        String id;
        if(Integer.parseInt(entrada.substring(3, getEndOfNumber(entrada))) > 99){
            id = entrada.substring(7);
        }else if(Integer.parseInt(entrada.substring(3, getEndOfNumber(entrada))) > 9){
            id = entrada.substring(6);
        }else{
            id = entrada.substring(5);
        }

        return id;
    }

    public static int getOperacao(String entrada){
        int resp;
        if(entrada.charAt(0) == 'I'){
            if(entrada.charAt(1) == 'I'){
                resp = 0;
            }else if(entrada.charAt(1) == 'F'){
                resp = 1;
            }else{
                resp = 2;
            }
        }else{
            if(entrada.charAt(1) == 'I'){
                resp = 3;
            }else if(entrada.charAt(1) == 'F'){
                resp = 4;
            }else{
                resp = 5;
            }
        }

        return resp;
    }

    public static Personagem getPersonagem(String id, Personagem personagem[]) {
        Personagem tmp = null;
        for (int i = 0; i < personagem.length; i++) {
            if (personagem[i].getId().equals(id)) {
                tmp = personagem[i];
                i = personagem.length;
            }
        }
        return tmp;
    }

    public static Boolean isFim(String frase) {
        Boolean test = true;

        if (frase.equals("FIM")) {
            test = false;
        }

        return test;
    }

    public static Boolean stringToBoolean(String frase) {
        Boolean valorlogico = false;
        if (frase.equals("VERDADEIRO")) {
            valorlogico = true;
        }

        return valorlogico;
    }

    public static String[] separaAtributos(String objeto) { // esta funcao separa os atributos do objeto que estão
                                                            // contidos em uma string e
                                                            // os guarda separadamente em um array
        String atributos[] = new String[18];
        int pos = 0;

        for (int i = 0; i < atributos.length; i++) {
            StringBuilder aux = new StringBuilder();

            for (int j = pos; j < objeto.length() && objeto.charAt(j) != ';'; j++) {
                aux.append(objeto.charAt(j));
            }

            pos = pos + aux.length() + 1;

            String str = new String(aux);
            atributos[i] = str;

        }

        return atributos;
    }

    public static void main(String[] args) {
        Personagem personagem[] = new Personagem[404];

        try {
            File myObj = new File("C:/Users/Victor/Documents/FACULDADE/2 semestre/Aeds 2/TP_3/Trabalho_Pratico3/characters.csv");
            Scanner Sc = new Scanner(myObj);
            Sc.nextLine();

            String atributos[] = new String[18];

            int i = 0;

            while (Sc.hasNextLine()) {
                String objeto = Sc.nextLine();
                atributos = separaAtributos(objeto);
                ListaApelidos list = new ListaApelidos(atributos[2]);
                DateTime data = new DateTime(atributos[12]);
                int ano = Integer.parseInt(atributos[13]);
                personagem[i] = new Personagem(atributos[0], atributos[1], list, atributos[3], atributos[4],
                        atributos[5], atributos[6], stringToBoolean(atributos[7]), stringToBoolean(atributos[8]),
                        atributos[9], stringToBoolean(atributos[10]), data, ano, atributos[14], atributos[15],
                        atributos[16], stringToBoolean(atributos[17]));
                i++;
            }

            Sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERRO");
            e.printStackTrace();
        }

        Scanner Sc = new Scanner(System.in);
        Lista list = new Lista();

        String id = Sc.nextLine();

        while(isFim(id)){
            Personagem personagemAtual = getPersonagem(id, personagem);
            if(personagemAtual != null){
                list.inserirFim(personagemAtual);
            }
            id = Sc.nextLine();
        }

        int numEntradas = Sc.nextInt();
        Sc.nextLine();

        for(int i = 0; i < numEntradas; i++){
            String entrada = Sc.nextLine();   

            switch (getOperacao(entrada)) {
                case 0:
                    list.inserirInicio(getPersonagem(entrada.substring(3), personagem));
                    break;
                case 1:
                list.inserirFim(getPersonagem(entrada.substring(3), personagem));
                    break;
                case 2:
                list.inserir(getPersonagem(getId(entrada), personagem), Integer.parseInt(entrada.substring(3, getEndOfNumber(entrada))));    
                    break;
                case 3:
                System.out.println("(R) " + list.removerInicio().getName());  
                    break;
                case 4:
                System.out.println("(R) " + list.removerFim().getName());  
                    break;
                case 5:
                System.out.println("(R) " + list.remover(Integer.parseInt(entrada.substring(3, getEndOfNumber(entrada)))).getName());   
                    break;
            }
        }

        list.mostra();

        Sc.close();
    }
}



//C:/Users/Victor/Documents/FACULDADE/2 semestre/Aeds 2/TP_3/Trabalho_Pratico3/characters.csv
//tmp/characters.csv