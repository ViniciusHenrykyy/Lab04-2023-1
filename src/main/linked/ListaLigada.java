package linked;

import list.EstruturaElementar;

public class ListaLigada implements EstruturaElementar{

    private No cabeca;

    public ListaLigada() {
        cabeca = null;
    }

    @Override
    public boolean buscaElemento(int valor){
    if (cabeca == null){
        return false;
    }
    No cabeca = this.cabeca;
    while(cabeca != null){
        if(cabeca.getValor() == valor){
            return true;
        }
        cabeca = cabeca.getProximo();
    }
    return false;
    }

    @Override
    public int buscaIndice(int valor){
        if (cabeca == null){
            return -1;
        } 
        int contador = 0;
        for (No index = cabeca; index != null; index = index.getProximo()) {
            if (contador == valor){
                return index.getValor();
            }
            contador++;
        }
        return -1;
    }

    @Override
    public int minimo(){
        if(this.cabeca == null){   
            return -1;
        }else{
            No mao = this.cabeca;
            int valorminimo = mao.getValor();
            while(true){
              No mochila_dentro_mochila = mao.getProximo();
              if(mochila_dentro_mochila == null){
                break;
              }else{
                if(mochila_dentro_mochila.getValor() < valorminimo){
                    valorminimo = mochila_dentro_mochila.getValor();
                }
                mao = mochila_dentro_mochila;
              }
            }
            return valorminimo;
        }
    }

    @Override
    public int maximo(){
        if(this.cabeca == null){   
            return -1;
        }else{
            No mao = this.cabeca;
            int valormaximo = mao.getValor();
            while(true){
              No mochila_dentro_mochila = mao.getProximo();
              if(mochila_dentro_mochila == null){
                break;
              }else{
                if(mochila_dentro_mochila.getValor() > valormaximo){
                    valormaximo = mochila_dentro_mochila.getValor();
                }
                mao = mochila_dentro_mochila;
              }
            }
            return valormaximo;
        }
    }
    

    @Override
    public int predecessor(int valor) {
        return buscaIndice(valor - 1);
    }

    @Override
    public int sucessor(int valor) {
        int contador = 0;
        No mao = this.cabeca;
        No mochila_dentro_mochila = mao.getProximo();
        while(mochila_dentro_mochila != null){
            if(contador == valor){
                return mochila_dentro_mochila.getValor();
            }
            contador++;
            mao = mao.getProximo();
            mochila_dentro_mochila = mao.getProximo();   
        }
        return -1;
    }

    @Override
    public void insereElemento(int valor) {
        insereInicio(valor);
    }

    @Override // [Erick, vinicius, Glad]
    public void insereElementoPosicao(int valor, int buscaIndice) {
        No mochila = new No(valor);
        if (cabeca == null){
            this.cabeca = mochila;
        }else{
            if(buscaIndice == 0){
                mochila.setProximo(this.cabeca);
                this.cabeca = mochila;

            }
            int contador = 1;
            No mao = this.cabeca;
            No mochila_dentro_mochila = mao.getProximo();
            while(mochila_dentro_mochila != null){
                if(contador == buscaIndice){
                   mochila.setProximo(mochila_dentro_mochila);
                   mao.setProximo(mochila);
                   return; 
                }
                contador++;
                mao = mao.getProximo();
                mochila_dentro_mochila = mao.getProximo();
  
            }
        }        
    }

    @Override
    public void insereInicio(int valor) {
        No mochila = new No(valor);
        if (this.cabeca == null){
            this.cabeca = mochila;
        }else{
            mochila.setProximo(this.cabeca);
            this.cabeca = mochila;
        }
    }

    @Override
    public void insereFim(int valor) {
        No mochila = new No(valor);
        if (this.cabeca == null){
            this.cabeca = mochila;  
        }else{
            No mao = this.cabeca;
            while(true){
                No mochila_dentro_mochila = mao.getProximo();
                if(mochila_dentro_mochila == null){
                    mao.setProximo(mochila);
                    break;
                }else{
                    mao = mochila_dentro_mochila;
                }  
            }
        }    
    }

    @Override
    public void remove(int valor) {
        if(this.cabeca != null){
            No mao = this.cabeca;
            if(mao.getValor() == valor){
                this.cabeca = this.cabeca.getProximo();
                return;
            }
            while(true){
                 No mochila_dentro_mochila = mao.getProximo();
                if(mochila_dentro_mochila == null){
                    break;
                }
                if(mochila_dentro_mochila.getValor() == valor){
                    mao.setProximo(null);
                    break;
                }else{
                    mao = mochila_dentro_mochila;
                }                                   
            }
        }      
    }

    @Override //[Erick, Vinicius, Gui, Glad]
    public void removeIndice(int indice) {
             if (cabeca == null){
            return;
        } 
        if(indice == 0){
            removeInicio();
            return;
        }
        int contador = 0;
        No mao = this.cabeca;
        No mochila_dentro_mochila = mao.getProximo();
        while(mochila_dentro_mochila != null){
            if (contador == indice){
                mao.setProximo(mochila_dentro_mochila.getProximo());
                return;
            }
            contador++;
            mao = mao.getProximo();
            mochila_dentro_mochila = mao.getProximo();
        }
    }

    @Override
    public void removeInicio() {
        if(this.cabeca != null){
            No mao = this.cabeca;
            No mochila_dentro_mochila = mao.getProximo();
            this.cabeca = mochila_dentro_mochila;
        }
    }
    //[5,4,3,2,1]
    @Override
    public void removeFim() {
        if(this.cabeca != null){//n
            No mao = this.cabeca;//mão é = 5
            while(true){//mão = 5 // loop // mão = 4// mão = 3// mão = 2// 
                No mochila_dentro_mochila = mao.getProximo();// 4 // 3// 2 // 1
                if(mochila_dentro_mochila == null){// ñ // ñ // ñ // ñ //
                    break;
                }
                if(mochila_dentro_mochila.getProximo() == null){// 3 e ñ// 2 e ñ// 1 e ñ//null sim //
                    mao.setProximo(null);
                    break;
                }else{
                    mao = mochila_dentro_mochila;// 4 // 3 // 2 //
                }
            }  
        }
    }
}
