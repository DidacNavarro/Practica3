package cat.urv.deim.asm.p3.shared.ui.news;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import cat.urv.deim.asm.p2.common.R;

public class NewsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new NewsFragment())
                    .commitNow();
        }
    }
}
