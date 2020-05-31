package cat.urv.deim.asm.p2.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.LoginFilter;
import android.view.View;
import android.widget.Button;

import cat.urv.deim.asm.p2.common.ui.login.LoginActivity;

public class ErrorScreen extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_screen);

        button = (Button) findViewById(R.id.skipButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
            public void openLogin(){
                Intent intent = new Intent(ErrorScreen.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
