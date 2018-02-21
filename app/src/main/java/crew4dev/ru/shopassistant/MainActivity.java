package crew4dev.ru.shopassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editResult;
    EditText editPrice;
    EditText editWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editResult = findViewById(R.id.editResult);

        editPrice = findViewById(R.id.editPrice);
        editPrice.addTextChangedListener(new TextWatcher() {

            // the user's changes are saved here
            public void onTextChanged(CharSequence c, int start, int before, int count) {
                //mCrime.setTitle(c.toString());
                //editResult.setText("OK");
                calc();
            }

            public void beforeTextChanged(CharSequence c, int start, int count, int after) {
                // this space intentionally left blank
            }

            public void afterTextChanged(Editable c) {
                // this one too
            }
        });


        editWeight = findViewById(R.id.editWeight);
        editWeight.addTextChangedListener(new TextWatcher() {

            // the user's changes are saved here
            public void onTextChanged(CharSequence c, int start, int before, int count) {
                //mCrime.setTitle(c.toString());
                //editResult.setText("OK");
                calc();
            }

            public void beforeTextChanged(CharSequence c, int start, int count, int after) {
                // this space intentionally left blank
            }

            public void afterTextChanged(Editable c) {
                // this one too
            }
        });


    }

    protected int calc(){
        int res = 0;
        try {
            double price = Double.valueOf(editPrice.getText().toString());
            int weight = Integer.valueOf(editWeight.getText().toString());
            if(price > 0 && weight > 0 ) {
                res = (int) (price / weight * 1000);
            }
            else
                res = 0;
            editResult.setText(String.valueOf(res));
        } catch (Exception ex){
            ex.toString();
        }
        return res;
    }
}