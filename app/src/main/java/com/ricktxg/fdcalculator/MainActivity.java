package com.ricktxg.fdcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

import com.ricktxg.fdcalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {




    private TextView previousCalculation;
    private EditText display;









    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); //This line hides actionbar
        setContentView(binding.getRoot());




        previousCalculation = findViewById(R.id.textView);
        display = findViewById(R.id.displayEditText);
        display.setShowSoftInputOnFocus(false);







    }

    private void  updateText(String strToAdd){

        String oldStr = display.getText() .toString();


        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);


        display.setText(String.format("%s%s%s", leftStr,strToAdd,rightStr));
        display.setSelection((cursorPos + strToAdd.length()));

    }


    public void  zeroBTNPush(View view){
        updateText(getResources() .getString(R.string.zeroText));
    }


    public void  oneBTNPush(View view){
        updateText(getResources() .getString(R.string.oneText));
    }


    public void  twoBTNPush(View view){
        updateText(getResources() .getString(R.string.twoText));
    }


    public void  threeBTNPush(View view){
        updateText(getResources() .getString(R.string.threeText));
    }


    public void  fourBTNPush(View view){
        updateText(getResources() .getString(R.string.fourText));
    }

    public void  fiveBTNPush(View view){
        updateText(getResources() .getString(R.string.fiveText));
    }


    public void  sixBTNPush(View view){
        updateText(getResources() .getString(R.string.sixText));
    }


    public void  sevenBTNPush(View view){
        updateText(getResources() .getString(R.string.sevenText));
    }


    public void  eightBTNPush(View view){
        updateText(getResources() .getString(R.string.eightText));
    }


    public void  nineBTNPush(View view){
        updateText(getResources() .getString(R.string.nineText));
    }


    public void  addBTNPush(View view){
        updateText(getResources() .getString(R.string.addText));
    }


    public void  subtractBTNPush(View view){
        updateText(getResources() .getString(R.string.subtractText));
    }


    public void  multiplyBTNPush(View view){
        updateText(getResources() .getString(R.string.multiplyText));
    }


    public void  divideBTNPush(View view){
        updateText(getResources() .getString(R.string.divideText));
    }

    public void  equalsBTNPush(View view){
        String userExp = display.getText().toString();

        previousCalculation.setText(userExp);

        userExp = userExp.replaceAll(getResources() .getString(R.string.divideText), "/");
        userExp = userExp.replaceAll(getResources() .getString(R.string.multiplyText), "*");
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());

    }

    public void  pointBTNPush(View view){
        updateText(getResources() .getString(R.string.decimalText));
    }

    public void  openBTNPush(View view) {
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }

    public void  closeBTNPush(View view){
        updateText(getResources() .getString(R.string.parenthesesCloseText));
    }


    public void  backBTNPush(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder)display.getText();
            selection.replace(cursorPos-1,cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }

    public void  clearBTNPush(View view){
        display.setText("");
        previousCalculation.setText("");
    }


    public void  piText(View view){
        updateText("pi");
    }
    public void  sqRootText(View view){
        updateText("√");
    }
    public void  xPowerYText(View view){
        updateText("^");
    }
    public void  eText(View view){
        updateText("e");
    }





}


