package cat.urv.deim.asm.p2.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        /*  handler post delayed,
            muestra activity actual,
            espera X segundos,pasa a la siguiente
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //despues X tiempo-ejecuta intent
                Intent intent = new Intent(SplashScreen.this, HelpScreen1.class);
                startActivity(intent);

            }
            //tiempo en miliSegundos
        },2000);
    }

}
