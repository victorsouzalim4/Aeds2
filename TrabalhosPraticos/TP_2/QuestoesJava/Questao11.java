//package QuestoesJava;
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

class Lista {
    private String apelidos[];

    Lista(String frase) {

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
    private Lista alternate_names;
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

    public Personagem(String id, String name, Lista alternate_names, String house, String ancestry, String species,
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

    public Lista getAlternate_names() {
        return alternate_names;
    }

    public void setAlternate_names(Lista alternate_names) {
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

        System.out.print("[" + id + " ## " + name + " ## ");
        alternate_names.mostra();
        System.out.print(house + " ## " + ancestry + " ## " + species + " ## " + patronus + " ## ");
        System.out.print(hogwartsStaff + " ## ");
        System.out.print(hogwartsStudent + " ## " + actorName + " ## ");
        System.out.print(alive + " ## ");
        dateOfBirth.mostra();
        System.out.print(yearOfBirth + " ## ");
        System.out.print(eyeColour + " ## " + gender + " ## " + hairColour + " ## ");
        System.out.println(wizard + "]");

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

public class Questao11 {

    public static void frequenciaAcumulada(int aux[]){
        for(int i = 1; i < aux.length; i++){
            aux[i] += aux[i-1];
        }
    }

    public static void qtdOcorrenciasNoVetor(Personagem vetor[], int aux[]){
        for(int i = 0; vetor[i] != null && i < vetor.length; i++){
            aux[vetor[i].getYearOfBirth()]++;
        }
    }

    public static int getMaiorAno(Personagem vetor[]){
        int maior = vetor[1].getYearOfBirth();
        for(int i = 2; vetor[i] != null && i < vetor.length; i++){
            if(vetor[i].getYearOfBirth() > maior){
                maior = vetor[i].getYearOfBirth();
            }
        }

        return maior;
    }

    public static void swap(Personagem vetor[], int i, int j ){
        Personagem tmp = vetor[i].clone(vetor[i]);
        vetor[i] = vetor[j].clone(vetor[j]);
        vetor[j] = tmp.clone(tmp);
    }

    public static void SelectionSort(Personagem vetor[]){
        for(int i = 0; i < vetor.length - 1 && vetor[i] != null; i++){
            String menor = new String(vetor[i].getName());
            int tmp = i;
            for(int j = i + 1; j < vetor.length; j++){
                if(vetor[j] != null && vetor[j].getName().compareTo(menor) < 0){
                    menor = new String(vetor[j].getName());
                    tmp = j;
                    //System.out.println(maior);
                }
            }
            swap(vetor, i, tmp);
        }
    }

    public static void CountingSort(Personagem vetor[]){
        int aux[] = new int[getMaiorAno(vetor) + 1];
        Personagem tmp[] = new Personagem[vetor.length];

        for(int i = 0; i < aux.length; i++){
            aux[i] = 0;
        }

        qtdOcorrenciasNoVetor(vetor, aux);
        frequenciaAcumulada(aux);

        for(int i = tmp.length -1;  i >= 0; i--){
            if(vetor[i] != null){
                tmp[aux[vetor[i].getYearOfBirth()] -1] = vetor[i];
                aux[vetor[i].getYearOfBirth()]--;
            }
        }

        for(int i = 0; i < tmp.length; i++){
            vetor[i] = tmp[i];
        }


        //System.out.println(aux[1981]);
        //System.out.println(aux.length);
    }

    public static void isInVetor(Personagem vetor[], String name){
        Boolean test = false;

        for(int i = 0; i < vetor.length; i++){
            if(vetor[i] != null && vetor[i].getName().equals(name)){
                test = true;
                i = vetor.length;
            }
        }

        if(test == false){
            System.out.println("NAO");
        }
        else{
            System.out.println("SIM");
        }
    }

    public static int RegistraVetor(Personagem personagem[], Personagem vetor[], String id, int j){
        for(int i = 0; i < 405; i++){
            if(personagem[i].getId().equals(id)){
                vetor[j] = personagem[i].clone(personagem[i]);
                j++;
                i = 405;
            }
    
        }

        return j;
    }

    public static void getObjeto(String id, Personagem personagem[]) {
        for (int i = 0; i < personagem.length; i++) {
            if (personagem[i].getId().equals(id)) {
                personagem[i].imprime();
                i = personagem.length;
            }
        }
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

    public static String[] SeparaAtributos(String objeto) { // esta funcao separa os atributos do objeto que estão
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
        Personagem personagem[] = new Personagem[405];
        Personagem vetor[] = new Personagem[50];
        try {
            File myObj = new File("/tmp/characters.csv");
            Scanner Sc = new Scanner(myObj);
            Sc.nextLine();

            String atributos[] = new String[18];

            int i = 0;

            while (Sc.hasNextLine()) {
                String objeto = Sc.nextLine();
                atributos = SeparaAtributos(objeto);
                Lista list = new Lista(atributos[2]);
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

        String id = Sc.nextLine();
        int j = 0;
        while (isFim(id)) {
            j = RegistraVetor(personagem, vetor, id, j);
            id = Sc.nextLine();
        }

        SelectionSort(vetor);
        CountingSort(vetor);

        for(int i = 0; vetor[i] != null && i < 405; i++){
            vetor[i].imprime();
        }

        
        

    }
}

//C:/Users/Victor/Documents/FACULDADE/2 semestre/Aeds 2/TP_2/characters.csv
