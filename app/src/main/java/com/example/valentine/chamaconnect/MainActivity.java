package com.example.valentine.chamaconnect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.ParseObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();



//        // Determine whether the current user is an anonymous user
//        if (ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser())) {
//            // If user is anonymous, send the user to LoginSignupActivity.class
//            Intent intent = new Intent(MainActivity.this,
//                    MainActivity.class);
//            startActivity(intent);
//            finish();
//        } else {
//            // If current user is NOT anonymous user
//            // Get current user data from Parse.com
//            ParseUser currentUser = ParseUser.getCurrentUser();
//            if (currentUser != null) {
//                // Send logged in users to Welcome.class
//                Intent intent = new Intent(MainActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            } else {
//                // Send user to LoginSignupActivity.class
//                Intent intent = new Intent(MainActivity.this,
//                        MainActivity.class);
//                startActivity(intent);
//                finish();
//            }}
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
}
