package grad.unb.br.appsocial.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.content.res.Configuration;

import grad.unb.br.appsocial.R;
import grad.unb.br.appsocial.activities.fragments.PlanejarFragment;
import grad.unb.br.appsocial.activities.fragments.FAssisFragment;
import grad.unb.br.appsocial.activities.fragments.CaravanaFragment;
import grad.unb.br.appsocial.controllers.ViewPagerAdapter;

public class TabActivityPage extends AppCompatActivity implements FloatingActionButton.OnClickListener {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Menu menuDrawer;
    private FloatingActionButton fabBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_main_layout);


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_tab_activity);
        menuDrawer = (Menu) findViewById(R.id.menu_drawer_operacional);


        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.hello_blank_fragment,
                R.string.app_name) {
            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                //getSupportActionBar().setTitle("TCHAU");
            }
            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
               //getSupportActionBar().setTitle("OI");
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PlanejarFragment(),"Planejar");
        //adapter.addFragment(new RoteiroFragment(),"Roteiro");
        adapter.addFragment(new CaravanaFragment(),"Caravana");
        adapter.addFragment(new FAssisFragment(),"F.Assis");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        fabBtn = (FloatingActionButton) findViewById(R.id.fab_btn);
        fabBtn.setOnClickListener(this);

        //verifyUserLevel();
    }

    private void verifyUserLevel(){

        //muda o app drawer
        NavigationView nv = (NavigationView) findViewById(R.id.nav_view);
        Menu men = nv.getMenu();
        MenuItem itm = men.findItem(R.id.menu_drawer_operacional);
        itm.setVisible(false);
        //invalidateOptionsMenu();
    }
    @Override
    public void onClick(View v) {
        Toast.makeText(this.getApplication(),"Flutuante!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }else if(item.getItemId() == R.id.notification_icon){
            Intent saida = new Intent(this,NotificationPage.class);
            startActivity(saida);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tab_menu_action_bar,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

}
