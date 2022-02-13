package dylan.ashton.n01442206;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//Dylan Ashton n01442206 RNA
public class CheckActivity extends AppCompatActivity {
    private CoordinatorLayout coordinatorlayout;
    String pizzaPick;
    String topping;
    String choice;
    ImageView pic;
    String name;
    String credit;
    String Order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        coordinatorlayout = findViewById(R.id.dylan_layout);
        pic = findViewById(R.id.store_pic3);
        choice = getIntent().getExtras().getString("choice");
        pizzaPick = getIntent().getExtras().getString("pizza");
        topping = getIntent().getExtras().getString("topping");
        name = getIntent().getExtras().getString("name");
        credit = getIntent().getExtras().getString("credit");
        Order=choice+" "+pizzaPick+" "+topping;

        TextView txt = findViewById(R.id.textView2);
        txt.setText(Order);

        if (choice.equals("pizzapizza")) {
            pic.setImageResource(R.mipmap.pizzapizza);
        }
        if (choice.equals("pizzahut")) {
            pic.setImageResource(R.mipmap.pizzahut);
        }
        if (choice.equals("pizzanova")) {
            pic.setImageResource(R.mipmap.pizzanova);
        }
        if (choice.equals("pizza73")) {
            pic.setImageResource(R.mipmap.pizza73);
        }
    }

    public void GoToWebPage(String yourUrl) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(yourUrl));
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.overflow_activity, menu);
        return true;
    }
    //menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        TextView textView = findViewById(R.id.dylan_text4);
        if (itemId == R.id.dylan_help) {
            GoToWebPage("https://www.youtube.com/");
        } else if (itemId == R.id.maker_name) {
            textView.setText(R.string.uid);
        } else if (itemId == R.id.pizza) {
            Toast.makeText(CheckActivity.this,
                    R.string.menu_pizza_toast,
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            startActivity(intent);
        }
        return true;
    }

    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(CheckActivity.this);
        builder.setTitle(R.string.co)
                .setMessage(R.string.confirm)
                .setCancelable(false)
                .setPositiveButton(R.string.y, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //go to main screen
                        Intent i = new Intent(CheckActivity.this, DylanActivity.class);
                        startActivity(i);
                    }
                })
                .setNegativeButton(R.string.n, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(CheckActivity.this,R.string.n,Toast.LENGTH_SHORT).show();
                    }
                });
        //Creating dialog box
        AlertDialog dialog  = builder.create();
        dialog.show();
    }

}