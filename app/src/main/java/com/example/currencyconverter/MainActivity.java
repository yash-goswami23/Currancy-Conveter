package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    String[] item = {"kuwaiti dinar (kwd)","Omani rial (OMR)","US Dollar","Pound","Rupee"};
    final String KWD="Kuwaiti Dinar(KWD)",Euro="Euro",DOLLAR="US Dollar",POUND="Pound",RUPEE="India Rupee";
    EditText editValue;
    int num1,num2;
    AppCompatButton conBtn;
    TextView convertNum,convertValue1;
    Spinner spinner1,spinner2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        editValue = findViewById(R.id.editValue);
        conBtn = findViewById(R.id.convBtn);
        convertNum = findViewById(R.id.convertNum);
        convertValue1 = findViewById(R.id.convertValue1);

        spinner();
        conBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "click Btn", Toast.LENGTH_SHORT).show();
                btnMethod();
            }
        });
    }

    public void spinner(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(KWD);
        arrayList.add(Euro);
        arrayList.add(DOLLAR);
        arrayList.add(POUND);
        arrayList.add(RUPEE);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,arrayList);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                       String item = parent.getItemAtPosition(position).toString();
                        Log.d("Value ", " num1 : "+ position);
                        num1 = position;
//                        Toast.makeText(MainActivity.this, "click "+item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item2 = parent.getItemAtPosition(position).toString();
                Log.d("Value ", " num2 : "+ position);
                num2 = position;
//                Toast.makeText(MainActivity.this, "click "+item2, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    @SuppressLint("SetTextI18n")
    public void btnMethod(){


        Log.d("Value ", " num1 btn : "+ num1);
        Log.d("Value ", " num2 btn : "+ num2);

        int value = Integer.parseInt(editValue.getText().toString());
        cc C = new cc();
        if(num1 != num2 ) {
            if (num1 == 2 && num2 == 4) { //2 = dollar == 4 = Rupee (1)
                //Dollar To rs
                float dollar = C.DollarToRs(value);
                String Dollar = String.valueOf(dollar);
                convertValue1.setText("1 US Dollar = 83.03 Rupee");
                convertNum.setText(Dollar);
            } else if (num1 == 2 && num2 == 1) { //2 = dollar == 1 = euro (2)
                //Dollar To Euro
                float dollar = C.DollarToEuro(value);
                String Dollar = String.valueOf(dollar);
                convertValue1.setText("1 US Dollar = 0.91 Euro");
                convertNum.setText(Dollar);
            } else if (num1 == 2 && num2 == 0) { // 2 = dollar == 0 = dinar //(3)
                //Dollar To Dinar
                float dollar = C.DollarToDinar(value);
                String Dollar = String.valueOf(dollar);
                convertNum.setText(Dollar);
                convertValue1.setText("1 US Dollar = 0.31 Kuwaiti Dinar");
            } else if (num1 == 2 && num2 == 3) {// 2 = dollar == 3 = pound (4)
                //Dollar To Pound
                float dollar = C.DollarToPound(value);
                String Dollar = String.valueOf(dollar);
                convertNum.setText(Dollar);
                convertValue1.setText("1 US Dollar = 0.78 Pound");
            } else if (num1 == 4 && num2 == 2) { // 4 = rupee == 2 = euro (5)
                //Rs to Dollar
                float rs = C.RsToDollar(value);
                String Rs = String.valueOf(rs);
                convertNum.setText(Rs);
                convertValue1.setText("1 Rupee = 0.012 US Dollar");
            } else if (num1 == 4 && num2 == 0) { // 4 = Rupee == 0 = dinar (6)
                //Rs To Dinar
                float rs = C.RsToDinar(value);
                String RS = String.valueOf(rs);
                convertNum.setText(RS);
                convertValue1.setText("1 Rupee = 0.0037 Kuwaiti Dinar");
            } else if (num1 == 4 && num2 == 3) { // 4 = Rupee == 3 = pound (7)
                //Rs To pound
                float rs = C.RsToPound(value);
                String RS = String.valueOf(rs);
                convertNum.setText(RS);
                convertValue1.setText("1 Rupee = 0.0094 Pound");
            } else if (num1 == 4 && num2 == 1) { // 4 = Rupee == 1 = euro (8)
                //Rs To Euro
                float rs = C.RsToEuro(value);
                String RS = String.valueOf(rs);
                convertNum.setText(RS);
                convertValue1.setText("1 Rupee = 0.0011 Euro");
            } else if (num1 == 0 && num2 == 4) { // 0 = Dinar == 4 = Rupee (9)
                //dinar to rs
                float dinar = C.DinarToRs(value);
                String Dinar = String.valueOf(dinar);
                convertNum.setText(Dinar);
                convertValue1.setText("1 Kuwaiti Dinar = 270.16 Rupee");
            } else if (num1 == 0 && num2 == 1) { // 0 = dinar == 1 =  Euro (10)
                //dinar to Euro
                float dinar = C.DinarToEuro(value);
                String Dinar = String.valueOf(dinar);
                convertNum.setText(Dinar);
                convertValue1.setText("1 Kuwaiti Dinar = 2.96 Euro");
            } else if (num1 == 0 && num2 == 2) {// 0 dinar == 2 = dollar (11)
                //dinar to Dollar
                float dinar = C.DinarToDollar(value);
                String Dinar = String.valueOf(dinar);
                convertNum.setText(Dinar);
                convertValue1.setText("1 Kuwaiti Dinar = 3.25 Dollar");
            } else if (num1 == 0 && num2 == 3) { // 0 = dinar == 3 = pound (12)
                //dinar to pound
                float dinar = C.DinarToPound(value);
                String Dinar = String.valueOf(dinar);
                convertNum.setText(Dinar);
                convertValue1.setText("1 Kuwaiti Dinar = 2.55 Pound");
            } else if (num1 == 1 && num2 == 0) { // 1 = Euro == 0 = Dinar (13)
                //Euro to Dinar
                float euro = C.EuroToDinar(value);
                String Euro = String.valueOf(euro);
                convertNum.setText(Euro);
                convertValue1.setText("1 Euro = 0.34 Kumaiti Dinar");
            } else if (num1 == 1 && num2 == 2) { // 1 = Euro == 2 = Dollar (14)
                //Euro to Dollar
                float euro = C.EuroToDollar(value);
                String Euro = String.valueOf(euro);
                convertNum.setText(Euro);
                convertValue1.setText("1 Euro = 1.10 US Dollar");
            } else if (num1 == 1 && num2 == 3) { // 1 = Euro == 3 = Pound (15)
                //Euro to Pound
                float euro = C.EuroToPound(value);
                String Euro = String.valueOf(euro);
                convertNum.setText(Euro);
                convertValue1.setText("1 Euro = 0.86 Pound");
            } else if (num1 == 1 && num2 == 4) { // 1 = Euro == 4 = Rupee (16)
                //Euro to rs
                float euro = C.EuroToRs(value);
                String Euro = String.valueOf(euro);
                convertNum.setText(Euro);
                convertValue1.setText("1 Euro = 91.16 Rupee");
            } else if (num1 == 3 && num2 == 0) {// 3 = Pound == 0 = Dinar (17)
                //Pound to Dinar
                float pound = C.PoundToDinar(value);
                String Pound = String.valueOf(pound);
                convertNum.setText(Pound);
                convertValue1.setText("1 Pound = 0.39 Kumaiti Dinar ");
            } else if (num1 == 3 && num2 == 1) { // 3 = Pound == 1 = Euro (18)
                //Pound to Euro
                float pound = C.PoundToEuro(value);
                String Pound = String.valueOf(pound);
                convertNum.setText(Pound);
                convertValue1.setText("1 Pound = 1.16 Euro ");
            } else if (num1 == 3 && num2 == 2) {// 3 = Pound == 2 = Dollar (19)
                //Pound to Dollar
                float pound = C.PoundToDollar(value);
                String Pound = String.valueOf(pound);
                convertNum.setText(Pound);
                convertValue1.setText("1 Pound = 1.28 Dollar");
            } else if (num1 == 3 && num2 == 4) { // 3 = Pound == 4 = Rupee (20)
                //Pound to Rupee
                float pound = C.PoundToRs(value);
                String Pound = String.valueOf(pound);
                convertNum.setText(Pound);
                convertValue1.setText("1 Pound = 105.95 Rupee");
            }
        }else {
            Log.d("ifMethod","else Method");
            Toast.makeText(this, "Currency Are Same ", Toast.LENGTH_SHORT).show();
        }
    }
}
//0=dinar ..
//1=euro..
//2=dollar..
//3=pound..
//4=rs..