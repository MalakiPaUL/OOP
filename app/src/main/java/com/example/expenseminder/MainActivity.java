package com.example.expenseminder;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editProduct,editCost,editDate;
    Button btnSave;

    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myDb = new DatabaseHelper(this);

        builder = new AlertDialog.Builder(this);
        editProduct = (EditText)findViewById(R.id.eproduct);
        editCost = (EditText)findViewById(R.id.eCost);
        editDate = (EditText)findViewById(R.id.edate);
        btnSave = (Button) findViewById(R.id.btnSaved);
        AddData();
    }

    public void AddData(){
        btnSave = (Button) findViewById(R.id.btnSaved);
        btnSave.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                String txtProduct = editProduct.getText().toString();
                String txtCost = editCost.getText().toString();
                String txtDate = editDate.getText().toString();

                if(txtProduct == " " || txtCost == " " || txtDate == " "){
                    builder.setTitle("Alert!!")
                            .setMessage("Kindly provide your credentials for authentication. Your cooperation is greatly appreciated.")
                            .setCancelable(true)
                            .setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int z) {
                                    dialog.cancel();
                                }
                            })
                            .show();
                }
                else {
                    boolean isInserted = myDb.insertData(txtProduct, txtCost, txtDate);
                    if (isInserted = true) {
                        Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        editProduct.setText(" ");
                        editCost.setText(" ");
                        editDate.setText(" ");

                    } else {
                        Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

}