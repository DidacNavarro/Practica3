package cat.urv.deim.asm.p2.common;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HelpScreen3 extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen3);

        //revisa si la aplicacion se abre por primera vez
        SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);
        String FirstTime = preferences.getString("FirstTimeInstall", "" );

        if(FirstTime.equals("Yes")) {

            Intent intent = new Intent(HelpScreen3.this, LoginActivity.class);
            startActivity(intent);

        }
        else{
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("FirstTimeInstall", "Yes");
            editor.apply();
        }


        button = (Button) findViewById(R.id.skipButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //despues X tiempo-ejecuta intent
                Intent intent = new Intent(HelpScreen3.this, LoginActivity.class);
                startActivity(intent);

            }
            //tiempo en miliSegundos
        },2000);
    }

    public void openLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
