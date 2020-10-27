package aberimen.com.renkleralemi;

/**
 * Created by aberimen on 28.10.2017.
 */

public class Level {

    private int renkR;
    private int renkG;
    private int renkB;
    private boolean koyuMu;
    private int satirSutun;
    private int params;

    public Level(int level){
        if(level == 1){
            levelAyar(244,67,54,640,2,false);
        }
        else if(level == 2){
            levelAyar(0,131,43,640,2,true);
        }

        else if(level == 3){
            levelAyar(93,64,55,640,2,true);
        }

        else if(level == 4){
            levelAyar(85,139,47,640,2,false);
        }
        else if(level == 5){
            levelAyar(57,73,171,425,3,true);
        }

        else if(level == 6){
            levelAyar(192,202,51,425,3,false);
        }

        else if(level == 7){
            levelAyar(84,110,122,317,4,false);
        }

        else if(level == 8){
            levelAyar(197,17,98,317,4,true);
        }

        else if(level == 9){
            levelAyar(255,61,0,252,5,true);
        }

        else if(level == 10){
            levelAyar(0,105,92,252,5,false);
        }

        else if(level == 11){
            levelAyar(93,64,55,210,6,true);
        }

        else if(level == 12){
            levelAyar(76,175,80,210,6,false);
        }

    }


    private void levelAyar(int R,int G,int B, int params,int satirSutun,boolean koyuMu){

            setRenkR(R);
            setRenkB(G);
            setRenkG(B);
            setParams(params);
            setSatirSutun(satirSutun);
            setKoyuMu(koyuMu);

    }


    public int getRenkR() {
        return renkR;
    }

    public void setRenkR(int renkR) {
        this.renkR = renkR;
    }

    public int getRenkG() {
        return renkG;
    }

    public void setRenkG(int renkG) {
        this.renkG = renkG;
    }

    public int getRenkB() {
        return renkB;
    }

    public void setRenkB(int renkB) {
        this.renkB = renkB;
    }

    public boolean isKoyuMu() {
        return koyuMu;
    }

    public void setKoyuMu(boolean koyuMu) {
        this.koyuMu = koyuMu;
    }

    public int getSatirSutun() {
        return satirSutun;
    }

    public void setSatirSutun(int satirSutun) {
        this.satirSutun = satirSutun;
    }

    public int getParams() {
        return params;
    }

    public void setParams(int params) {
        this.params = params;
    }





}
