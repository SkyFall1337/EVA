package hska.eva;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Luke on 10.01.2016.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    String[] tabtitlearray = {"Meine Gruppe", "Meine Bewertungen"};

    public ViewPagerAdapter(FragmentManager manager){

        super(manager);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0: return new FragmentGruppe();
            case 1: return new FragmentProfil();
        }

        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabtitlearray[position];
    }
}
