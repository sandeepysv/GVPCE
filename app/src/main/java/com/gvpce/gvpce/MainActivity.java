package com.gvpce.gvpce;

import android.annotation.SuppressLint;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private String userName = "User Dashboard";
    GridLayout mainGrid;
    RelativeLayout aboutContent;
    TextView textGrid,contentText;
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
        aboutContent = content.findViewById(R.id.aboutContent);
        contentText = aboutContent.findViewById(R.id.contentText);

        textGrid = content.findViewById(R.id.textGrid);

        setSingleEvent(mainGrid);
        //setSingleEvent(aboutContent);

//        mainGrid.setVisibility(View.INVISIBLE);
        mainGrid.setVisibility(View.VISIBLE);
        aboutContent.setVisibility(View.GONE);

        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser() != null) {
            uname = auth.getCurrentUser().getDisplayName();
        }

        navUsername.setText(uname);

        //get bundles that were passed
        Bundle bundle = getIntent().getExtras();

        if(bundle != null && bundle.isEmpty()) {
            userName = "User Dashboard";
        }
        else
        {
            if (bundle != null)
            {
                if(bundle.containsKey("userName"))
                {
                    navUsername.setText(uname);
                    userName = uname;
                }
                else
                {
                    userName = "User Dashboard";
                }
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

    @SuppressLint("SetTextI18n")
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent;

        switch (id) {
            case R.id.nav1:
                textGrid.setText("Home");
                mainGrid.setVisibility(View.VISIBLE);
                aboutContent.setVisibility(View.GONE);
                break;
            case R.id.nav2:
//                intent = new Intent(MainActivity.this,content_page.class);
//                intent.putExtra("info","nav2");
//                startActivity(intent);
                textGrid.setText("About Us");
                contentText.setText("\n\n\n\n\n\n\n\n\n\n\n\nThe GVP College of Engineering, Visakhapatnam started in 1996, has very quickly established itself as one of the most-preferred private engineering colleges in Andhra Pradesh. College has been accredited by NAAC in 2009 with an A grade (with a score of 3.47/4.00). The college has been sanctioned “Autonomous” status by the UGC and conferred by the affiliating University, JNT University, Kakinada in 2009.\n" +
                        "\n" +
                        "GVP College of Engineering has 7 UG Programs, 13 PG Programs and 8 Departments were recognized as Research Centers by the affiliated University, JNTU-K, Kakinada. All the 7 UG programmes are accredited by NBA and 5 of them are accredited as per Outcome Based Education (OBE) and 5 PG programs are applied for NBA as per OBE. \n" +
                        "\n" +
                        "Established Scientific & Industrial Research Centre (SIRC) recognized by Ministry of Science and Technology. College has granted TEQIP-II, S.C-1.2 Project to enhance PG Education and demand driven research and Innovation.\n" +
                        "\n" +
                        "GVP College of Engineering is Partner with Government of Andhra Pradesh and government of Germany (GTZ) in establishing and managing the Indo-German Institute of Advanced Technology, Visakhapatnam since 2005.\n" +
                        "\n" +
                        "GVP-Prof. V. Lakshmikantham Institute of Advanced Studies is in the College and Scholarships and expenses of the Institute are met from the Corpus of Rs. 2 Crores given for the development of Mathematical Sciences.\n" +
                        "\n" +
                        "Out of a total faculty strength of 280, 70 are Ph.Ds and 207 are with PG. 34 of the faculty are currently registered for Ph.Ds, 29 of them with our own faculty as guides/co-guides.");
                mainGrid.setVisibility(View.GONE);
                aboutContent.setVisibility(View.VISIBLE);
                break;
            case R.id.nav3:
                textGrid.setText("Vision & Mission");
                contentText.setText("\n\n\n\n\nVision\n" +
                        "\n" +
                        "To evolve into and sustain as a Centre of Excellence in Technological Education and Research with a  holistic approach.\n" +
                        "\n" +
                        " \n" +
                        "Mission\n" +
                        "\n" +
                        "To produce high quality engineering graduates with the requisite theoretical and practical knowledge and social awareness to be able to contribute effectively to the progress of the society through their chosen field of endeavor.\n" +
                        "\n" +
                        " \n" +
                        "To undertake Research & Development, and extension activities in the fields of Science and Engineering in areas of relevance for immediate application as well as for strengthening or establishing fundamental knowledge.");
//                intent = new Intent(MainActivity.this,content_page.class);
//                intent.putExtra("info","nav3");
//                startActivity(intent);
                mainGrid.setVisibility(View.GONE);
                aboutContent.setVisibility(View.VISIBLE);
                break;
            case R.id.nav4:
                textGrid.setText("Governing Body");
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav4");
                startActivity(intent);
                break;
            case R.id.nav5:
                textGrid.setText("Administration");
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav5");
                startActivity(intent);
                break;
            case R.id.nav6:
                textGrid.setText("Board of Studies");
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav6");
                startActivity(intent);
                break;
            case R.id.nav7:
                textGrid.setText("IT Faculty");
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav7");
                startActivity(intent);
                break;
            case R.id.nav8:
                textGrid.setText("GVP-LIAS");
                intent = new Intent(MainActivity.this,content_page.class);
                intent.putExtra("info","nav8");
                startActivity(intent);
                break;
            case R.id.nav9:
                textGrid.setText("Skill Development Activities");
//                intent = new Intent(MainActivity.this,content_page.class);
//                intent.putExtra("info","nav9");
//                startActivity(intent);
                contentText.setText("\n\n\n\nGVPCE  Leadership Role  for  Earliest Skill Development Center  in 2002\n"+
                                    "Skill Development centric Laboratory built at GVPCE in 2015\n"+
                                    "Recent Mobile App. Talent exhibited by Students of GVPCE\n"+
                                    "Center for Diagnostics & Condition Monitoring of Machinery\n"+
                                    "CNC Lathe (Tutor) Training Program\n");
                mainGrid.setVisibility(View.GONE);
                aboutContent.setVisibility(View.VISIBLE);
                break;
            case R.id.nav10:
                textGrid.setText("Research Supervisors");
//                intent = new Intent(MainActivity.this,content_page.class);
//                intent.putExtra("info","nav10");
//                startActivity(intent);
                contentText.setText("\n\n\n\n\n\n\n\n\n\n\n\n1\t Dr. ADITYA MUKHARJEE\tChemical\n" +
                        "2\tDr. V. DHARMA RAO\tChemical\n" +
                        "3\tDr. B SRINIVAS\tChemical\n" +
                        "4\tDr. M.S.N.  MURTHY\tChemical\n" +
                        "5\tDr. B  SRINIVASULU\tChemical\n" +
                        "6\tDr. C V  NAGESWARA  RAO\tChemical\n" +
                        "7\t Dr. K SIVA KUMAR\tChemical\n" +
                        "8\tDr. Rao Tatavarti\tCivil\n" +
                        "9\tDr. M  SRINIVAS\tCivil\n" +
                        "10\tDr. G PAPA RAO\tCivil\n" +
                        "11\tDr. M KISHORE KUMAR\tCivil\n" +
                        "12\tDr. L. VENKAT\tCivil\n" +
                        "13\tDr. P K SUBBA RAO\tCSE\n" +
                        "14\tDr. C SHANTHI\tCSE\n" +
                        "15\tDr. K B MADHURI\tCSE\n" +
                        "16\tDr.  N BALA SUBRAMANYAM\tECE\n" +
                        "17\tDr. M V S SAI RAM\tECE\n" +
                        "18\tDr. N DEEPIKA RANI\tECE\n" +
                        "19\tDr. CH. KUSUMA KUMARI\tECE\n" +
                        "20\tDr. K NARASIMHA RAO\tEEE\n" +
                        "21\t Dr.  C V K BHANU\tEEE\n" +
                        "22\tDr. A B. KOTESWARA RAO\tMechanical\n" +
                        "23\tDr. B V RAMANA MURTHY\tMechanical\n" +
                        "24\tDr.  B GOVINDA RAO\tMechanical\n" +
                        "25\tDr. SANJAY KUMAR\tMechanical\n" +
                        "26\tDr. Y SEETHA RAMA RAO\tMechanical\n" +
                        "27\t Dr. S RAMA KRISHNA\tMechanical\n" +
                        "28\tDr.  M PHANI KRISHNA KISHORE\tMaths\n" +
                        "29\tDr. J  VASUNDHARA  DEVI\tMaths\n" +
                        "30\tDr. R V G  RAVI KUMAR\tMaths\n" +
                        "31\t Dr. S.S.AYYAPPA  SASTRY\tMaths\n" +
                        "32\tDR Y V P K RAGHAVA\tPhysics\n" +
                        "33\tDr. B NAGARJUN\tPhysics\n" +
                        "34\tDr. R PRAVEENA\tPhysics\n" +
                        "35\tDr. N.S.S.V. Raja Rao\tPhysics\n" +
                        "36\tDR R RAM BABU\tChemistry\n" +
                        "37\t Dr. T MANIKYA SASTRY\tChemistry\n" +
                        "38\tDr. J RAVINDRANATH\tEnglish");
                mainGrid.setVisibility(View.GONE);
                aboutContent.setVisibility(View.VISIBLE);
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
