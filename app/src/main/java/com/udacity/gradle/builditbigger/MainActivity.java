package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.udacityprojects.geonarz.jokeandroidlib.JokesActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void tellJoke(View view)
    {
        new EndpointsUITask(MainActivity.this).execute();
    }

    public static class EndpointsUITask extends Utils.EndpointsAsyncTask {
        private MainActivity activity;

        public EndpointsUITask(MainActivity activity) {
            this.activity = activity;
        }

        @Override
        protected void onPostExecute(String result) {
            Intent intent = new Intent(activity, JokesActivity.class);
            intent.putExtra("joke", result);
            activity.startActivity(intent);
        }
    }
}
