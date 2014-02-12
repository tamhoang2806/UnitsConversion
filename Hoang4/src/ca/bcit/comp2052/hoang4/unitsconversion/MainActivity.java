package ca.bcit.comp2052.hoang4.unitsconversion;

import java.text.DecimalFormat;
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

public class MainActivity extends Activity implements OnItemSelectedListener ,  View.OnClickListener
{
	protected List<String> mainSpinnerArr;
	protected List<String> weightArr;
	protected List<String> tempArr;
	protected List<String> lengthArr;
	protected Spinner mainSpinner, fromSpinner, toSpinner; 
	public Converter conv;
	
//	protected int fromPosition, toPosition, mainPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conv = new Converter();
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
        
        //int fromPosition = fromSpinner.getSelectedItemPosition();
        //int toPosition = toSpinner.getSelectedItemPosition();

        //System.out.println(mainPosition + " " + toPosition + " " + fromPosition);
        
        Button button = (Button)findViewById(R.id.button1);

        button.setOnClickListener(this);
//        button.setOnClickListener(new android.view.View.OnClickListener() {
//           @Override
//           public void onClick(View arg0) {
//              EditText edit = (EditText)findViewById(R.id.editText1);
//
//              TextView text = (TextView)findViewById(R.id.textView3);
//              String input = edit.getText().toString();
//              int mainPosition = mainSpinner.getSelectedItemPosition();
//              int fromPosition = fromSpinner.getSelectedItemPosition();
//              int toPosition = toSpinner.getSelectedItemPosition();
//              
//              double num = 0;
//              double result = 0 ;
//              try {
//                 num = Double.parseDouble(input);
//                 if(fromPosition == toPosition)
//          		{
//          			result = num;
//          		}
// 	      	   else
// 	      	   {
// 	      		   if(mainPosition==0)
// 	      		   {
// 	      			   if(fromPosition == 0 && toPosition == 1)
// 	      			   {
// 	      				   result = this.lbtokg(num);
// 	      			   }
// 	      		   }
// 	      			   
// 	      	   }
//              } catch (NumberFormatException e) {
//                 input = "0";
//              }
//              text.setText(input+ " "+fromPosition+" "+toPosition+" " + num+" "+result );
//           }
//           public double lbtokg(double input)
//           {
//           	double output = input / (double)2.2 ;
//           	return output;
//           }
//        });
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void generateSpinner(int spinnerid,List<String> SpinnerArray)
    {
    	//string adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SpinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //get spinner
        Spinner mainSpinner = (Spinner) findViewById(spinnerid);
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
    	//fromSpinner.setSelection(position);
    	//toSpinner.setSelection(position);
    	switch (position) {
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
    	System.out.println(position);
    }

    public void onNothingSelected(AdapterView<?> parentView) {
    }
    @Override
    public void onClick(View arg0) {
       EditText edit = (EditText)findViewById(R.id.editText1);

       TextView text = (TextView)findViewById(R.id.textView3);
       String input = edit.getText().toString();
       int mainPosition = mainSpinner.getSelectedItemPosition();
       int fromPosition = fromSpinner.getSelectedItemPosition();
       int toPosition = toSpinner.getSelectedItemPosition();
       
       double num = 0;
       double result = 0 ;
       try {
          num = Double.parseDouble(input);
          if(fromPosition == toPosition)
   		{
   			result = num;
   		}
    	   else
    	   {
    		   if(mainPosition==0)
    		   {
    			   if(fromPosition == 0 && toPosition == 1)
    			   {
    				   result = conv.lbtokg(num);
    			   }
    			   else
    			   {
    				   result = conv.kgtolb(num);
    			   }
    		   }
    		   else if(mainPosition == 1)
    		   {
    			   if(fromPosition == 0 && toPosition == 1)
    			   {
    				   result = conv.ftoc(num);
    			   }
    			   else
    			   {
    				   result = conv.ctof(num);
    			   }
    		   }
    		   else
    		   {
    			   if(fromPosition == 0 && toPosition == 1)
    			   {
    				   result = conv.milestokm(num);
    			   }
    			   else
    			   {
    				   result = conv.kmtomiles(num);
    			   }
    		   }
    			   
    	   }
       } catch (NumberFormatException e) {
          input = "0";
       }

   		DecimalFormat df = new DecimalFormat("#.00");
       text.setText(input+ "  "+fromPosition+" "+toPosition+" " + num+" "+df.format(result) );
    }
}
