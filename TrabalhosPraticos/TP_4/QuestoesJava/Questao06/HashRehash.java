package QuestoesJava.Questao06;

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

    public Personagem(String id, String name, ListaApelidos alternate_names, String house, String ancestry,
            String species,
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

        System.out.print(id + " ## " + name + " ## ");
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
                personagem.getWizard());

        return clone;
    }
}


class Tabela {
    Personagem[] tabela;
    int tam;

    Tabela() {
        this.tam = 21;
        this.tabela = new Personagem[21];

        for (int i = 0; i < tabela.length; i++) {
            tabela[i] = null;
        }
    }

    public void inserir(Personagem personagem) {
        int pos = hash(personagem.getName());

        if (tabela[pos] == null) {
            tabela[pos] = personagem;
        } else {
            if(tabela[rehash(personagem.getName())] == null){
                tabela[rehash(personagem.getName())] = personagem;
            }
        }
    }

    private int hash(String nome) {
        int soma = 0;
        for (int i = 0; i < nome.length(); i++) {
            soma += nome.charAt(i);
        }
        return soma % tam;
    }

    private int rehash(String nome){
        int soma = 1;
        for (int i = 0; i < nome.length(); i++) {
            soma += nome.charAt(i);
        }
        return soma % tam;
    }

    public void pesquisa(String nome) {
        int pos = hash(nome);

        if (tabela[pos] != null && tabela[pos].getName().equals(nome)) {
            System.out.println(nome + " (pos: " + pos + ") SIM");
        } else if(tabela[rehash(nome)] != null && tabela[rehash(nome)].getName().equals(nome)) {
            System.out.println(nome + " (pos: " + rehash(nome) + ") SIM");
        }else{
            System.out.println(nome + " NAO");
        }
    }

    public void mostra() {
        for (int i = 0; i < tam; i++) {
            if (tabela[i] != null) {
                tabela[i].imprime();
                System.out.println();
            }
        }
    }
}

public class HashRehash {

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
            File myObj = new File(
                    "tmp/characters.csv");
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
        Tabela table = new Tabela();

        String id = Sc.nextLine();

        while (isFim(id)) {
            Personagem personagemAtual = getPersonagem(id, personagem);
            if (personagemAtual != null) {
                table.inserir(personagemAtual);
            }
            id = Sc.nextLine();
        }

        String name = Sc.nextLine();
        while (isFim(name)) {
            table.pesquisa(name);
            name = Sc.nextLine();
        }

        //table.mostra();
        Sc.close();
    }
}

// C:/Users/Victor/Documents/FACULDADE/2 semestre/Aeds2/TP_4/TrabalhoPratico04/characters.csv
// tmp/characters.csv
