package dylan.ashton.n01442206;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


//Dylan Ashton n01442206 RNA
public class DylanActivity extends AppCompatActivity {
    private ImageButton Button1;
    private ImageButton Button2;
    private ImageButton Button3;
    private ImageButton Button4;
    private Button next;
    private String[] stores;
    private String choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dylan);
        stores=getResources().getStringArray(R.array.pizza_stores);

        Button1 = findViewById(R.id.pizza_pizza);    //Button 1
        Button1.setOnClickListener(view -> choice=stores[0]);

        Button2 = findViewById(R.id.pizza_73);    //Button 2
        Button2.setOnClickListener(view -> choice=stores[1]);

        Button3 = findViewById(R.id.pizza_hut);    //Button 3
        Button3.setOnClickListener(view -> choice=stores[2]);

        Button4 = findViewById(R.id.pizza_nova);    //Button 4
        Button4.setOnClickListener(view -> choice=stores[3]);

        next = findViewById(R.id.button); //next button
        next.setOnClickListener(view -> {
                    if (choice!=null) {
                        Toast.makeText(DylanActivity.this, choice, Toast.LENGTH_SHORT).show();
                        Pass();
                    }
        });


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

    public void GoToWebPage(String yourUrl) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(yourUrl));
        startActivity(intent);
    }
    public void Pass(){
        Intent i=new Intent(DylanActivity.this,OrderActivity.class);
        String Txt=choice;
        i.putExtra("choice",Txt);
        startActivity(i);
    }

}
