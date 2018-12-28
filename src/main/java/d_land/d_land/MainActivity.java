package d_land.d_land;


import android.Manifest;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonFlat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

import java.io.InputStream;

import d_land.d_land.Pages.CartesRestos;
import d_land.d_land.Pages.Contacts;
import d_land.d_land.Pages.Page1;
import d_land.d_land.Pages.Page10;
import d_land.d_land.Pages.Page11;
import d_land.d_land.Pages.Page12;
import d_land.d_land.Pages.Page2;
import d_land.d_land.Pages.Page3;
import d_land.d_land.Pages.Page4;
import d_land.d_land.Pages.Page5;
import d_land.d_land.Pages.Page6;
import d_land.d_land.Pages.Page7;
import d_land.d_land.Pages.Page8;
import d_land.d_land.Pages.Page9;
import d_land.d_land.Pages.Restos;

import static d_land.d_land.R.id.webview;


public class MainActivity extends AppCompatActivity {
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 400;
    private static final String TAG = "MainActivity";

    private WebView mWebView;
    DrawerLayout mDrawerLayout;
    // PROGRESSBAR
    LinearLayout chargebg;
    LinearLayout statut;
    LinearLayout MenuInfo;
    ProgressBar progressBar;
    TextView TextCharge;
    ImageView image;
    // PROGRESSBAR

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences =
                getSharedPreferences("my_preferences", MODE_PRIVATE);

        if(!preferences.getBoolean("onboarding_complete",false)){

            Intent onboarding = new Intent(this, OnboardingActivity.class);
            startActivity(onboarding);

            finish();
            return;
        }

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);
        image = (ImageView)findViewById(R.id.myFirstImage);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        chargebg = (LinearLayout) findViewById(R.id.ChargeBG);
        statut = (LinearLayout) findViewById(R.id.statut);
        MenuInfo = (LinearLayout) findViewById(R.id.MenuInfo);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mDrawerLayout.setStatusBarBackgroundColor(
                getResources().getColor(R.color.primary_dark));






        Button t1 = (Button) findViewById(R.id.button1);
        new DownloadImageFromInternet((ImageView) findViewById(R.id.btn1))
                .execute("http://d-land.alwaysdata.net/Pages/img/mobile/attenteW.png");
        t1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Page1.class));
                mDrawerLayout.closeDrawers();
            }
        });
        setFont(t1,"TypoGraphica.otf");
        Button t2 = (Button) findViewById(R.id.button2);
        new DownloadImageFromInternet((ImageView) findViewById(R.id.btn2))
                .execute("http://d-land.alwaysdata.net/Pages/img/mobile/meteoW.png");
        t2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Page2.class));
                mDrawerLayout.closeDrawers();
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fadeout);
                MenuInfo.startAnimation(animation);
                MenuInfo.setVisibility(View.INVISIBLE);
            }
        });

        Button t3 = (Button) findViewById(R.id.button3);
        new DownloadImageFromInternet((ImageView) findViewById(R.id.btn3))
                .execute("http://d-land.alwaysdata.net/Pages/img/mobile/rehabW.png");
        t3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Page3.class));
                mDrawerLayout.closeDrawers();
            }
        });

        Button t4 = (Button) findViewById(R.id.button4);
        new DownloadImageFromInternet((ImageView) findViewById(R.id.btn4))
                .execute("http://d-land.alwaysdata.net/Pages/img/mobile/programmeW.png");
        t4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Page4.class));
                mDrawerLayout.closeDrawers();
            }
        });

        Button t5 = (Button) findViewById(R.id.button5);
        new DownloadImageFromInternet((ImageView) findViewById(R.id.btn5))
                .execute("http://d-land.alwaysdata.net/Pages/img/mobile/horaireW.png");
        t5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Page5.class));
                mDrawerLayout.closeDrawers();
            }
        });

        Button t6 = (Button) findViewById(R.id.button6);
        new DownloadImageFromInternet((ImageView) findViewById(R.id.btn6))
                .execute("http://d-land.alwaysdata.net/Pages/img/mobile/restrictionW.png");
        t6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Page6.class));
                mDrawerLayout.closeDrawers();
            }
        });

        Button t7 = (Button) findViewById(R.id.button7);
        new DownloadImageFromInternet((ImageView) findViewById(R.id.btn7))
                .execute("http://d-land.alwaysdata.net/Pages/img/mobile/music.png");
        t7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Page7.class));
                mDrawerLayout.closeDrawers();
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fadeout);
                MenuInfo.startAnimation(animation);
                MenuInfo.setVisibility(View.INVISIBLE);
            }
        });



        Button t9 = (Button) findViewById(R.id.button9);
        new DownloadImageFromInternet((ImageView) findViewById(R.id.btn9))
                .execute("http://d-land.alwaysdata.net/Pages/img/mobile/jeuxW.png");
        t9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //PushLink.hasPendingUpdate();
                startActivity(new Intent(MainActivity.this, Page9.class));
                mDrawerLayout.closeDrawers();
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fadeout);
                MenuInfo.startAnimation(animation);
                MenuInfo.setVisibility(View.INVISIBLE);
            }
        });

        Button t10 = (Button) findViewById(R.id.button10);
        new DownloadImageFromInternet((ImageView) findViewById(R.id.btn10))
                .execute("http://d-land.alwaysdata.net/Pages/img/mobile/retourW.png");
        t10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mWebView.loadUrl("http://d-land.alwaysdata.net/V2");
                mDrawerLayout.closeDrawers();
            }
        });

        Button t11 = (Button) findViewById(R.id.button11);
        new DownloadImageFromInternet((ImageView) findViewById(R.id.btn11))
                .execute("http://d-land.alwaysdata.net/Pages/img/mobile/map.png");
        t11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WTMAP.class));
                mDrawerLayout.closeDrawers();
            }
        });

        Button t8 = (Button) findViewById(R.id.button8);
        new DownloadImageFromInternet((ImageView) findViewById(R.id.btn8))
                .execute("http://d-land.alwaysdata.net/Pages/img/mobile/tailleW.png");
        t8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Page8.class));
                mDrawerLayout.closeDrawers();
            }
        });
        Button tResto = (Button) findViewById(R.id.buttonInfo2);
        new DownloadImageFromInternet((ImageView) findViewById(R.id.btnInfo2))
                .execute("http://d-land.alwaysdata.net/Pages/img/mobile/info.png");
        tResto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, Restos.class)); //  Restos.class));

                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fadein);
                MenuInfo.startAnimation(animation);
                MenuInfo.setVisibility(View.VISIBLE);
            }
        });

        Button a12 = (Button) findViewById(R.id.buttonaff);
        new DownloadImageFromInternet((ImageView) findViewById(R.id.btnaff))
                .execute("http://d-land.alwaysdata.net/Pages/img/mobile/affluence.png");
        a12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //PushLink.hasPendingUpdate();
                startActivity(new Intent(MainActivity.this, Page10.class));
                mDrawerLayout.closeDrawers();
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fadeout);
                MenuInfo.startAnimation(animation);
                MenuInfo.setVisibility(View.INVISIBLE);
            }
        });
        Button a13 = (Button) findViewById(R.id.buttonEMT);
        new DownloadImageFromInternet((ImageView) findViewById(R.id.btnEMT))
                .execute("http://d-land.alwaysdata.net/Pages/img/mobile/EMT.png");
        a13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //PushLink.hasPendingUpdate();
                startActivity(new Intent(MainActivity.this, Page11.class));
                mDrawerLayout.closeDrawers();
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fadeout);
                MenuInfo.startAnimation(animation);
                MenuInfo.setVisibility(View.INVISIBLE);
            }
        });
        Button a14 = (Button) findViewById(R.id.buttonDTV);
        new DownloadImageFromInternet((ImageView) findViewById(R.id.btnDTV))
                .execute("http://d-land.alwaysdata.net/Pages/img/mobile/DTV.png");
        a14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //PushLink.hasPendingUpdate();
                startActivity(new Intent(MainActivity.this, Page12.class));
                mDrawerLayout.closeDrawers();
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fadeout);
                MenuInfo.startAnimation(animation);
                MenuInfo.setVisibility(View.INVISIBLE);
            }
        });
        Button a15 = (Button) findViewById(R.id.buttonRESTO);
        new DownloadImageFromInternet((ImageView) findViewById(R.id.btnRESTO))
                .execute("http://d-land.alwaysdata.net/Pages/img/mobile/resto.png");
        a15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //PushLink.hasPendingUpdate();
                startActivity(new Intent(MainActivity.this, CartesRestos.class));
                mDrawerLayout.closeDrawers();
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fadeout);
                MenuInfo.startAnimation(animation);
                MenuInfo.setVisibility(View.INVISIBLE);
            }
        });

        Button a17 = (Button) findViewById(R.id.buttonCONTACT);
        new DownloadImageFromInternet((ImageView) findViewById(R.id.btnCONTACT))
                .execute("http://d-land.alwaysdata.net/Pages/img/mobile/contact.png");
        a17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //PushLink.hasPendingUpdate();
                startActivity(new Intent(MainActivity.this, Contacts.class));
                mDrawerLayout.closeDrawers();
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fadeout);
                MenuInfo.startAnimation(animation);
                MenuInfo.setVisibility(View.INVISIBLE);
            }
        });
        Button CloseB = (Button) findViewById(R.id.CloseB);
        CloseB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //PushLink.hasPendingUpdate();
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fadeout);
                MenuInfo.startAnimation(animation);
                MenuInfo.setVisibility(View.INVISIBLE);
            }
        });
        Button Fermer = (Button) findViewById(R.id.InfoText);
        setFont(CloseB,"TypoGraphica.otf");
        setFont(Fermer,"TypoGraphica.otf");
        setFont(t1,"TypoGraphica.otf");
        setFont(t2,"TypoGraphica.otf");
        setFont(t3,"TypoGraphica.otf");
        setFont(t4,"TypoGraphica.otf");
        setFont(t5,"TypoGraphica.otf");
        setFont(t6,"TypoGraphica.otf");
        setFont(t7,"TypoGraphica.otf");
        setFont(t8,"TypoGraphica.otf");
        setFont(t9,"TypoGraphica.otf");
        setFont(t10,"TypoGraphica.otf");
        setFont(t11,"TypoGraphica.otf");
        setFont(a12,"TypoGraphica.otf");
        setFont(a13,"TypoGraphica.otf");
        setFont(a14,"TypoGraphica.otf");
        setFont(a15,"TypoGraphica.otf");
        setFont(a17,"TypoGraphica.otf");
        setFont(tResto,"TypoGraphica.otf");


        Button buttonOUVRIR = (Button) findViewById(R.id.MenuButton);

        buttonOUVRIR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.START);
            }
        });

       // new DownloadImageFromInternet((ImageView) findViewById(R.id.titlebg))
              //  .execute("http://d-land.alwaysdata.net/AppBG/header.png");
        //new DownloadImageFromInternet((ImageView) findViewById(R.id.menubg))
             //   .execute("http://d-land.alwaysdata.net/AppBG/bgmenu.png");







        new MainActivity.DownloadImageFromInternet((ImageView) findViewById(R.id.myFirstImage))
                .execute("http://d-land.alwaysdata.net/Splash.png");






        mWebView = (WebView) findViewById(webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        TextCharge = (TextView) findViewById(R.id.Textcharge);
        setFont(TextCharge,"TypoGraphica.otf");
        mWebView.loadUrl("http://d-land.alwaysdata.net/V2");
        mWebView.setWebViewClient(new MyWebViewClient());// magic here
        mWebView.getSettings().setAppCacheEnabled(false);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        mWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        mWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        mWebView.setWebChromeClient(new WebChromeClient(){
            public void onProgressChanged(WebView view, int newProgress){
                TextCharge.setText("Chargement... " + System.getProperty("line.separator")  + newProgress + " %");
                if(newProgress >= 72){
                    // Page loading finish
                    TextCharge.setText("Chargement des Horaires " + System.getProperty("line.separator") + newProgress + " %");
                }
                if(newProgress >= 75){
                    // Page loading finish
                    TextCharge.setText("Chargement des Temps d'attente " + System.getProperty("line.separator") + newProgress + " %");
                }
                if(newProgress >= 90){
                    // Page loading finish
                    TextCharge.setText("Chargement... " + System.getProperty("line.separator") + newProgress + " %");
                }
                if(newProgress == 99){
                    // Page loading finish

                    Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                            R.anim.fadeout);
                    chargebg.startAnimation(animation);
                }
                if(newProgress == 100){
                    // Page loading finish
                    progressBar.setVisibility(View.GONE);
                    TextCharge.setVisibility(View.GONE);
                    chargebg.setVisibility(View.GONE);
                    mWebView.setVisibility(View.VISIBLE);
                    statut.setVisibility(View.VISIBLE);
                    image.setVisibility(View.GONE);

                }

            }
        });
      /*  mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                SharedPreferences sharedPreferences =
                        PreferenceManager.getDefaultSharedPreferences(context);
                boolean sentToken = sharedPreferences
                        .getBoolean(QuickstartPreferences.SENT_TOKEN_TO_SERVER, false);
                if (sentToken) {

                } else {
                }
            }
        };
        if (checkPlayServices()) {
            // Start IntentService to register this application with GCM.
            Intent intent = new Intent(MainActivity.this, RegistrationIntentService.class);
            startService(intent);
        }*/

    }
    @Override
    protected void onResume() {
        super.onResume();


    }
    @Override
    protected void onPause() {

        super.onPause();
    }



    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onReceivedError(WebView view, int errorCode, String
                description, String failingUrl) {
            //do something on error
            view.loadUrl("file:///android_asset/index.html");
            //view.loadData("Your internet connection may be down? Please restart your app.", "text/html", "UTF-8");
        }
        // PROGRESSBAR
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.fadein);
            progressBar.setVisibility(View.VISIBLE);
            TextCharge.setVisibility(View.VISIBLE);
            chargebg.setVisibility(View.VISIBLE);
            image.setVisibility(View.VISIBLE);
            image.startAnimation(animation);
            mWebView.setVisibility(View.GONE);
            statut.setVisibility(View.GONE);
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
            TextCharge.setVisibility(View.GONE);
            chargebg.setVisibility(View.GONE);
            mWebView.setVisibility(View.VISIBLE);
            statut.setVisibility(View.VISIBLE);
            image.setVisibility(View.GONE);
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.fadeout);
            chargebg.startAnimation(animation);

        }

    }


    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Log.i(TAG, "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }




    public class WebAppInterface {

        Context mContext;
        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }
    }
    public void setFont(TextView textView, String fontName) {
        if(fontName != null){
            try {
                Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/" + fontName);
                textView.setTypeface(typeface);
            } catch (Exception e) {
                Log.e("FONT", fontName + " not found", e);
            }
        }
    }
    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
            return;
        }
       new AlertDialog.Builder(this)
                .setTitle("Attention!")
                .setMessage("Voulez-vous vraiment quitter l'application?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        MainActivity.super.onBackPressed();
                    }
                }).create().show();
    }
    private class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public DownloadImageFromInternet(ImageView imageView) {
            this.imageView = imageView;
            //   Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();  Entre guillemets: message de chargement IMAGE
        }

        protected Bitmap doInBackground(String... urls) {
            String imageURL = urls[0];
            Bitmap bimage = null;
            try {
                InputStream in = new java.net.URL(imageURL).openStream();
                bimage = BitmapFactory.decodeStream(in);

            } catch (Exception e) {
                Log.e("Error Message", e.getMessage());
                e.printStackTrace();
            }
            return bimage;
        }

        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }


}


