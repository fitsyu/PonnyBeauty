package net.fitsyu.ponnybeauty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.ViewFlipper;

import adapter.ItemAdapter;


public class MainActivity extends AppCompatActivity {


    /**
     *
     * {
     * "itemID":"0912a1",
     * "itemName":"lipstick ijo",
     * "itemPrice":"50000",
     * "itemDescription":"bla-bla-bla",
     * "itemPictures":["","",""]
     * }
     *
     */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // setup slideshow
        Animation fadeIn, fadeOut;
        ViewFlipper flipper;

        flipper = (ViewFlipper) findViewById(R.id.promotedItems);
        fadeIn  = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);

        flipper.setInAnimation(fadeIn);
        flipper.setOutAnimation(fadeOut);

        flipper.setAutoStart(true);
        flipper.setFlipInterval(5000);
        flipper.startFlipping();


        // setup tabs
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec spec;

        spec = tabHost.newTabSpec("Lipstick");
        spec.setIndicator("Lipstick");
        spec.setContent(R.id.tab0);
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Eyelash");
        spec.setIndicator("Eyelash");
        spec.setContent(R.id.tab1);
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Powder");
        spec.setIndicator("Powder");
        spec.setContent(R.id.tab2);
        tabHost.addTab(spec);



        // gridview
        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new ItemAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
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


    public void showItemDetail(View v){
        startActivity(  new Intent(this, DetailsActivity.class)  );
    }

    public void showMirror(View v){
        startActivity(  new Intent(this, MakeUpActivity.class) );
    }
}
