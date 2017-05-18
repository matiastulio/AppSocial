package grad.unb.br.appsocial.controllers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Tulio on 05/10/2016.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {


    ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> tabTitles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }




    public void addFragment(Fragment fragment,String title){
        fragments.add(fragment);
        tabTitles.add(title);

    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);
    }
}
