package dylan.ashton.n01442206;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {
    ImageView pic;
    String choice;
    private CoordinatorLayout coordinatorlayout;
    public String pizzaPick;
    public String topping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        coordinatorlayout = findViewById(R.id.dylan_layout);
        pic = findViewById(R.id.store_pic2);

        choice = getIntent().getExtras().getString("choice");
        pizzaPick = getIntent().getExtras().getString("pizza");
        topping = getIntent().getExtras().getString("topping");

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

        TextView textView2 = findViewById(R.id.text1);
        textView2.setText(choice+" "+pizzaPick+" "+topping);

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

        TextView textView = findViewById(R.id.dylan_text3);
        if (itemId == R.id.dylan_help) {
            GoToWebPage("https://www.youtube.com/");
        } else if (itemId == R.id.maker_name) {
            textView.setText(R.string.uid);
        } else if (itemId == R.id.pizza) {
            Toast.makeText(PaymentActivity.this,
                    R.string.menu_pizza_toast,
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            startActivity(intent);
        }
        return true;
    }
    /*
    public void Pass() {
        Intent i = new Intent(OrderActivity.this, PaymentActivity.class);
        i.putExtra("choice", choice);
        i.putExtra("pizza", pizzaPick);
        i.putExtra("topping", topping);
        startActivity(i);
    }*/
}