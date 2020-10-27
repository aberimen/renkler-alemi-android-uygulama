package aberimen.com.renkleralemi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class sonuc extends AppCompatActivity {
    TextView puan;
    Button tekrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);
        puan = (TextView) findViewById(R.id.puan);
        tekrar = (Button) findViewById(R.id.tekrar);

        Intent i = getIntent();
        puan.setText(i.getExtras().getString("puan"));

        tekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
