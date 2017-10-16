package cf.sadhu.scaleview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fragment> fragments = new ArrayList<>();
    private int index;
    private int REPLACE_FRAGMENT_NEXT = 1;
    private int REPLACE_FRAGMENT_NONE = -1;
    private int REPLACE_FRAGMENT_PREV = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fl_content, new HeightFragment());
        transaction.addToBackStack("height");
        transaction.commit();
        init();
    }

    private void init() {
        this.fragments.add(new HeightFragment());
        this.fragments.add(new WeightFragment());
        this.index = 0;
        replaceFragment(this.REPLACE_FRAGMENT_NONE);
    }


    private void replaceFragment(int order) {
        setTitle("完善资料" + String.valueOf(this.index + 1) + "/" + this.fragments.size());
        Fragment fragment = fragments.get(this.index);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (order == this.REPLACE_FRAGMENT_NEXT) {
            transaction.setCustomAnimations(R.anim.anim_next_enter, R.anim.anim_next_exit);
        } else if (order == this.REPLACE_FRAGMENT_PREV) {
            transaction.setCustomAnimations(R.anim.anim_prev_enter, R.anim.anim_prev_exit);
        }
        transaction.replace(R.id.fl_content, fragment);
        transaction.commit();
    }


    public void nextStep() {
        this.index++;
        replaceFragment(this.REPLACE_FRAGMENT_NEXT);
    }

    public void prevStep() {
        this.index--;
        replaceFragment(this.REPLACE_FRAGMENT_PREV);
    }
}
