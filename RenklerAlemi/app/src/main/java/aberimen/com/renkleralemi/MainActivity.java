package aberimen.com.renkleralemi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int[] renkDizisi, renkKopya;
    GridLayout gridLayout;
    Button[] butonDizisi;
    Level level;
    ImageView imageView;
    TextView time,puanTV;
    int bolum=1;
    CountDownTimer countDownTimer;
    long currentTime;
    int puan =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.renkTonu);
        puanTV = (TextView)findViewById(R.id.puanTv);
        oyunOlustur();
    }

    private void oyunOlustur(){
        timer(13000);
        level = new Level(bolum);
        puanTV.setText(puan+"");
        layoutOlustur(level.getSatirSutun());

        butonOlustur(level.getSatirSutun(),level.getParams());

        renkAta(level.getSatirSutun(),level.getRenkR(),level.getRenkG(),level.getRenkB());

        rengiBul(level.isKoyuMu());

        if(level.isKoyuMu()){
            imageView.setImageResource(R.drawable.enkoyu);
        }else{
            imageView.setImageResource(R.drawable.enparlak);
        }
    }


    private void layoutOlustur(int boyut) {

        gridLayout = (GridLayout) findViewById(R.id.grid);
        gridLayout.setColumnCount(boyut);
        gridLayout.setRowCount(boyut);
    }


    private void butonOlustur(int boyut, int param) {

        ActionBar.LayoutParams params = new ActionBar.LayoutParams(param,param);
        butonDizisi = new Button[boyut * boyut];
        for (int i = 0; i < butonDizisi.length; i++) {
            butonDizisi[i] = new Button(this);
            butonDizisi[i].setPadding(10, 10, 10, 10);

            params.setMargins(5, 5, 5, 5);

            gridLayout.addView(butonDizisi[i], params);

        }
    }


    private void renkAta(int boyut,int R,int G,int B) {

        Random rd = new Random();
        renkDizisi = new int[boyut*boyut];
        for (int i = 0; i < renkDizisi.length; i++) {
            if(bolum > 5){
                renkDizisi[i] = rd.nextInt(100)+ 150;
                butonDizisi[i].setBackgroundColor(Color.argb(renkDizisi[i], R, G, B));
            }else{
                renkDizisi[i] = rd.nextInt(10)*10 + 150;
                butonDizisi[i].setBackgroundColor(Color.argb(renkDizisi[i], R, G, B));
            }

        }

        renkKopya = Arrays.copyOf(renkDizisi, renkDizisi.length);
    }


    private void rengiBul(final boolean koyuMu) {

        for (int i = 0; i < butonDizisi.length; i++) {

            final int indis = i;
            Arrays.sort(renkDizisi);
            butonDizisi[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (renkKontrol(indis,koyuMu)) {
                        bolum++;
                        gridLayout.removeAllViews();
                        countDownTimer.cancel();
                        puan += (int)currentTime/200;
                        if(bolum > 12){
                            Intent i = new Intent(getApplicationContext(),sonuc.class);
                            i.putExtra("puan",puan+"");
                            startActivity(i);
                        }
                        oyunOlustur();
                    }
                    else{
                        countDownTimer.cancel();
                        timer(currentTime-2000);
                    }
                }
            });
        }
    }

    private boolean renkKontrol(int indis,boolean koyuMu) {
        if (koyuMu){
            if (renkDizisi[renkDizisi.length-1] == renkKopya[indis]) {
                return true;
            } else
                return false;

        }else{
            if (renkDizisi[0] == renkKopya[indis]) {
                return true;
            } else
                return false;
        }
    }


    void timer(long timer){
        time = (TextView) findViewById(R.id.time);
        countDownTimer = new CountDownTimer(timer, 1000) {
            public void onTick(long millisUntilFinished) {
                currentTime = millisUntilFinished;
                time.setText(""+millisUntilFinished / 1000);
            }

            public void onFinish() {
                Intent i = new Intent(getApplicationContext(),sonuc.class);
                i.putExtra("puan",puan+"");
                startActivity(i);

            }

        };
        countDownTimer.start();

    }



}

