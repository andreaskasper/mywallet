package com.plabsi.mywallet;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //return;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        android.webkit.WebView webView = (android.webkit.WebView) findViewById(R.id.WebView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new android.webkit.WebViewClient());
        /*webView.setWebViewClient(new android.webkit.WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (url_action(view, request.getUrl().toString()) == true) return true;
                return super.shouldOverrideUrlLoading(view, request);
            }
        });*/
        android.webkit.WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl("http://127.0.0.1:8082/mywallet/money.php");
    }

    public boolean url_action(WebView view, String url) {
        if (url.startsWith("share:")) {
            String shareBody = url.substring(6);
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "MyWallet");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "MyWallet teilen"));
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        /*getMenuInflater().inflate(R.menu.menu_activity_money, menu);*/
        //TODO: Muss wieder rein, wenn das Fragment wieder geht...
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_money) {
            android.webkit.WebView wv = (android.webkit.WebView) findViewById(R.id.WebView1);
            wv.loadUrl("http://127.0.0.1:8082/mywallet/money.php?t="+Math.random());
        } else if (id == R.id.nav_cards) {
            android.webkit.WebView wv = (android.webkit.WebView) findViewById(R.id.WebView1);
            wv.loadUrl("http://127.0.0.1:8082/mywallet/cards.php?t="+Math.random());
        } else if (id == R.id.nav_eintrittskarten) {
            android.webkit.WebView wv = (android.webkit.WebView) findViewById(R.id.WebView1);

            wv.loadUrl("http://127.0.0.1:8082/mywallet/tickets.php?t="+Math.random());
        } else if (id == R.id.nav_coupons) {
            android.webkit.WebView wv = (android.webkit.WebView) findViewById(R.id.WebView1);
            wv.loadUrl("http://127.0.0.1:8082/mywallet/coupons.php?t="+Math.random());
        } else if (id == R.id.nav_coupons_bk) {
            android.webkit.WebView wv = (android.webkit.WebView) findViewById(R.id.WebView1);
            wv.loadUrl("http://127.0.0.1:8082/mywallet/coupons_burgerking.php?t="+Math.random());
        } else if (id == R.id.nav_coupons_cf) {
            android.webkit.WebView wv = (android.webkit.WebView) findViewById(R.id.WebView1);
            wv.loadUrl("http://127.0.0.1:8082/mywallet/coupons_coffeefellows.php?t="+Math.random());


        } else if (id == R.id.nav_emergency) {
            android.webkit.WebView wv = (android.webkit.WebView) findViewById(R.id.WebView1);
            wv.loadUrl("http://127.0.0.1:8082/mywallet/emergency.php?t="+Math.random());
        } else if (id == R.id.nav_options) {
            android.webkit.WebView wv = (android.webkit.WebView) findViewById(R.id.WebView1);
            wv.loadUrl("http://127.0.0.1:8082/mywallet/options.php?t="+Math.random());


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
