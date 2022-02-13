package dylan.ashton.n01442206;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class OrderActivity extends AppCompatActivity {

    ImageView pic;
    String choice;
    private CoordinatorLayout coordinatorlayout;
    public String pizzaPick;
    public String topping;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        coordinatorlayout = findViewById(R.id.dylan_layout);
        pic = findViewById(R.id.store_pic);
        choice = getIntent().getExtras().getString("choice");

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.overflow_activity, menu);
        return true;
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        num=1;
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio1:
                if (checked)
                    pizzaPick = "New York Style";
                    break;
            case R.id.radio2:
                if (checked)
                    pizzaPick = "Deep Dish";
                    break;
            case R.id.radio3:
                if (checked)
                    pizzaPick = "Thin Crusted";
                    break;
            case R.id.radio4:
                if (checked)
                    pizzaPick = "Panzerotti";
                    break;
        }
    }

    public void onRadioButtonClicked2(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        num=num+1;
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio1_1:
                if (checked)
                    pizzaPick = "Small "+pizzaPick;
                break;
            case R.id.radio2_1:
                if (checked)
                    pizzaPick = "Medium "+pizzaPick;
                break;
            case R.id.radio3_1:
                if (checked)
                    pizzaPick = "Large "+pizzaPick;
                break;
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        num=num+1;
        if(num>2){
            showSnackBar();
            num=-1;
        }
        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkbox_bacon:
                if (checked) {
                    topping="with Bacon";
                }
                break;
            case R.id.checkbox_tomato:
                if (checked) {
                    topping="with Tomato";
                }
                break;
            case R.id.checkbox_peppers:
                if (checked) {
                    topping="with Peppers";
                }
                break;
            case R.id.checkbox_cheese:
                if (checked) {
                    topping="with Cheese";
                }
                break;
        }
                //only one topping recorded
    }




    public void showSnackBar() {
        Snackbar snackbar = Snackbar.make(coordinatorlayout, "Continue to payment screen", Snackbar.LENGTH_INDEFINITE).setAction("Next Screen", v -> Pass());
        snackbar.show();
    }

    public void Pass() {
        Intent i = new Intent(OrderActivity.this, PaymentActivity.class);
        i.putExtra("choice", choice);
        i.putExtra("pizza", pizzaPick);
        i.putExtra("topping", topping);
        startActivity(i);
    }

    public void GoToWebPage(String yourUrl) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(yourUrl));
        startActivity(intent);
    }
    //menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        TextView textView = findViewById(R.id.dylan_text2);
        if (itemId == R.id.dylan_help) {
            GoToWebPage("https://www.youtube.com/");
        } else if (itemId == R.id.maker_name) {
            textView.setText(R.string.uid);
        } else if (itemId == R.id.pizza) {
            Toast.makeText(OrderActivity.this,
                    R.string.menu_pizza_toast,
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            startActivity(intent);
        }
        return true;
    }
}