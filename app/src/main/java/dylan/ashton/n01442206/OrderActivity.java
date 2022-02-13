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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class OrderActivity extends AppCompatActivity {

    ImageView pic;
    String choice;
    private CoordinatorLayout coordinatorlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        pic = findViewById(R.id.store_pic);
        choice=getIntent().getExtras().getString("choice");
        coordinatorlayout = findViewById(R.id.dylan_layout);
        showSnackBar();

        if (choice.equals("pizzapizza")){
            pic.setImageResource(R.mipmap.pizzapizza);
        }
        if (choice.equals("pizzahut")){
            pic.setImageResource(R.mipmap.pizzahut);
        }
        if (choice.equals("pizzanova")){
            pic.setImageResource(R.mipmap.pizzanova);
        }
        if (choice.equals("pizza73")){
            pic.setImageResource(R.mipmap.pizza73);
        }
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
        TextView textView = findViewById(R.id.dylan_text2);
        if(itemId == R.id.dylan_help)
        {
            GoToWebPage("https://www.youtube.com/");
        }else if(itemId == R.id.maker_name)
        {
            textView.setText(R.string.uid);
        }
        else if(itemId == R.id.pizza)
        {
            Toast.makeText(OrderActivity.this,
                    R.string.menu_pizza_toast,
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            startActivity(intent);
        }
        return true;
    }
    public void showSnackBar() {
        Snackbar snackbar = Snackbar.make(coordinatorlayout, "Continue to payment screen", Snackbar.LENGTH_INDEFINITE).setAction("Next Screen", v -> Pass());
        snackbar.show();
    }
    public void Pass(){
        Intent i=new Intent(OrderActivity.this, PaymentActivity.class);
        String Txt=choice;
        i.putExtra("choice",Txt);
        startActivity(i);
    }

    public void GoToWebPage(String yourUrl) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(yourUrl));
        startActivity(intent);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_bacon:
                if (checked){

                }

            else{

                }
                break;
            case R.id.checkbox_tomato:
                if (checked){

                }
            else{

                }
                break;
            case R.id.checkbox_peppers:
                if (checked){

                }
                else{

                }
                break;
        }
    }
}