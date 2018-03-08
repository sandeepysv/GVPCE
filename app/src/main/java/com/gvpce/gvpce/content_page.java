package com.gvpce.gvpce;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

public class content_page extends AppCompatActivity{

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_page);

        String url = "http://gvpce.ac.in/";
        Intent intent;
        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);

        TextView txtInfo = findViewById(R.id.txtInfo);
        Toast.makeText(content_page.this, "Please Wait while it Loads!\nIf white screen persists for long time then go back and reload!",
                Toast.LENGTH_LONG).show();
        if(getIntent() != null)
        {
            String info = getIntent().getStringExtra("info");
            txtInfo.setText(info);
            switch (info) {
                case "0":
                    url = "http://gvpce.ac.in/acal.html";
                    break;
                case "1":
                    url = "http://gvpce.ac.in/feestruc.html";
                    break;
                case "2":
                    url = "https://www.onlinesbi.com/prelogin/icollecthome.htm?corpID=640261";
                    break;
                case "3":
                    url = "http://gvpce.ac.in/campusplace.html";
                    break;
                case "4":
                    url = "http://gvpce.ac.in/examinations.html";
                    break;
                case "5":
                    url = "https://gvpce.almaconnect.com/";
                    break;
                case "6":
                    url = "http://gvpce.ac.in/CollegeBrouchure.pdf";
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.parse(url), "application/pdf");
                    try{
                        webView.getContext().startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        //user does not have a pdf viewer installed
                    }
                    url = "http://gvpce.ac.in/";
                    break;
                case "7":
                    url = "http://gvpce.ac.in/contactus.html";
                    break;
                case "nav2":
                    url = "http://gvpce.ac.in/aboutus.html";
                    break;
                case "nav3":
                    url = "http://gvpce.ac.in/visionmission.html";
                    break;
                case "nav4":
                    url = "http://gvpce.ac.in/gbody.html";
                    break;
                case "nav5":
                    url = "http://gvpce.ac.in/admin.html";
                    break;
                case "nav6":
                    url = "http://gvpce.ac.in/naacaccre.html";
                    break;
                case "nav7":
                    url = "http://gvpce.ac.in/";
                    break;
                case "nav8":
                    url = "http://gvpce.ac.in/acacoun.html";
                    break;
                case "nav9":
                    url = "http://gvpce.ac.in/";
                    break;
                case "nav10":
                    url = "http://gvpce.ac.in/btechregsyl16-17&17-18.html";
                    break;
                case "nav11":
                    url = "http://gvpce.ac.in/INSTITUTIONHGHLIGHTS.pdf";
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.parse(url), "application/pdf");
                    try{
                        webView.getContext().startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        //user does not have a pdf viewer installed
                    }
                    url = "http://gvpce.ac.in/";
                    break;
                case "nav12":
                    url = "http://gvpce.ac.in/naacssr.pdf";
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.parse(url), "application/pdf");
                    try{
                        webView.getContext().startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        //user does not have a pdf viewer installed
                    }
                    url = "http://gvpce.ac.in/";
                    break;
                case "nav13":
                    url = "http://gvpce.ac.in/coursesoffered.html";
                    break;
                case "nav14":
                    url = "http://gvpce.ac.in/";
                    break;
                case "nav15":
                    url = "http://gvpce.ac.in/";
                    break;
                case "nav16":
                    url = "http://gvpce.ac.in/iqacmembers.html";
                    break;
                case "nav17":
                    url = "http://gvpce.ac.in/CFSRActivities.pdf";
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.parse(url), "application/pdf");
                    try{
                        webView.getContext().startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        //user does not have a pdf viewer installed
                    }
                    url = "http://gvpce.ac.in/";
                    break;
                case "nav18":
                    url = "http://gvpce.ac.in/cfi.pdf";
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.parse(url), "application/pdf");
                    try{
                        webView.getContext().startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        //user does not have a pdf viewer installed
                    }
                    url = "http://gvpce.ac.in/";
                    break;
                case "nav19":
                    url = "http://gvpce.ac.in/gvplias.pdf";
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.parse(url), "application/pdf");
                    try{
                        webView.getContext().startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        //user does not have a pdf viewer installed
                    }
                    url = "http://gvpce.ac.in/";
                    break;
                case "nav20":
                    url = "http://ieeesbgvp.zohosites.com/";
                    break;
                case "nav21":
                    url = "http://gvpce.ac.in/skill.html";
                    break;
                case "nav22":
                    url = "http://gvpce.ac.in/";
                    break;
                case "nav23":
                    url = "http://gvpce.ac.in/";
                    break;
                case "nav24":
                    url = "http://gvpce.ac.in/supervisors.html";
                    break;
                case "nav25":
                    url = "http://gvpce.ac.in/";
                    break;
                case "nav26":
                    url = "http://gvpce.ac.in/disvisitors.html";
                    break;
                case "nav27":
                    url = "http://gvpce.ac.in/DistinguishedAlumni.pdf";
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.parse(url), "application/pdf");
                    try{
                        webView.getContext().startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        //user does not have a pdf viewer installed
                    }
                    url = "http://gvpce.ac.in/";
                    break;
                case "nav28":
                    url = "http://gvpce.ac.in/gallery.html";
                    break;
                case "nav29":
                    url = "http://gvpce.ac.in/MandatoryDisclosure2016.pdf";
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.parse(url), "application/pdf");
                    try{
                        webView.getContext().startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        //user does not have a pdf viewer installed
                    }
                    url = "http://gvpce.ac.in/";
                    break;
                case "nav30":
                    url = "http://gvpce.ac.in/otherinst.html";
                    break;
            }
        }
        webView.loadUrl(url);
    }

}
