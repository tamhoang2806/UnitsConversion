package ca.bcit.comp2052.hoang4.unitsconversion;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import ca.bcit.comp2052.hoang.androidhelloworld.R;

public class MainActivity extends Activity implements OnItemSelectedListener ,  View.OnClickListener{
	protected List<String> mainSpinnerArr;
	protected List<String> weightArr;
	protected List<String> tempArr;
	protected List<String> lengthArr;
	protected Spinner mainSpinner, fromSpinner, toSpinner; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize 
        this.initializeArrs();
        //create list of string
        
        //assign arrays to spinners
        this.generateSpinner(R.id.spinner1,mainSpinnerArr);
        
        //spinner on selected
        mainSpinner = (Spinner) findViewById(R.id.spinner1);
        fromSpinner = (Spinner) findViewById(R.id.spinner2);
        toSpinner = (Spinner) findViewById(R.id.spinner3);
        
        mainSpinner.setOnItemSelectedListener(this);
        int mainPosition = mainSpinner.getSelectedItemPosition();
        switch (mainPosition) {
        case 0:
        	this.generateSpinner(R.id.spinner2,weightArr);
        	this.generateSpinner(R.id.spinner3,weightArr);
            break;
        case 1:
        	this.generateSpinner(R.id.spinner2,tempArr);
        	this.generateSpinner(R.id.spinner3,tempArr);
            break;
        case 2:
        	this.generateSpinner(R.id.spinner2,lengthArr);
        	this.generateSpinner(R.id.spinner3,lengthArr);
            break;
    	}
        Button button = (Button)findViewById(R.id.button1);

        button.setOnClickListener(this);
//        button.setOnClickListener(new android.view.View.OnClickListener() {
//           @Override
//           public void onClick(View arg0) {
//              EditText edit = (EditText)findViewById(R.id.editText1);
//              EditText edit2 = (EditText)findViewById(R.id.editText2);
//
//              TextView text = (TextView)findViewById(R.id.textView1);
//              String input = edit.getText().toString();
//              String input2 = edit2.getText().toString();
//              
//              double num = 0;
//              double num2 = 0;
//              try {
//                 num = Double.parseDouble(input);
//                 num2 = Double.parseDouble(input2);
//              } catch (NumberFormatException e) {
//                 input = "0";
//                 input2 = "0";
//              }
//              double total = num + num2;
//              text.setText(input + "+" + input2 + " = " + total);
//           }
//        });
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void generateSpinner(int spinner1,List<String> SpinnerArray)
    {
    	//string adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SpinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //get spinner
        Spinner mainSpinner = (Spinner) findViewById(spinner1);
        //add string adapter to the spinner
        mainSpinner.setAdapter(adapter);
    }
    public void initializeArrs()
    {
    	mainSpinnerArr = new ArrayList<String> ();
    	mainSpinnerArr.add("Weight");
    	mainSpinnerArr.add("Temperature");
    	mainSpinnerArr.add("Length");
    	weightArr = new ArrayList<String>();
    	weightArr.add("lb");
    	weightArr.add("kg");
    	tempArr	= new ArrayList<String>();
    	tempArr.add("F");
    	tempArr.add("C");
    	lengthArr = new ArrayList<String>();
    	lengthArr.add("miles");
    	lengthArr.add("km");
    }
    
    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
    	mainSpinner.setSelection(position);
    	fromSpinner.setSelection(position);
    	toSpinner.setSelection(position);
    }

    public void onNothingSelected(AdapterView<?> parentView) {
    }
    public double lbtokg(double input)
    {
    	double output = input / (double)2.2;
    	output = Math.round(output * 100.0) / 100.0;
    	return output;
    }


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		 EditText edit = (EditText)findViewById(R.id.editText1);

       TextView text = (TextView)findViewById(R.id.textView3);
       String input = edit.getText().toString();
       
       double num = 0;
       try {
          num = Double.parseDouble(input);
       } catch (NumberFormatException e) {
          input = "0";
       }
       text.setText(input + " " + num);
	}
}
