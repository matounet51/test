package d_land.d_land.Pages;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import d_land.d_land.R;


public class Page3 extends AppCompatActivity {
    private WebView mWebView;
    // PROGRESSBAR
    LinearLayout chargebg;
    ProgressBar progressBar;
    TextView TextCharge;
    // PROGRESSBAR
    TextView TextTitle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.pages);
        mWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl("http://d-land.alwaysdata.net/V2/Pages/rehabilitations.html");


        // PROGRESSBAR
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        chargebg = (LinearLayout) findViewById(R.id.ChargeBG);
        TextCharge = (TextView) findViewById(R.id.Textcharge);
        setFont(TextCharge,"TypoGraphica.otf");
        setFont(TextTitle,"TypoGraphica.otf");
        // PROGRESSBAR
        mWebView.getSettings().setAppCacheEnabled(false);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        mWebView.addJavascriptInterface(new Page3.WebAppInterface(this), "Android");
        mWebView.setWebViewClient(new Page3.MyWebViewClient());// magic here
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }
        });

        mWebView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        Button closeButton = (Button) findViewById(R.id.bClose);
        closeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO:
                // This function closes Activity Two
                // Hint: use Context's finish() method
                finish();
            }
        });
        TextTitle = (TextView) findViewById(R.id.title);
        TextTitle.setText("Réhabilitations");

        mWebView.setWebChromeClient(new WebChromeClient(){
            public void onProgressChanged(WebView view, int newProgress){
                TextCharge.setText(newProgress + "%");

                if(newProgress == 100){
                    // Page loading finish
                    TextCharge.setText(" ");
                }
            }
        });
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
            progressBar.setVisibility(View.VISIBLE);
            TextCharge.setVisibility(View.VISIBLE);
            chargebg.setVisibility(View.VISIBLE);
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
            TextCharge.setVisibility(View.GONE);
            chargebg.setVisibility(View.GONE);
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.fadeout);
            chargebg.startAnimation(animation);
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
    // PROGRESSBAR
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
}