package aberimen.com.renkleralemi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class girisEkrani extends AppCompatActivity {
    Button basla,nasilOynanir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_ekrani);

        basla= (Button) findViewById(R.id.basla);
        nasilOynanir = (Button) findViewById(R.id.nasil);

        basla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

        nasilOynanir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),NasilOynanir.class);
                startActivity(i);
            }
        });
    }
}
