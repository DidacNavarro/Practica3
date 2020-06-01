package cat.urv.deim.asm.p2.common;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HelpScreen1 extends AppCompatActivity {

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen1);


        /*

        //revisa si la aplicacion se abre por primera vez
        SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);
        String FirstTime = preferences.getString("FirstTimeInstall", "" );

        if(FirstTime.equals("Yes")) {

            Intent intent = new Intent(HelpScreen1.this, HelpScreen2.class);
            startActivity(intent);

        }
        else{
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("FirstTimeInstall", "Yes");
            editor.apply();
    }

*/



       /* button = (Button) findViewById(R.id.skipButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
            public void openLogin(){
                Intent intent = new Intent(HelpScreen1.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });*/


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //despues X tiempo-ejecuta intent
                Intent intent = new Intent(HelpScreen1.this, HelpScreen2.class);
                startActivity(intent);

            }
            //tiempo en miliSegundos
        },2000);


}}
