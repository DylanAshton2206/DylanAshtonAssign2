package dylan.ashton.n01442206;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

public class DylanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dylan);
    }




    /* Override this method to inflate the overflow menu xml file.*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Get menu inflater object.
        MenuInflater menuInflater = getMenuInflater();

        // Inflate the custom overflow menu
        menuInflater.inflate(R.menu.overflow_activity, menu);

        return true;
    }



    /* When user select a menu item in the overflow menu xml file, this method will be invoked.*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Get clicked menu item id.
        int itemId = item.getItemId();
        // Get the text view object.
        TextView textView = findViewById(R.id.dylan_text);
        if(itemId == R.id.dylan_help)
        {
            GoToWebPage("https://www.youtube.com/");
        }else if(itemId == R.id.maker_name)
        {
            textView.setText(R.string.uid);
        }
        else if(itemId == R.id.pizza)
        {
            Toast.makeText(DylanActivity.this,
                    R.string.menu_pizza_toast,
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            startActivity(intent);
        }
        return true;
    }

    //functions

    public void GoToWebPage(String yourUrl) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(yourUrl));
        startActivity(intent);
    }
}
