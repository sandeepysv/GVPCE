package com.gvpce.gvpce;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String userName = "User Dashboard";
    GridLayout mainGrid;
    private FirebaseAuth auth;

    boolean twice;
    private String uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = headerView.findViewById(R.id.profile);

        View content = findViewById(R.id.content);
        mainGrid = content.findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);

        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser() != null) {
            uname = auth.getCurrentUser().getDisplayName();
        }
        navUsername.setText(uname);

        //get bundles that were passed
        Bundle bundle = getIntent().getExtras();

        if(bundle != null && bundle.isEmpty()){
            userName = "User Dashboard";
        }
        else{
            if (bundle != null) {
                if(bundle.containsKey("userName")) {
                    navUsername.setText(uname);
                    userName = uname;
                }
                else{  userName = "User Dashboard"; }
            }
        }

//        TextView textView = findViewById(R.id.textView3);
//        textView.setText(userName);
    }

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,content_page.class);
                    intent.putExtra("info",""+finalI);
                    startActivity(intent);

                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }

        if(twice)
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            System.exit(0);
        }
        twice = true;
        //super.onBackPressed();
        Toast.makeText(MainActivity.this,"Press BACK again to Exit",Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                twice = false;
            }
        },3000);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Toast.makeText(MainActivity.this,"Logged Out Successfully!",Toast.LENGTH_SHORT).show();
            auth.signOut();
            if(auth.getCurrentUser() == null)
            {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                finish();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent;

        switch (id) {
            case R.id.nav1:
                break;
            case R.id.nav2:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav2");
                startActivity(intent);
                break;
            case R.id.nav3:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav3");
                startActivity(intent);
                break;
            case R.id.nav4:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav4");
                startActivity(intent);
                break;
            case R.id.nav5:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav5");
                startActivity(intent);
                break;
            case R.id.nav6:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav6");
                startActivity(intent);
                break;
            case R.id.nav7:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav7");
                startActivity(intent);
                break;
            case R.id.nav8:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav8");
                startActivity(intent);
                break;
            case R.id.nav9:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav9");
                startActivity(intent);
                break;
            case R.id.nav10:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav10");
                startActivity(intent);
                break;
            case R.id.nav11:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav11");
                startActivity(intent);
                break;
            case R.id.nav12:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav12");
                startActivity(intent);
                break;
            case R.id.nav13:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav13");
                startActivity(intent);
                break;
            case R.id.nav14:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav14");
                startActivity(intent);
                break;
            case R.id.nav15:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav15");
                startActivity(intent);
                break;
            case R.id.nav16:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav16");
                startActivity(intent);
                break;
            case R.id.nav17:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav17");
                startActivity(intent);
                break;
            case R.id.nav18:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav18");
                startActivity(intent);
                break;
            case R.id.nav19:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav19");
                startActivity(intent);
                break;
            case R.id.nav20:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav20");
                startActivity(intent);
                break;
            case R.id.nav21:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav21");
                startActivity(intent);
                break;
            case R.id.nav22:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav22");
                startActivity(intent);
                break;
            case R.id.nav23:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav23");
                startActivity(intent);
                break;
            case R.id.nav24:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav24");
                startActivity(intent);
                break;
            case R.id.nav25:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav25");
                startActivity(intent);
                break;
            case R.id.nav26:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav26");
                startActivity(intent);
                break;
            case R.id.nav27:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav27");
                startActivity(intent);
                break;
            case R.id.nav28:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav28");
                startActivity(intent);
                break;
            case R.id.nav29:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav29");
                startActivity(intent);
                break;
            case R.id.nav30:
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav30");
                startActivity(intent);
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
