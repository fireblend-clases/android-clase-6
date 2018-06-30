package cenfotec.com.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager vp;
    PagerAdapter pa;
    PagerTabStrip pts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = findViewById(R.id.viewpager);
        pts = findViewById(R.id.strip);

        pa = new Adaptador(getSupportFragmentManager());

        vp.setAdapter(pa);

        vp.setOffscreenPageLimit(2);
    }

    private class Adaptador extends FragmentPagerAdapter{

        FragmentoUno f1;
        FragmentoDos f2;

        public Adaptador(FragmentManager fm){
            super(fm);

            f1 = new FragmentoUno();
            f2 = new FragmentoDos();
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0)
                return f1;
            else
                return f2;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position == 0)
                return "Lista";
            else
                return "Mapa";
        }
    }
}
