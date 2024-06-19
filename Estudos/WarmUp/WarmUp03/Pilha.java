package Estudos.WarmUp.WarmUp03;

class Celula{
    Carro car;
    Celula prox;

    Celula(Carro car){
        this.car = car;
    }
}

class Pilha {
    Celula topo;
    int tamAtual;
    int tamMax;

    Pilha(int tamMax){
        this.topo = null;
        this.tamAtual = 0;
        this.tamMax = tamMax;
    }

    boolean inserir(Carro car){
        Celula novoCarro = new Celula(car);
        boolean flag = false;

        if(tamAtual < tamMax){
            flag = true;
            for(Celula i = topo; i != null && flag; i = i.prox){
                if(i.car.saida < novoCarro.car.saida){
                    flag = false;
                }
            }

            if(flag){
                novoCarro.prox = topo;
                topo = novoCarro;
                tamAtual++;
            }
        }else{
            if(novoCarro.car.entrada > topo.car.saida){
                flag = true;

                Celula tmp = topo;
                topo = topo.prox;
                tmp.prox = tmp = null;

                for(Celula i = topo; i != null && flag; i = i.prox){
                    if(i.car.saida < novoCarro.car.saida){
                        flag = false;
                    }
                }
    
                if(flag){
    
                    novoCarro.prox = topo;
                    topo = novoCarro;
                    tamAtual++;
                }
            }
        }

        return flag;
    }
}
