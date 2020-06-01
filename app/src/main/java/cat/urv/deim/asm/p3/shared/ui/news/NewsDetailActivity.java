/*package cat.urv.deim.asm.p3.shared.ui.news;

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
}*/

package cat.urv.deim.asm.p3.shared.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import cat.urv.deim.asm.p2.common.R;

class FragmentSecond extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.news_detail_activity,container,false);

        return view;
    }

}

